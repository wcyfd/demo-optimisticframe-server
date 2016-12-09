package com.randioo.demo_optimisticframe_server.module.invite.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.cache.RoleCache;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.invite.service.InviteService;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteFriendRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(InviteFriendRequest.class)
public class InviteFriendAction extends ActionSupport {
	private InviteService inviteService;

	public void setInviteService(InviteService inviteService) {
		this.inviteService = inviteService;
	}	

	@Override
	public void execute(Object data, IoSession session) {
		InviteFriendRequest request = (InviteFriendRequest) data;
		Role role = RoleCache.getRoleBySession(session);
		inviteService.invite(role, request.getAccount(), session);
	}
}
