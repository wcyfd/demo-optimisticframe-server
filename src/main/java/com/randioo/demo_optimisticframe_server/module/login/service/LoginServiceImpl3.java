package com.randioo.demo_optimisticframe_server.module.login.service;

import java.sql.Connection;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import javax.sql.DataSource;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.role.service.RoleService;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginCheckAccountResponse;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginCreateRoleResponse;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginGetRoleDataResponse;
import com.randioo.demo_optimisticframe_server.protocal.Login.RoleData;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.demo_optimisticframe_server.utils.Utils;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.cache.SessionCache;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.net.CacheLockUtil;

public class LoginServiceImpl3 extends BaseService implements LoginService3 {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public GeneratedMessage login(String account) {
		SCMessage.Builder scMessage = SCMessage.newBuilder();
		LoginCheckAccountResponse.Builder message = LoginCheckAccountResponse.newBuilder();

		ReentrantLock reentrantLock = CacheLockUtil.getLock(String.class, account);
		reentrantLock.lock();

		try {
			Set<String> accountSet = RoleCache.getAccountSet();
			message.setErrorCode(accountSet.contains(account) ? ErrorCode.SUCCESS : ErrorCode.SHORT_TWO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reentrantLock.unlock();
		}
		scMessage.setLoginCheckAccountResponse(message.build());
		return scMessage.build();
	}

	public GeneratedMessage creatRole(String account, String name) {
		if (account == null || name == null) {
			System.err.println("str can not be null!");
			return null;
		}

		SCMessage.Builder scMessage = SCMessage.newBuilder();
		LoginCreateRoleResponse.Builder message = LoginCreateRoleResponse.newBuilder();

		// 判断玩家名字是否重复
		if (RoleCache.getNameSet().contains(name)) {
			message.setErrorCode(ErrorCode.NAME_IS_ALREADY_HAS);

			return scMessage.setLoginCreateRoleResponse(message).build();
		}
		ReentrantLock reentrantLock = CacheLockUtil.getLock(String.class, account);
		reentrantLock.lock();
		try {
			Set<String> accountSet = RoleCache.getAccountSet();
			if (accountSet.contains(account)) { // 判定账号是否存在
				return null;
			}

			Connection conn = null;
			try { // mysql事务
			// conn = dataSource.getConnection();
			// conn.setAutoCommit(false);

				// 用户数据
				Role role = this.roleInit(account, conn, name);

				// conn.commit(); // 提交JDBC事务
				// conn.setAutoCommit(true); // 恢复JDBC事务的默认提交方式
				// 加入role缓存
				RoleCache.putNewRole(role);
				message.setErrorCode(ErrorCode.SUCCESS);

				return scMessage.setLoginCreateRoleResponse(message).build();
			} catch (Exception e1) {
				e1.printStackTrace();
				try {
					conn.rollback();// 回滚JDBC事务
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				e1.printStackTrace();
				return null;
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			reentrantLock.unlock();
		}
	}

	public GeneratedMessage getRoleData(String account, IoSession ioSession) {
		
		SCMessage.Builder scMessage= SCMessage.newBuilder();
		LoginGetRoleDataResponse.Builder message = LoginGetRoleDataResponse.newBuilder();
		
		ReentrantLock reentrantLock = CacheLockUtil.getLock(String.class, account);
		reentrantLock.lock();

		try {
			// 获取缓存中的role
			Role role = (Role)RoleCache.getRoleByAccount(account);

			if (role == null) { // 缓存中没有role数据
			// role = roleDao.getRoleByAccount(account);
//				this.loginRoleModuleDataInit(role);
				message.setErrorCode(30103);
				return scMessage.setLoginGetRoleDataResponse(message).build();
			}
			// TODO 登陆状态记录

			IoSession oldSession = SessionCache.getSessionById(role.getRoleId());
			if (oldSession != null) { // 该账号已登录
				if (oldSession.isConnected()) {
					message.setErrorCode(ErrorCode.IN_LOGIN);
					return scMessage.setLoginGetRoleDataResponse(message).build();
				}
				oldSession.setAttribute("roleId", null);
				oldSession.close(false);
			}

			// session绑定ID
			ioSession.setAttribute("roleId", role.getRoleId());
			// session放入缓存
			SessionCache.addSession(role.getRoleId(), ioSession);

			int nowTime = Utils.getNowTime();

			// 功能图标解锁star
			message.setErrorCode(ErrorCode.SUCCESS);
			message.setServerTime(nowTime);
			message.setRoleData(RoleData.newBuilder().setRoleId(role.getRoleId()).setName(role.getName()));
			return scMessage.setLoginGetRoleDataResponse(message).build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			reentrantLock.unlock();
		}
	}

	/**
	 * 初始化用户数据
	 * 
	 * @param account
	 * @param conn
	 * @return
	 */
	private Role roleInit(String account, Connection conn, String name) {
		// 创建用户
		Role role = new Role();
		role.setAccount(account);

		role.setName(name);
		int id = RoleCache.getAccountSet().size();
		// int id = roleDao.insertRole(role, conn);
		id++;
		role.setRoleId(id);

		return role;
	}

	@Override
	public void loginRoleModuleDataInit(Role role) {
		// 将数据库中的数据放入缓存中
		RoleCache.putRoleCache(role);
	}

}
