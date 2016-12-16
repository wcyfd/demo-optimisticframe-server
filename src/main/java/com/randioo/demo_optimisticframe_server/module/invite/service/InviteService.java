package com.randioo.demo_optimisticframe_server.module.invite.service;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface InviteService extends BaseServiceInterface {

	/**
	 * 新建邀请
	 * 
	 * @param role
	 * @return
	 * @author wcy 2016年12月16日
	 */
	public GeneratedMessage newInvitation(Role role);

	/**
	 * 邀请
	 * 
	 * @param role
	 * @param account
	 * @param session
	 * @author wcy 2016年12月16日
	 */
	public void invite(Role role, String account, IoSession session);

	/**
	 * 回复邀请
	 * 
	 * @param role
	 * @param account
	 * @param answer
	 * @param session
	 * @author wcy 2016年12月16日
	 */
	public void answer(Role role, String account, boolean answer, IoSession session);

	/**
	 * 显示所有好友
	 * 
	 * @param role
	 * @return
	 * @author wcy 2016年12月16日
	 */
	public GeneratedMessage showAllFriends(Role role);

	/**
	 * 推出邀请
	 * 
	 * @param role
	 * @return
	 * @author wcy 2016年12月16日
	 */
	public GeneratedMessage quitInvitation(Role role);

	/**
	 * 邀请好友比赛开始
	 * 
	 * @param role
	 * @param session
	 * @author wcy 2016年12月16日
	 */
	public void inviteFriendsGameStart(Role role, IoSession session);
}
