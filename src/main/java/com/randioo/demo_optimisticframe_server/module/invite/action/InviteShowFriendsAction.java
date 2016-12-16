package com.randioo.demo_optimisticframe_server.module.invite.action;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.invite.service.InviteService;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteShowFriendsRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(InviteShowFriendsRequest.class)
public class InviteShowFriendsAction extends ActionSupport {
	private InviteService inviteService;

	public void setInviteService(InviteService inviteService) {
		this.inviteService = inviteService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		InviteShowFriendsRequest request = (InviteShowFriendsRequest) data;
		Role role = (Role)RoleCache.getRoleBySession(session);
		GeneratedMessage message = inviteService.showAllFriends(role);
		if(message!=null){
			session.write(message);
		}
	}
}
