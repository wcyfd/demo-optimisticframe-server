package com.randioo.demo_optimisticframe_server.module.ping.service;

import com.randioo.demo_optimisticframe_server.entity.Role;
import com.randioo.demo_optimisticframe_server.protocal.Ping.PingResponse;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseService;

public class PingServiceImpl extends BaseService implements PingService {

	@Override
	public SCMessage ping(Role role, long clientTimestamp) {
		// TODO Auto-generated method stub
		long serverTime = System.currentTimeMillis();
		
		return SCMessage.newBuilder().setPingResponse(
				PingResponse.newBuilder().setClientTimestamp(clientTimestamp)
						.setServerTimestamp(serverTime)).build();
		
	}

}
