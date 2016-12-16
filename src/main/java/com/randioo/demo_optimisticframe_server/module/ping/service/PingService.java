package com.randioo.demo_optimisticframe_server.module.ping.service;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface PingService extends BaseServiceInterface{
	public SCMessage ping(Role role,long clientTimestamp);
}
