package com.randioo.demo_optimisticframe_server.module.gm.service;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface GmService extends BaseServiceInterface{
	public GeneratedMessage rejectLogin(String code);

	public void shutdownServer(String code, IoSession session);

	public GeneratedMessage openLogin(String code);
}
