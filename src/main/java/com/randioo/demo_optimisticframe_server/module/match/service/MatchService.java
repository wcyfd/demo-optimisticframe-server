package com.randioo.demo_optimisticframe_server.module.match.service;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface MatchService extends BaseServiceInterface {

	public void matchRole(Role role, boolean test, IoSession session);

	public void cancelRole(Role role,IoSession session);

}
