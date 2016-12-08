package com.randioo.demo_optimisticframe_server.module.login.service;

import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.randioo_server_base.module.login.LoginModelService;

public interface LoginService extends LoginModelService{
	public void loginRoleModuleDataInit(Role role);
}
