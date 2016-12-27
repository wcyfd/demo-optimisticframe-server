package com.randioo.demo_optimisticframe_server.module.login.service;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface LoginService extends BaseServiceInterface {
	public void loginRoleModuleDataInit(Role role);

	Object getRoleData(Object requestMessage, IoSession ioSession);

	Object creatRole(Object msg);

	Object login(Object msg);
}
