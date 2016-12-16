package com.randioo.demo_optimisticframe_server.module.market.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface MarketService extends BaseServiceInterface {
	public GeneratedMessage buyPlane(Role role,int planeId);
}
