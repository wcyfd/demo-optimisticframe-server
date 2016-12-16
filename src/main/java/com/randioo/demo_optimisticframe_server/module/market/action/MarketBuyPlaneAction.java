package com.randioo.demo_optimisticframe_server.module.market.action;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.market.service.MarketService;
import com.randioo.demo_optimisticframe_server.protocal.Market.MarketBuyPlaneRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(MarketBuyPlaneRequest.class)
public class MarketBuyPlaneAction extends ActionSupport {
	private MarketService marketService;

	public void setMarketService(MarketService marketService) {
		this.marketService = marketService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		MarketBuyPlaneRequest request = (MarketBuyPlaneRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		GeneratedMessage message = marketService.buyPlane(role, request.getPlaneId());
		if (message != null) {
			session.write(message);
		}
	}
}
