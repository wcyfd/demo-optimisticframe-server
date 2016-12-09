package com.randioo.demo_optimisticframe_server.module.login.service;

import java.sql.Connection;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.cache.RoleCache;
import com.randioo.demo_optimisticframe_server.cache.SessionCache;
import com.randioo.demo_optimisticframe_server.common.ErrorCode;
import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.module.role.service.RoleService;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginCheckAccountRequest;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginCheckAccountResponse;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginCreateRoleRequest;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginCreateRoleResponse;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginGetRoleDataRequest;
import com.randioo.demo_optimisticframe_server.protocal.Login.LoginGetRoleDataResponse;
import com.randioo.demo_optimisticframe_server.protocal.Login.RoleData;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.demo_optimisticframe_server.utils.Utils;
import com.randioo.randioo_server_base.entity.Ref;
import com.randioo.randioo_server_base.module.login.LoginHandler;
import com.randioo.randioo_server_base.module.login.LoginModelServiceImpl;

public class LoginServiceImpl extends LoginModelServiceImpl implements LoginService {

	private RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public void init() {
		setLoginHandler(new LoginHandlerImpl());
	}

	private class LoginHandlerImpl implements LoginHandler<Role> {

		@Override
		public GeneratedMessage checkLoginAccountCanLogin(String account) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getLoginAccount(Object loginMessage) {
			LoginCheckAccountRequest request = (LoginCheckAccountRequest) loginMessage;
			return request.getAccount();
		}

		@Override
		public GeneratedMessage isNewAccount(String account) {
			return SCMessage
					.newBuilder()
					.setLoginCheckAccountResponse(
							LoginCheckAccountResponse
									.newBuilder()
									.setErrorCode(
											RoleCache.getAccountSet().contains(account) ? ErrorCode.SUCCESS : ErrorCode.SHORT_TWO))
					.build();
		}

		@Override
		public String getCreateRoleAccount(Object createRoleMessage) {
			LoginCreateRoleRequest request = (LoginCreateRoleRequest) createRoleMessage;
			return request.getAccount();
		}

		@Override
		public Object checkCreateRoleAccount(Object createRoleMessage) {
			LoginCreateRoleRequest request = (LoginCreateRoleRequest) createRoleMessage;

			if (RoleCache.getNameSet().contains(request.getName())) {
				return SCMessage
						.newBuilder()
						.setLoginCreateRoleResponse(
								LoginCreateRoleResponse.newBuilder().setErrorCode(ErrorCode.NAME_IS_ALREADY_HAS))
						.build();
			}

			if (RoleCache.getAccountSet().contains(request.getAccount())) { // 判定账号是否存在
				return SCMessage
						.newBuilder()
						.setLoginCreateRoleResponse(
								LoginCreateRoleResponse.newBuilder().setErrorCode(ErrorCode.ACCOUNT_IS_ALREADY_HAS))
						.build();
			}
			return null;
		}

		@Override
		public Connection getConnection() {
			return null;
		}

		@Override
		public Object createRole(Connection conn, Object createRoleMessage) {
			LoginCreateRoleRequest request = (LoginCreateRoleRequest) createRoleMessage;

			// mysql事务
			// conn = dataSource.getConnection();
			// conn.setAutoCommit(false);
			// 用户数据
			Role role = roleInit(request.getAccount(), conn, request.getName());

			// conn.commit(); // 提交JDBC事务
			// conn.setAutoCommit(true); // 恢复JDBC事务的默认提交方式
			// 加入role缓存
			RoleCache.putNewRole(role);

			return SCMessage.newBuilder()
					.setLoginCreateRoleResponse(LoginCreateRoleResponse.newBuilder().setErrorCode(ErrorCode.SUCCESS))
					.build();
		}

		@Override
		public GeneratedMessage getRoleData(Ref<Role> ref) {
			Role role = ref.get();

			return SCMessage
					.newBuilder()
					.setLoginGetRoleDataResponse(
							LoginGetRoleDataResponse
									.newBuilder()
									.setErrorCode(ErrorCode.SUCCESS)
									.setServerTime(Utils.getNowTime())
									.setRoleData(
											RoleData.newBuilder().setRoleId(role.getRoleId()).setName(role.getName())))
					.build();
		}

		@Override
		public String getRoleDataAccount(Object createRoleMessage) {
			LoginGetRoleDataRequest request = (LoginGetRoleDataRequest) createRoleMessage;
			return request.getAccount();
		}

		@Override
		public Object getRoleObjectFromCollectionsByGeneratedMessage(Ref<Role> ref, Object createRoleMessage) {
			LoginGetRoleDataRequest request = (LoginGetRoleDataRequest) createRoleMessage;
			String account = request.getAccount();
			Role role = RoleCache.getRoleByAccount(account);
			if (role == null) {
				// role = roleDao.getRoleByAccount(account);
				// this.loginRoleModuleDataInit(role);
				if (role == null) {
					return SCMessage.newBuilder()
							.setLoginGetRoleDataResponse(LoginGetRoleDataResponse.newBuilder().setErrorCode(30103))
							.build();
				}
			}
			ref.set(role);

			return null;
		}

		@Override
		public String getIoSessionTag() {
			return "roleId";
		}

		@Override
		public Object getIoSessionAttributeValue(Ref<Role> ref) {
			return ref.get().getRoleId();
		}

		@Override
		public IoSession getSessionByRef(Ref<Role> ref) {
			IoSession session = SessionCache.getSessionById(ref.get().getRoleId());
			return session;
		}

		@Override
		public Object connectingError() {
			return SCMessage
					.newBuilder()
					.setLoginGetRoleDataResponse(LoginGetRoleDataResponse.newBuilder().setErrorCode(ErrorCode.IN_LOGIN))
					.build();
		}

		@Override
		public void recordSession(Ref<Role> ref, IoSession session) {
			SessionCache.addSession(ref.get().getRoleId(), session);
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
