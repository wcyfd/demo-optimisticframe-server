package com.randioo.demo_optimisticframe_server.module.invite.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.invite.service.InviteService;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteAnswerRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(InviteAnswerRequest.class)
public class InviteAnswerAction extends ActionSupport{
	private InviteService inviteService;

	public void setInviteService(InviteService inviteService) {
		this.inviteService = inviteService;
	}	

	@Override
	public void execute(Object data, IoSession session) {
		InviteAnswerRequest request = (InviteAnswerRequest) data;
		Role role = (Role)RoleCache.getRoleBySession(session);
		inviteService.answer(role, request.getAccount(), request.getAnswer(), session);
	}
}
