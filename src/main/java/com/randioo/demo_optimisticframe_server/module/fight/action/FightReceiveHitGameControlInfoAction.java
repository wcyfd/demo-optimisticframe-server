package com.randioo.demo_optimisticframe_server.module.fight.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.fight.service.FightService;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightReceiveHitGameControlRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(FightReceiveHitGameControlRequest.class)
public class FightReceiveHitGameControlInfoAction extends ActionSupport {

	private FightService fightService;

	public void setFightService(FightService fightService) {
		this.fightService = fightService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub
		FightReceiveHitGameControlRequest cs = (FightReceiveHitGameControlRequest) data;
		Role role =(Role) RoleCache.getRoleBySession(session);
		int enemyId = cs.getEnemyId();
		fightService.receive_HitGame_ControlInfo(role, enemyId);
	}

}
