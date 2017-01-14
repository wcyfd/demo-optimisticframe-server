package com.randioo.demo_optimisticframe_server.module.gm.action;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.module.gm.service.GmService;
import com.randioo.demo_optimisticframe_server.protocal.gm.GM.GmOpenLoginRequest;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(GmOpenLoginRequest.class)
public class GmCloseAction extends ActionSupport {
	private GmService gmService;

	public void setGmService(GmService gmService) {
		this.gmService = gmService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		// TODO Auto-generated method stub
		GmOpenLoginRequest request = (GmOpenLoginRequest) data;
		GeneratedMessage message = gmService.rejectLogin(request.getCode());
		if (message != null) {
			session.write(message);
		}
	}
}
