package com.randioo.demo_optimisticframe_server.module.fight.action;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.cache.RoleCache;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.fight.service.FightService;
import com.randioo.demo_optimisticframe_server.protocal.Fight.FightReceivePlaneGameControlRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(FightReceivePlaneGameControlRequest.class)
public class FightReceivePlaneGameControlInfoAction extends ActionSupport {

	private FightService fightService;

	public void setFightService(FightService fightService) {
		this.fightService = fightService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub
		FightReceivePlaneGameControlRequest cs = (FightReceivePlaneGameControlRequest) data;
		Role role = RoleCache.getRoleBySession(session);
		GeneratedMessage gameAction = cs.getGameAction();
		fightService.receive_PlaneGame_ControlInfo(role, gameAction);
	}

}
