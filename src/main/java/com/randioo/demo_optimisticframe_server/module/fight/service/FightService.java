package com.randioo.demo_optimisticframe_server.module.fight.service;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.Game;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;
import com.randioo.randioo_server_base.utils.game.matcher.MatchInfo;

public interface FightService extends BaseServiceInterface {

	public void loadComplete(Role role, IoSession session);

	public void loadResource(MatchInfo matchInfo);

	public void receive_HitGame_ControlInfo(Role role, int enemyId);

	public void receive_PlaneGame_ControlInfo(Role role,GeneratedMessage gameActionMessage);
	/**
	 * 发送关键帧信息
	 * 
	 * @param game
	 * @author wcy 2016年11月24日
	 */
	void sendKeyFrameInfo(Game game);

	void sendEnd(Game game);

	void runGameLogic(Game game);

	/**
	 * 游戏服务器初始化
	 * @param matchInfo
	 * @return
	 * @author wcy 2016年11月29日
	 */
	Game serverGameInit(MatchInfo matchInfo);

}
