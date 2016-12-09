package com.randioo.demo_optimisticframe_server.module.invite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.cache.RoleCache;
import com.randioo.demo_optimisticframe_server.cache.SessionCache;
import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.match.service.MatchService;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteAnswerResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteFriendResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.SCInviteAccept;
import com.randioo.demo_optimisticframe_server.protocal.Invite.SCInviteCancel;
import com.randioo.demo_optimisticframe_server.protocal.Invite.SCInviteReject;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.demo_optimisticframe_server.utils.GameInviter;
import com.randioo.demo_optimisticframe_server.utils.Invitation;
import com.randioo.demo_optimisticframe_server.utils.InviteHandler;
import com.randioo.randioo_server_base.module.BaseService;

public class InviteServiceImpl extends BaseService implements InviteService {

	private GameInviter<Integer> gameInviter;

	public void setGameInviter(GameInviter<Integer> gameInviter) {
		this.gameInviter = gameInviter;
	}

	private MatchService matchService;

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	@Override
	public void init() {
		gameInviter.setHandler(new InviteHandler<Integer>() {

			@Override
			public void acceptInvite(Invitation<Integer> invitation, Integer targeter) {
				int startRoleId = invitation.getStarter();
				Role startRole = RoleCache.getRoleById(startRoleId);
				Role targetRole = RoleCache.getRoleById(targeter);

				{
					IoSession session = SessionCache.getSessionById(startRoleId);
					if (session != null) {
						session.write(SCMessage
								.newBuilder()
								.setScInviteAccept(
										SCInviteAccept.newBuilder().setStarter(startRole.getAccount())
												.setTargeter(targetRole.getAccount())).build());
					}
				}
				{
					IoSession session = SessionCache.getSessionById(targeter);
					if (session != null) {
						session.write(SCMessage
								.newBuilder()
								.setScInviteAccept(
										SCInviteAccept.newBuilder().setStarter(startRole.getAccount())
												.setTargeter(targetRole.getAccount())).build());
					}
				}

			}

			@Override
			public void rejectInvite(Invitation<Integer> invitation, Integer targeter) {
				int startRoleId = invitation.getStarter();
				Role startRole = RoleCache.getRoleById(startRoleId);
				Role targetRole = RoleCache.getRoleById(targeter);

				{
					IoSession session = SessionCache.getSessionById(startRoleId);
					if (session != null) {
						session.write(SCMessage
								.newBuilder()
								.setScInviteReject(
										SCInviteReject.newBuilder().setStarter(startRole.getAccount())
												.setTargeter(targetRole.getAccount())).build());
					}
				}
				{
					IoSession session = SessionCache.getSessionById(targeter);
					if (session != null) {
						session.write(SCMessage
								.newBuilder()
								.setScInviteReject(
										SCInviteReject.newBuilder().setStarter(startRole.getAccount())
												.setTargeter(targetRole.getAccount())).build());
					}
				}

			}

			@Override
			public void inviteCancel(Invitation<Integer> invitation, Integer targeter) {
				Role role = RoleCache.getRoleById(invitation.getStarter());
				IoSession session = SessionCache.getSessionById(targeter);
				String account = role.getAccount();
				if (session != null) {
					session.write(SCMessage.newBuilder()
							.setScInviteCancel(SCInviteCancel.newBuilder().setStarter(account)).build());
				}
			}

			@Override
			public void inviteComplete(Invitation<Integer> invitation) {
				Set<Integer> roleIdSet = invitation.getInvitationMap().keySet();
				List<Role> roleList = new ArrayList<>(roleIdSet.size());
				for (Integer roleId : roleIdSet) {
					Role role = RoleCache.getRoleById(roleId);
					roleList.add(role);
				}

				matchService.matchRole(roleList);
			}

			@Override
			public void inviteOutOfIndex(Invitation<Integer> invitation) {
				// TODO Auto-generated method stub

			}

		});
	}

	@Override
	public void invite(Role role, String account, IoSession session) {
		session.write(SCMessage.newBuilder()
				.setInviteFriendResponse(InviteFriendResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS)).build());
		gameInviter.newInvitation(role.getRoleId(), 2);
		gameInviter.invite(role.getRoleId(), RoleCache.getRoleByAccount(account).getRoleId());
	}

	@Override
	public void answer(Role role, String account, boolean answer, IoSession session) {
		session.write(SCMessage.newBuilder().setInviteAnswerResponse(InviteAnswerResponse.newBuilder().build()));
		gameInviter.response(RoleCache.getRoleByAccount(account).getRoleId(), role.getRoleId(), answer);
	}

}
