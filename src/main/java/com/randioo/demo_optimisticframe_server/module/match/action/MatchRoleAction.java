package com.randioo.demo_optimisticframe_server.module.match.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.cache.RoleCache;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.match.service.MatchService;
import com.randioo.demo_optimisticframe_server.protocal.Match.MatchRoleRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(MatchRoleRequest.class)
public class MatchRoleAction extends ActionSupport{

	private MatchService matchService;

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub

		MatchRoleRequest message = (MatchRoleRequest) data;
		boolean test = message.getTest();

		Role role = RoleCache.getRoleBySession(session);
		matchService.matchRole(role,test,session);

	}

}
