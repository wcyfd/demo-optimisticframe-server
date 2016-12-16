package com.randioo.demo_optimisticframe_server.module.invite.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.invite.service.InviteService;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteFriendsGameStartRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(InviteFriendsGameStartRequest.class)
public class InviteFriendsStartGameAction extends ActionSupport {
	private InviteService inviteService;

	public void setInviteService(InviteService inviteService) {
		this.inviteService = inviteService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		InviteFriendsGameStartRequest request = (InviteFriendsGameStartRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		inviteService.inviteFriendsGameStart(role, session);
	}
}
