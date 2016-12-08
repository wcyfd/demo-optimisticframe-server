package com.randioo.demo_optimisticframe_server.utils;

import java.util.Set;

public interface InviteHandler<T> {
	/**
	 * 接受邀请
	 * 
	 * @param starter 发起者邀请者
	 * @param targeter 邀请目标
	 * @author wcy 2016年12月7日
	 */
	public void acceptInvite(T starter, T targeter);

	/**
	 * 拒绝邀请
	 * 
	 * @param starter 发起者邀请者
	 * @param targeter 邀请目标
	 * @author wcy 2016年12月7日
	 */
	public void rejectInvite(T starter, T targeter);

	/**
	 * 邀请被取消
	 * 
	 * @param starter
	 * @param targeter
	 * @author wcy 2016年12月7日
	 */
	public void inviteCancelled(T starter, T targeter);

	/**
	 * 取消对某人的邀请
	 */
	public void inviteCancel(T starter, T targeter);

	/**
	 * 邀请完成
	 * 
	 * @param starter
	 * @author wcy 2016年12月7日
	 */
	public void inviteComplete(Set<T> completeSet);

	/**
	 * 
	 * @param invitation
	 * @author wcy 2016年12月7日
	 */
	public void invitationDestoryed(T starter);

	/**
	 * 邀请超过限制
	 * 
	 * @param invitation
	 * @author wcy 2016年12月7日
	 */
	public void inviteOutOfIndex(Invitation<?> invitation);
}