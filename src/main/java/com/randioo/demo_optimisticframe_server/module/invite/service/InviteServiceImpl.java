package com.randioo.demo_optimisticframe_server.module.invite.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Lock;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.match.service.MatchService;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteAnswerResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteFriendResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteFriendsGameStartResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteNewInvitationResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteQuitInvitationResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteRoleData;
import com.randioo.demo_optimisticframe_server.protocal.Invite.InviteShowFriendsResponse;
import com.randioo.demo_optimisticframe_server.protocal.Invite.SCInviteAccept;
import com.randioo.demo_optimisticframe_server.protocal.Invite.SCInviteReceive;
import com.randioo.demo_optimisticframe_server.protocal.Invite.SCInviteReject;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.cache.SessionCache;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.module.invite.Invitable;
import com.randioo.randioo_server_base.module.invite.Invitation;
import com.randioo.randioo_server_base.module.invite.InviteHandler;
import com.randioo.randioo_server_base.module.invite.InviteModelService;

public class InviteServiceImpl extends BaseService implements InviteService {

//	private GameInviter gameInviter;
//
//	public void setGameInviter(GameInviter gameInviter) {
//		this.gameInviter = gameInviter;
//	}

	private InviteModelService inviteModelService;

	public void setInviteModelService(InviteModelService inviteModelService) {
		this.inviteModelService = inviteModelService;
	}

	private MatchService matchService;

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	@Override
	public void init() {
		init2();
	}

	// void init1(){
	// gameInviter.setHandler(new InviteHandler() {
	//
	// @Override
	// public void acceptInvite(Invitation invitation, Invitable targeter) {
	// inviteUpdate(invitation);
	//
	// }
	//
	// @Override
	// public void rejectInvite(Invitation invitation, Invitable targeter) {
	// Role starter = (Role) invitation.getInviteSuccessList().get(0);
	// Role targetRole = (Role) targeter;
	// IoSession session = SessionCache.getSessionById(starter.getRoleId());
	// if (session != null) {
	// if (session != null) {
	// session.write(SCMessage
	// .newBuilder()
	// .setScInviteReject(
	// SCInviteReject.newBuilder().setStarter(starter.getAccount())
	// .setTargeter(targetRole.getAccount())).build());
	// }
	// }
	// }
	//
	// @Override
	// public void inviteCancel(Invitation invitation, Invitable targeter) {
	// inviteUpdate(invitation);
	// }
	//
	// @Override
	// public void inviteComplete(Invitation invitation) {
	//
	// }
	//
	// @Override
	// public void inviteOutOfIndex(Invitation invitation) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void receiveInvite(Invitation invitation, Invitable targeter) {
	// Role role = (Role) targeter;
	// IoSession session = SessionCache.getSessionById(role.getRoleId());
	// if (session != null) {
	// Role starter = (Role) invitation.getInviteSuccessList().get(0);
	// session.write(SCMessage.newBuilder()
	// .setScInviteReceive(SCInviteReceive.newBuilder().setAccount(starter.getAccount())).build());
	// }
	// }
	//
	// });
	// }
	void init2() {
		inviteModelService.setHandler(new InviteHandler() {

			@Override
			public void acceptInvite(Invitation invitation, Invitable targeter) {
				inviteUpdate(invitation);

			}

			@Override
			public void rejectInvite(Invitation invitation, Invitable targeter) {
				Role starter = (Role) invitation.getInviteSuccessList().get(0);
				Role targetRole = (Role) targeter;
				IoSession session = SessionCache.getSessionById(starter.getRoleId());
				if (session != null) {
					if (session != null) {
						session.write(SCMessage
								.newBuilder()
								.setScInviteReject(
										SCInviteReject.newBuilder().setStarter(starter.getAccount())
												.setTargeter(targetRole.getAccount())).build());
					}
				}
			}

			@Override
			public void inviteCancel(Invitation invitation, Invitable targeter) {
				inviteUpdate(invitation);
			}

			@Override
			public void inviteComplete(Invitation invitation) {

			}

			@Override
			public void inviteOutOfIndex(Invitation invitation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void receiveInvite(Invitation invitation, Invitable targeter) {
				Role role = (Role) targeter;
				IoSession session = SessionCache.getSessionById(role.getRoleId());
				if (session != null) {
					Role starter = (Role) invitation.getInviteSuccessList().get(0);
					session.write(SCMessage.newBuilder()
							.setScInviteReceive(SCInviteReceive.newBuilder().setAccount(starter.getAccount())).build());
				}
			}

		});
	}

	/**
	 * 邀请信息变化，发送给各个邀请等待的玩家
	 * 
	 * @param invitation
	 * @return
	 * @author wcy 2016年12月16日
	 */
	private GeneratedMessage inviteUpdate(Invitation invitation) {
		SCInviteAccept.Builder scInviteAcceptBuilder = SCInviteAccept.newBuilder();

		for (Invitable invitable : invitation.getInviteSuccessList()) {
			Role role = (Role) invitable;
			InviteRoleData.Builder inviteRoleDataBuilder = InviteRoleData.newBuilder().setAccount(role.getAccount());
			for (int i = 1; i <= role.getUsePlanes().size(); i++) {
				inviteRoleDataBuilder.addPlaneId(role.getUsePlanes().get(i));
			}
			scInviteAcceptBuilder.addInviteRoleDatas(inviteRoleDataBuilder);
		}

		SCMessage sc = SCMessage.newBuilder().setScInviteAccept(scInviteAcceptBuilder).build();

		for (Invitable invitable : invitation.getInviteSuccessList()) {
			Role role = (Role) invitable;
			IoSession session = SessionCache.getSessionById(role.getRoleId());
			if (session != null) {
				session.write(sc);
			}
		}
		return sc;
	}

	@Override
	public GeneratedMessage newInvitation(Role role) {
		inviteModelService.newInvitation(role, 2);
		InviteRoleData.Builder inviteRoleDataBuilder = InviteRoleData.newBuilder().setAccount(role.getAccount());
		for (int i = 1; i <= role.getUsePlanes().size(); i++) {
			inviteRoleDataBuilder.addPlaneId(role.getUsePlanes().get(i));
		}
		return SCMessage
				.newBuilder()
				.setInviteNewInvitationResponse(
						InviteNewInvitationResponse.newBuilder().addInviteRoleDatas(inviteRoleDataBuilder)).build();
	}

	@Override
	public void invite(Role role, String account, IoSession session) {
		if (role == null) {
			session.write(SCMessage.newBuilder()
					.setInviteFriendResponse(InviteFriendResponse.newBuilder().setErrorCode(ErrorCode.RELOGIN)).build());
			return;
		}
		session.write(SCMessage.newBuilder()
				.setInviteFriendResponse(InviteFriendResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS)).build());
		inviteModelService.invite(role, (Role) RoleCache.getRoleByAccount(account));
	}

