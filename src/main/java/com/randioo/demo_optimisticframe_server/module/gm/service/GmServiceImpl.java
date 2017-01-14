package com.randioo.demo_optimisticframe_server.module.gm.service;

import java.util.Collection;
import java.util.Iterator;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.SessionCloseHandler;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginResponse;
import com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmRejectLoginResponse;
import com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerResponse;
import com.randioo.demo_optimisticframe_server.protocal.gm.GMServerMessage.GMSCMessage;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.cache.SessionCache;
import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.randioo_server_base.module.BaseService;
import com.randioo.randioo_server_base.utils.system.Platform;
import com.randioo.randioo_server_base.utils.system.ServerManagerHandler;
import com.randioo.randioo_server_base.utils.system.SignalTrigger;
import com.randioo.randioo_server_base.utils.system.SystemManager;
import com.randioo.randioo_server_base.utils.system.Platform.OS;
import com.randioo.randioo_server_base.utils.template.Function;

public class GmServiceImpl extends BaseService implements GmService {

	private SystemManager systemManager;

	public void setSystemManager(SystemManager systemManager) {
		this.systemManager = systemManager;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		systemManager.setServerTerminatedHandler(new ServerManagerHandler() {

			@Override
			public void terminated() {
				// TODO Auto-generated method stub
				everybodyOffline();
			}

			@Override
			public void open() {
				// TODO Auto-generated method stub

			}

			@Override
			public void close() {
				// TODO Auto-generated method stub
				everybodyOffline();
			}
		});
		Function function = new Function(){

			@Override
			public Object apply(Object... params) {
				systemManager.close();
				
				System.out.println("port close");	
				System.out.println("start save");			
				
				everybodyOffline();
				
				System.out.println("save complete");
				
				System.exit(0);
				return null;
			}
			
		};
		
		try {
			System.out.println(Platform.getOS());
			if (Platform.getOS() == OS.WIN)
				SignalTrigger.setSignCallback("INT", function);
			else if (Platform.getOS() == OS.LINUX)
				SignalTrigger.setSignCallback("ABRT", function);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public GeneratedMessage rejectLogin(String code) {
		// TODO Auto-generated method stub
		if (systemManager.checkPassword(code)) {
			return GMSCMessage.newBuilder()
					.setGmRejectLoginResponse(GmRejectLoginResponse.newBuilder().setErrorCode(false)).build();
		}

		systemManager.close();

		return GMSCMessage.newBuilder().setGmRejectLoginResponse(GmRejectLoginResponse.newBuilder().setErrorCode(true))
				.build();
	}

	@Override
	public void shutdownServer(String code, IoSession session) {
		// TODO Auto-generated method stub
		if (!systemManager.checkPassword(code)) {
			session.write(GMSCMessage.newBuilder()
					.setGmShutdownServerResponse(GmShutdownServerResponse.newBuilder().setErrorCode(false)).build());
			return;
		}
		systemManager.close();

		System.out.println("port close");

		System.out.println("start save");
		systemManager.terminated();
		System.out.println("save complete");

		session.write(GMSCMessage.newBuilder()
				.setGmShutdownServerResponse(GmShutdownServerResponse.newBuilder().setErrorCode(true)).build());

		// 关闭
		System.exit(0);
	}

	@Override
	public GeneratedMessage openLogin(String code) {
		// TODO Auto-generated method stub
		if (systemManager.checkPassword(code)) {
			return GMSCMessage.newBuilder().setGmOpenLoginResponse(GmOpenLoginResponse.newBuilder().setErrorCode(false))
					.build();
		}
		systemManager.open();

		return GMSCMessage.newBuilder().setGmOpenLoginResponse(GmOpenLoginResponse.newBuilder().setErrorCode(true))
				.build();
	}

	/**
	 * 所有人下线
	 * 
	 * @author wcy 2016年12月9日
	 */
	private void everybodyOffline() {
		// 所有人下线
		Collection<IoSession> allSession = SessionCache.getAllSession();
		Iterator<IoSession> it = allSession.iterator();
		while (it.hasNext()) {
			it.next().close(true);
		}

		for (RoleInterface roleInterface : RoleCache.getRoleMap().values()) {
			try {
				SessionCloseHandler.manipulate((Role) roleInterface);
			} catch (Exception e) {
				System.out.println("Role: " + roleInterface.getRoleId() + " saveError!");
				e.printStackTrace();
			}
		}
	}
}
