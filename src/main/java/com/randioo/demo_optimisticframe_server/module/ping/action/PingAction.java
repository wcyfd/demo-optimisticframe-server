package com.randioo.demo_optimisticframe_server.module.ping.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.ping.service.PingService;
import com.randioo.demo_optimisticframe_server.protocal.Ping.PingRequest;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(PingRequest.class)
public class PingAction extends ActionSupport {

	private PingService pingService;

	public void setPingService(PingService pingService) {
		this.pingService = pingService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		PingRequest message = (PingRequest) data;

		Role role = (Role)RoleCache.getRoleBySession(session);
		SCMessage sc = pingService.ping(role, message.getClientTimestamp());
		if(message!=null){
			session.write(sc);	
		}

	}

}
