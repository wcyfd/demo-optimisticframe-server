package com.randioo.demo_optimisticframe_server.module.fight.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.Lock;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.entity.po.Game;
import com.randioo.demo_optimisticframe_server.entity.po.GameInfo;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightGameOverResponse;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightLoadCompleteResponse;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightReceiveHitGameControlResponse;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightReceivePlaneGameControlResponse;
import com.randioo.demo_optimisticframe_server.protocal.Fight.Frame;
import com.randioo.demo_optimisticframe_server.protocal.Fight.RoleInfo;
import com.randioo.demo_optimisticframe_server.protocal.Fight.SCFightGameOver;
import com.randioo.demo_optimisticframe_server.protocal.Fight.SCFightLoadResource;
import com.randioo.demo_optimisticframe_server.protocal.Fight.SCFightSendKeyFrame;
import com.randioo.demo_optimisticframe_server.protocal.Fight.SCFightStartGame;
import com.randioo.demo_optimisticframe_server.protocal.Game.GameAction;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.demo_optimisticframe_server.utils.Utils;
import com.randioo.randioo_server_base.cache.SessionCache;
import com.randioo.randioo_server_base.entity.ActionQueue;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.module.match.Matchable;
import com.randioo.randioo_server_base.utils.game.IdCreator;
import com.randioo.randioo_server_base.utils.game.game_type.GameBase;
import com.randioo.randioo_server_base.utils.game.game_type.GameHandler;
import com.randioo.randioo_server_base.utils.game.game_type.real_time_strategy_game.LogicFrame;
import com.randioo.randioo_server_base.utils.game.game_type.real_time_strategy_game.RTSGameStarter;
import com.randioo.randioo_server_base.utils.game.game_type.real_time_strategy_game.RateFrameMeter;
import com.randioo.randioo_server_base.utils.template.Function;

public class FightServiceImpl extends BaseService implements FightService {

	private RTSGameStarter gameStarter;

	public void setGameStarter(RTSGameStarter gameStarter) {
		this.gameStarter = gameStarter;
	}

	private RateFrameMeter rateFrameMeter;

	public void setRateFrameMeter(RateFrameMeter rateFrameMeter) {
		this.rateFrameMeter = rateFrameMeter;
	}

	private IdCreator idCreator;

	public void setIdCreator(IdCreator idCreator) {
		this.idCreator = idCreator;
	}

	@Override
	public void init() {
		gameStarter.setGameHandler(new GameHandler() {

			@Override
			public void gameLogic(GameBase gameBase) {
				Game game = (Game) gameBase;
				runGameLogic(game);
			}

		});

	}

