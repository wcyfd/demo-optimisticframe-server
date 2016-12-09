package com.randioo.demo_optimisticframe_server.module.match.service;

import java.util.List;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface MatchService extends BaseServiceInterface {

	public void matchRole(Role role, boolean test, IoSession session);

	public void cancelRole(Role role,IoSession session);

	public void matchRole(List<Role> roleList);

}
