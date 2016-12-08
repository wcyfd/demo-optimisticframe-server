package com.randioo.demo_optimisticframe_server.module.match.service;

import java.util.concurrent.TimeUnit;

import org.apache.mina.core.session.IoSession;
import org.springframework.cache.support.SimpleCacheManager;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.fight.service.FightService;
import com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleResponse;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.utils.game.matcher.GameMatcher;
import com.randioo.randioo_server_base.utils.game.matcher.MatchHandler;
import com.randioo.randioo_server_base.utils.game.matcher.MatchInfo;
import com.randioo.randioo_server_base.utils.game.matcher.MatchRule;
import com.randioo.randioo_server_base.utils.game.matcher.Matchable;

public class MatchServiceImpl extends BaseService implements MatchService {

	private FightService fightService;

	public void setFightService(FightService fightService) {
		this.fightService = fightService;
	}

	private GameMatcher gameMatcher;

	public void setGameMatcher(GameMatcher gameMatcher) {
		this.gameMatcher = gameMatcher;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		gameMatcher.setMatchHandler(new MatchHandler() {

			@Override
			public boolean needWaitMatch(MatchInfo matchInfo) {
				// TODO Auto-generated method stub
				System.out.println("needWaitMatch");
				return true;
			}

			@Override
			public void matchSuccess(MatchInfo matchInfo, MatchRule matchRule) {
				// TODO Auto-generated method stub
				System.out.println("matchSuccess");
			}

			@Override
			public boolean matchRule(MatchRule myMatchRule, MatchInfo otherMatchInfo) {
				// TODO Auto-generated method stub
				System.out.println("matchRule");
				MatchRule otherMatchRule = otherMatchInfo.getMatchRule();
				return myMatchRule.getPlayerCount() == otherMatchRule.getPlayerCount();
			}

			@Override
			public void matchComplete(MatchInfo matchInfo) {
				// TODO Auto-generated method stub
				System.out.println("matchComplete");
				fightService.loadResource(matchInfo);
			}

			@Override
			public MatchRule getAutoMatchRole(MatchInfo matchInfo) {
				// TODO Auto-generated method stub
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

		gameMatcher.matchRole(matchRule);
	}

	@Override
	public void cancelRole(Role role,IoSession session) {
		
		gameMatcher.cancelMatch(role);
		

	}

}
