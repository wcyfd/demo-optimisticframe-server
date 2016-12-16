package com.randioo.demo_optimisticframe_server.module.login.service;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface LoginService3 extends BaseServiceInterface{
	/** 检测账号是否存在 */
	public GeneratedMessage login(String account);

	/** 创建账号 */
	public GeneratedMessage creatRole(String account, String name);

	/** 登陆账号 */
	public GeneratedMessage getRoleData(String account, IoSession ioSession);

	/** 玩家登陆初始化 */
	public void loginRoleModuleDataInit(Role role);
}
