package com.randioo.demo_optimisticframe_server.module.fight.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.cache.RoleCache;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.fight.service.FightService;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightLoadCompleteRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(FightLoadCompleteRequest.class)
public class FightLoadCompleteAction extends ActionSupport {

	private FightService fightService;

	public void setFightService(FightService fightService) {
		this.fightService = fightService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub
		FightLoadCompleteRequest cs = (FightLoadCompleteRequest) data;
		Role role = RoleCache.getRoleBySession(session);
		fightService.loadComplete(role, session);
	}

}