	@Override
	public void loadResource(int playCount, List<? extends Matchable> matchables) {
		int randSeed = Utils.getRandomNum(1, 100);
		System.out.println("loadResource");

		// 游戏初始化
		this.serverGameInit(playCount, matchables);

		try {
			for (int i = 0; i < matchables.size(); i++) {
				Role targetRole = (Role) matchables.get(i);
				SCFightLoadResource.Builder scFightLoadResource = SCFightLoadResource.newBuilder().setIndex(i)
						.setRandSeed(randSeed);
				for (Matchable matchable : matchables) {
					Role role = (Role) matchable;
					RoleInfo.Builder roleInfoBuilder = RoleInfo.newBuilder().setName(role.getName())
							.setRoleId(role.getRoleId());
					for (int index = 1; index <= role.getUsePlanes().size(); index++) {
						roleInfoBuilder.addUsePlanes(role.getUsePlanes().get(index));
					}

					scFightLoadResource.addRoleInfos(roleInfoBuilder);
				}

				IoSession session = SessionCache.getSessionById(targetRole.getRoleId());
				System.out.println("roleId:" + targetRole.getRoleId() + "开始加载资源");
				if (session != null) {
					session.write(SCMessage.newBuilder().setScFightLoadResource(scFightLoadResource).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void loadComplete(Role role, IoSession session) {
		try {
			session.write(SCMessage
					.newBuilder()
					.setFightLoadCompleteResponse(
							FightLoadCompleteResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS)).build());

			role.setPrepare(true);
			Game game = (Game) role.getGame();

			// 检查全部都准备完毕
			boolean allReadyComplete = false;
			for (Role r : game.getRoleMap().values()) {
				allReadyComplete = r.isPrepare();
			}

			if (allReadyComplete) {
				// 重置准备完毕的标记
				for (Role r : game.getRoleMap().values()) {
					r.setPrepare(false);
				}

				for (Role r : game.getRoleMap().values()) {
					IoSession s = SessionCache.getSessionById(r.getRoleId());
					if (s != null) {
						s.write(SCMessage.newBuilder().setScFightStartGame(SCFightStartGame.newBuilder()).build());
					}
				}

				this.startGame((Game) role.getGame());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Game serverGameInit(int playCount, List<? extends Matchable> matchables) {
		Game game = new Game(playCount, 60 * 3, 5, 50);
		game.setGameId(idCreator.getId());

		for (Matchable matchable : matchables) {
			Role role = (Role) matchable;
			GameInfo gameInfo = new GameInfo();
			gameInfo.setRoleId(role.getRoleId());
			game.getRoleMap().put(role.getRoleId(), role);
			game.getGameInfoMap().put(role.getRoleId(), gameInfo);

			role.setGame(game);
		}

		return game;
	}

	private void startGame(Game game) {
		int frameCountInOneSecond = game.getFrameCountInOneSecond();
		game.setStart(true);
		int deltaTime = 1000 / frameCountInOneSecond;
		System.out.println("deltaTime:" + deltaTime);

		int keyFrameTime = deltaTime * game.getAddDeltaFrame();

		gameStarter.startRTSGame(game, keyFrameTime);
	}

	@Override
	public void runGameLogic(Game game) {
		// 关键帧发送该帧所有信息
		try {
			// 如果没有设置游戏开始时间，则设置开始时间，该值只赋值一次
			if (!game.isHasStartTime()) {
				game.setStartTime(System.currentTimeMillis());
				game.setHasStartTime(true);
			}
			// // 游戏时间到了，发送游戏结束
			// if (getCurrentFrameIndex(game) >= game.getFrameCountInOneSecond()
			// * game.getTotalTime()) {
			//
			// sendEnd(game);
			//
			// return;
			// }

			// 发送关键帧内所有操作信息
			sendKeyFrameInfo(game);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void receive_HitGame_ControlInfo(Role role, int enemyId) {
		Game game = (Game) role.getGame();
		if (game == null || game.isEnd()) {
			return;
		}
		try {
			SCMessage sc = SCMessage
					.newBuilder()
					.setFightReceiveHitGameControlResponse(
							FightReceiveHitGameControlResponse.newBuilder().setSuccess(ErrorCode.SUCCESS)).build();
			IoSession session = SessionCache.getSessionById(role.getRoleId());
			session.write(sc);

			GameAction gameAction = GameAction.newBuilder()./*
															 * setEnemyId(enemyId
															 * ).setRoleId(role.
															 * getRoleId()).
															 */build();

			int currentFrame = this.getCurrentFrameIndex(game);

			// 将事件和当前的帧数加入到队列中，延迟执行帧数目前设为0
			ActionQueue queue = game.getActionQueue();
			queue.add(gameAction, currentFrame, 0);
			System.out.println("queue size:" + queue.size());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void receive_PlaneGame_ControlInfo(Role role, GeneratedMessage gameActionMessage) {
		Game game = (Game) role.getGame();
		if (game == null || game.isEnd()) {
			return;
		}
		try {
			SCMessage sc = SCMessage
					.newBuilder()
					.setFightReceivePlaneGameControlResponse(
							FightReceivePlaneGameControlResponse.newBuilder().setSuccess(ErrorCode.SUCCESS)).build();
			IoSession session = SessionCache.getSessionById(role.getRoleId());
			session.write(sc);

			int currentFrame = this.getCurrentFrameIndex(game);

			// 将事件和当前的帧数加入到队列中，延迟执行帧数目前设为0
			ActionQueue queue = game.getActionQueue();
			queue.add(gameActionMessage, currentFrame, 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getCurrentFrameIndex(Game game) {
		long startTime = game.getStartTime();
		long nowTime = System.currentTimeMillis();
		// 获得游戏开始到现在的时间毫秒间隔
		long deltaTime = nowTime - startTime;
		// 获得每帧的需要的毫秒数量
		long oneFrameMilliSecond = 1000 / game.getFrameCountInOneSecond();
		// 毫秒间隔除以每帧毫秒数量去整获得第几帧
		int currentFrame = (int) (deltaTime / oneFrameMilliSecond);

		return currentFrame;
	}

	/*
	 * @Override public void sendKeyFrameInfo(Game game) { ActionQueue
	 * actionQueue = game.getActionQueue(); List<GameEvent> gameEvents =
	 * actionQueue.pollAll(game.getNextFrameNumber()); // 整合消息
	 * SCFightSendKeyFrame.Builder message = SCFightSendKeyFrame.newBuilder();
	 * for (int frame = game.getFrameNumber(); frame <
	 * game.getNextFrameNumber(); frame++) { Frame.Builder frameBuilder =
	 * Frame.newBuilder(); frameBuilder.setFrameIndex(frame); for (int j = 0; j
	 * < gameEvents.size(); j++) { GameEvent gameEvent = gameEvents.get(j); int
	 * frameIndex = gameEvent.getExecuteFrameIndex(); if (frameIndex == frame) {
	 * GameAction gameAction = (GameAction) gameEvent.getAction();
	 * frameBuilder.addGameActions(gameAction); } }
	 * message.addFrames(frameBuilder); }
	 * game.setFrameNumber(game.getNextFrameNumber());
	 * game.setNextFrameNumber(game.getNextFrameNumber() +
	 * game.getAddDeltaFrame()); SCMessage sc =
	 * SCMessage.newBuilder().setScFightSendKeyFrame(message).build(); //
	 * 向各用户发送消息 for (Role role : game.getRoleMap().values()) { IoSession session
	 * = SessionCache.getSessionById(role.getRoleId()); if (session != null)
	 * session.write(sc); } }
	 */
	@Override
	public void sendKeyFrameInfo(final Game game) {
		// send1(game);
		send2(game);
	}

	// private void send1(final Game game){
	// ActionQueue actionQueue = game.getActionQueue();
	// List<GameEvent> gameEvents =
	// actionQueue.pollAll(game.getNextFrameNumber());
	//
	// // 整合消息
	// SCFightSendKeyFrame.Builder message = SCFightSendKeyFrame.newBuilder();
	//
	// for (int frame = game.getFrameNumber(); frame <
	// game.getNextFrameNumber(); frame++) {
	//
	// Frame.Builder frameBuilder = Frame.newBuilder();
	// frameBuilder.setFrameIndex(frame);
	// for (int j = 0; j < gameEvents.size(); j++) {
	// GameEvent gameEvent = gameEvents.get(j);
	// int frameIndex = gameEvent.getExecuteFrameIndex();
	// if (frameIndex == frame) {
	// GameAction gameAction = (GameAction) gameEvent.getAction();
	// frameBuilder.addGameActions(gameAction);
	// }
	// }
	// message.addFrames(frameBuilder);
	//
	// }
	//
	// game.setFrameNumber(game.getNextFrameNumber());
	// game.setNextFrameNumber(game.getNextFrameNumber() +
	// game.getAddDeltaFrame());
	// SCMessage sc =
	// SCMessage.newBuilder().setScFightSendKeyFrame(message).build();
	//
	// // 向各用户发送消息
	// for (Role role : game.getRoleMap().values()) {
	// IoSession session = SessionCache.getSessionById(role.getRoleId());
	// if (session != null)
	// session.write(sc);
	// }
	// }

	private void send2(final Game game) {
		rateFrameMeter.sendKeyFrame(game, new Function() {

			@Override
			public Object apply(Object... params) {
				@SuppressWarnings("unchecked")
				List<LogicFrame> logicFrames = (List<LogicFrame>) params[0];

				SCFightSendKeyFrame.Builder message = SCFightSendKeyFrame.newBuilder();

				for (LogicFrame logicFrame : logicFrames) {
					Frame.Builder frameBuilder = Frame.newBuilder();
					frameBuilder.setFrameIndex(logicFrame.getFrameIndex());
					for (Object object : logicFrame.getGameActions()) {
						GameAction gameAction = (GameAction) object;
						frameBuilder.addGameActions(gameAction);
					}

					message.addFrames(frameBuilder);
				}

				SCMessage sc = SCMessage.newBuilder().setScFightSendKeyFrame(message).build();

				// 向各用户发送消息
				for (Role role : game.getRoleMap().values()) {
					IoSession session = SessionCache.getSessionById(role.getRoleId());
					if (session != null)
						session.write(sc);
				}

				return null;
			}

		});
	}

	@Override
	public void offline(Role role) {

		Game game = (Game) role.getGame();
		if (game == null || game.isEnd())
			return;

		Lock lock = game.getLock();
		lock.lock();
		try {
			if (game.isEnd())
				return;
			// 如果有一个人还在线这不算游戏结束
			boolean bothOffline = true;
			for (Role r : game.getRoleMap().values()) {
				IoSession session = SessionCache.getSessionById(r.getRoleId());
				if (session != null && session.isConnected()) {
					bothOffline = false;
				}
			}
			// 如果都掉线这游戏结束
			if (bothOffline) {
				gameOver(role, 0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void gameOver(Role role, int score, IoSession session) {
		session.write(SCMessage.newBuilder().setFightGameOverResponse(FightGameOverResponse.newBuilder()).build());
		this.gameOver(role, score);

	}

	/**
	 * 游戏结束接口
	 * 
	 * @param role
	 * @param score
	 * @author wcy 2016年12月22日
	 */
	@Override
	public void gameOver(Role role, int score) {
		Game game = (Game) role.getGame();

		if (game == null || game.isEnd()) {
			return;
		}

		// 设置该玩家游戏结束
		GameInfo gameInfo = game.getGameInfoMap().get(role.getRoleId());
		gameInfo.setEnd(true);
		// 设置分数
		gameInfo.setScore(score);
		Lock lock = game.getLock();
		lock.lock();
		try {
			if (game.isEnd())
				return;

			// 查看两个人是否都已经发送比赛结束，另一个人断线的话默认算发来此人结束

			boolean isEnd = true;
			// 本局分数，拿两者最高分
			int _score = 0;
			for (Role r : game.getRoleMap().values()) {
				int roleId = r.getRoleId();
				boolean endTag = game.getGameInfoMap().get(roleId).isEnd();

				int s = game.getGameInfoMap().get(roleId).getScore();
				_score = s > _score ? s : _score;
				IoSession iosession = SessionCache.getSessionById(roleId);

				// 如果连接断开，则标记为真
				if (iosession == null || !iosession.isConnected()) {
					endTag = true;
				}
				isEnd &= endTag;
			}
			// 如果结束了
			if (isEnd) {
				Map<Integer, Role> roleMap = game.getRoleMap();
				for (Role r : roleMap.values()) {
					// 如果是最好成绩则赋值
					r.setScore(score > r.getScore() ? score : r.getScore());
					// 游戏赋值空
					r.setGame(null);

					IoSession session = SessionCache.getSessionById(r.getRoleId());
					if (session != null) {
						session.write(SCMessage.newBuilder()
								.setScFightGameOver(SCFightGameOver.newBuilder().setScore(_score)).build());
					}
				}
				game.setEnd(true);
				ScheduledFuture<?> future = game.getScheduledFuture();
				if (future != null)
					future.cancel(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
