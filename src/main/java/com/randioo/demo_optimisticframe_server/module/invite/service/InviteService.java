package com.randioo.demo_optimisticframe_server.module.invite.service;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface InviteService extends BaseServiceInterface{

	public void invite(Role role,String account,IoSession session);

	public void answer(Role role, String account, boolean answer, IoSession session);
}