	@Override
	public void answer(Role role, String account, boolean answer, IoSession session) {
		session.write(SCMessage.newBuilder().setInviteAnswerResponse(InviteAnswerResponse.newBuilder()).build());
		inviteModelService.response((Role) RoleCache.getRoleByAccount(account), role, answer);
	}

	@Override
	public GeneratedMessage showAllFriends(Role role) {
		InviteShowFriendsResponse.Builder message = InviteShowFriendsResponse.newBuilder();
		Collection<IoSession> sessions = SessionCache.getAllSession();
		for (IoSession session : sessions) {
			if (session.isConnected()) {
				Role temp = (Role) RoleCache.getRoleBySession(session);
				if (temp != null && temp != role) {
					InviteRoleData.Builder inviteRoleDataBuilder = InviteRoleData.newBuilder();
					for (int i = 1, usePlaneSize = temp.getUsePlanes().size(); i <= usePlaneSize; i++) {
						inviteRoleDataBuilder.setAccount(temp.getAccount()).addPlaneId(temp.getUsePlanes().get(i));
					}
					message.addInviteRoleDatas(inviteRoleDataBuilder);
				}
			}
		}

		return SCMessage.newBuilder().setInviteShowFriendsResponse(message).build();
	}

	@Override
	public GeneratedMessage quitInvitation(Role role) {
		inviteModelService.cancelInvite(role);
		return SCMessage.newBuilder().setInviteQuitInvitationResponse(InviteQuitInvitationResponse.newBuilder())
				.build();
	}

	@Override
	public void inviteFriendsGameStart(Role role, IoSession session) {
		session.write(SCMessage.newBuilder()
				.setInviteFriendsGameStartResponse(InviteFriendsGameStartResponse.newBuilder()).build());
		Invitation invitation = role.getInvitation();
		Lock lock = invitation.getLock();
		try {
			lock.lock();
			invitation.setCancel(true);

			List<Invitable> invitables = invitation.getInviteSuccessList();
			List<Role> roleList = new ArrayList<>(invitation.getSize());

			// 还没有邀请完直接开始了比赛，则添加npc
			int totalSize = invitation.getSize();
			if (totalSize > invitables.size()) {
				for (int i = 0; i < totalSize - invitables.size(); i++) {
					Role npc = new Role();
					npc.setAccount("npc");
					npc.setName("npc");
					npc.setNpc(true);
					npc.getUsePlanes().put(1, 1);
					npc.getUsePlanes().put(2, 2);
					invitables.add(npc);
				}
			}

			for (Invitable invitable : invitables) {
				roleList.add((Role) invitable);
			}

			matchService.matchRole(roleList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}
