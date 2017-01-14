package com.randioo.demo_optimisticframe_server.module.match.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.fight.service.FightService;
import com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.module.match.MatchHandler;
import com.randioo.randioo_server_base.module.match.MatchInfo;
import com.randioo.randioo_server_base.module.match.MatchModelService;
import com.randioo.randioo_server_base.module.match.MatchRule;
import com.randioo.randioo_server_base.module.match.Matchable;

public class MatchServiceImpl extends BaseService implements MatchService {

	private FightService fightService;

	public void setFightService(FightService fightService) {
		this.fightService = fightService;
	}

//	private GameMatcher gameMatcher;
//
//	public void setGameMatcher(GameMatcher gameMatcher) {
//		this.gameMatcher = gameMatcher;
//	}
	
	private MatchModelService matchModelService;
	public void setMatchModelService(MatchModelService matchModelService) {
		this.matchModelService = matchModelService;
	}

	@Override
	public void init() {
		init2();
	}
//	void init1(){
//		gameMatcher.setMatchHandler(new MatchHandler() {
//
//			@Override
//			public boolean needWaitMatch(MatchInfo matchInfo) {
//				System.out.println("needWaitMatch");
//				return true;
//			}
//
//			@Override
//			public void matchSuccess(MatchInfo matchInfo, MatchRule matchRule) {
//				System.out.println("matchSuccess");
//			}
//
//			@Override
//			public boolean matchRule(MatchRule myMatchRule, MatchInfo otherMatchInfo) {
//				System.out.println("matchRule");
//				MatchRule otherMatchRule = otherMatchInfo.getMatchRule();
//				return myMatchRule.getPlayerCount() == otherMatchRule.getPlayerCount();
//			}
//
//			@Override
//			public void matchComplete(MatchInfo matchInfo) {
//				System.out.println("matchComplete");
//				fightService.loadResource(matchInfo.getMatchRule().getPlayerCount(), matchInfo.getMatchables());
//			}
//
//			@Override
//			public MatchRule getAutoMatchRole(MatchInfo matchInfo) {
//				System.out.println("getAutoMatchRole");
//				// 如果是npc，则默认是加载完毕的
//				Role role = new Role();
//				role.setAccount("npc");
//				role.setName("npc");
//				role.setPrepare(true);
//				role.setNpc(true);
//
//				MatchRule matchRule = new MatchRule();
//				matchRule.setMatchTarget(role);
//
//				return matchRule;
//			}
//
//			@Override
//			public void destroyMatchInfo(MatchInfo matchInfo) {
//				System.out.println("destroyMatchInfo");
//			}
//
//			@Override
//			public MatchInfo createMatchInfo(MatchRule matchRule) {
//				return new MatchInfo();
//			}
//
//			@Override
//			public void cancelMatch(Matchable matchable) {
//				System.out.println("cancel match success");
//			}
//
//			@Override
//			public void changeStartMatcher(Matchable originStarter, Matchable newStarter) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void waitClick(MatchInfo matchInfo, int clickCount) {
//				// TODO Auto-generated method stub
//				Role role = (Role) matchInfo.getMatchRule().getMatchTarget();
//				System.out.println("plane match wait id:" + matchInfo.getMatchId() + " start account:"
//						+ role.getAccount() + " start name:" + role.getName());
//			}
//		});
//	}
void init2(){
	matchModelService.init();
	matchModelService.setMatchHandler(new MatchHandler() {

		@Override
		public boolean needWaitMatch(MatchInfo matchInfo) {
			System.out.println("needWaitMatch");
			return true;
		}

		@Override
		public void matchSuccess(MatchInfo matchInfo, MatchRule matchRule) {
			System.out.println("matchSuccess");
		}

		@Override
		public boolean matchRule(MatchRule myMatchRule, MatchInfo otherMatchInfo) {
			System.out.println("matchRule");
			MatchRule otherMatchRule = otherMatchInfo.getMatchRule();
			return myMatchRule.getPlayerCount() == otherMatchRule.getPlayerCount();
		}

		@Override
		public void matchComplete(MatchInfo matchInfo) {
			System.out.println("matchComplete");
			fightService.loadResource(matchInfo.getMatchRule().getPlayerCount(), matchInfo.getMatchables());
		}

		@Override
		public MatchRule getAutoMatchRole(MatchInfo matchInfo) {
			System.out.println("getAutoMatchRole");
			// 如果是npc，则默认是加载完毕的
			Role role = new Role();
			role.setAccount("npc");
			role.setName("npc");
			role.setPrepare(true);
			role.setNpc(true);

			MatchRule matchRule = new MatchRule();
			matchRule.setMatchTarget(role);

			return matchRule;
		}

		@Override
		public void destroyMatchInfo(MatchInfo matchInfo) {
			System.out.println("destroyMatchInfo");
		}

		@Override
		public MatchInfo createMatchInfo(MatchRule matchRule) {
			return new MatchInfo();
		}

		@Override
		public void cancelMatch(Matchable matchable) {
			System.out.println("cancel match success");
		}

		@Override
		public void changeStartMatcher(Matchable originStarter, Matchable newStarter) {
			// TODO Auto-generated method stub

		}

		@Override
		public void waitClick(MatchInfo matchInfo, int clickCount) {
			// TODO Auto-generated method stub
			Role role = (Role) matchInfo.getMatchRule().getMatchTarget();
			System.out.println("plane match wait id:" + matchInfo.getMatchId() + " start account:"
					+ role.getAccount() + " start name:" + role.getName());
		}
	});
}
	@Override
	public void matchRole(Role role, boolean test, IoSession session) {
		session.write(SCMessage.newBuilder()
				.setMatchRoleResponse(MatchRoleResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS)).build());

		MatchRule matchRule = new MatchRule();
		matchRule.setMatchNPC(false);
		matchRule.setMatchTarget(role);
		matchRule.setPlayerCount(test ? 1 : 2);
		matchRule.setWaitTime(5);
		matchRule.setWaitUnit(TimeUnit.SECONDS);

		matchModelService.matchRole(matchRule);
	}

	@Override
	public void cancelRole(Role role, IoSession session) {
		matchModelService.cancelMatch(role);
	}

	@Override
	public void matchRole(List<Role> roleList) {
		fightService.loadResource(roleList.size(), roleList);
	}

}
