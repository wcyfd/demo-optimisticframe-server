package com.randioo.demo_optimisticframe_server.module.gm.action;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.module.gm.service.GmService;
import com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmShutdownServerRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(GmShutdownServerRequest.class)
public class GmShutdownAction extends ActionSupport {
	private GmService gmService;

	public void setGmService(GmService gmService) {
		this.gmService = gmService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub
		GmShutdownServerRequest request = (GmShutdownServerRequest)data;
		gmService.shutdownServer(request.getCode(), session);
	}
}
