package com.randioo.demo_optimisticframe_server.module.market.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneResponse;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseService;

public class MarketServiceImpl extends BaseService implements MarketService {

	@Override
	public GeneratedMessage buyPlane(Role role, int planeId) {
		if(!role.getPlanes().contains(planeId)){
			role.getPlanes().add(planeId);			
		}
		return SCMessage.newBuilder().setMarketBuyPlaneResponse(MarketBuyPlaneResponse.newBuilder()).build();
	}

}
