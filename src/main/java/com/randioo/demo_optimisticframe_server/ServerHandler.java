package com.randioo.demo_optimisticframe_server;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.protocal.ClientMessage.CSMessage;
import com.randioo.demo_optimisticframe_server.protocal.gm.GMClientMessage.GMCSMessage;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.navigation.Navigation;
import com.randioo.randioo_server_base.net.IActionSupport;
import com.randioo.randioo_server_base.net.IoHandlerAdapter;
import com.randioo.randioo_server_base.utils.template.Function;

public class ServerHandler extends IoHandlerAdapter {

	private List<Function> actionChains = new ArrayList<>();
	public ServerHandler(){
		init();
	}
	
	public void init() {
		actionChains.add(new NormalAction());
		actionChains.add(new GMAction());
	}
	@Override
	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("roleId:" + session.getAttribute("roleId") + " sessionCreated");
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		System.out.println("roleId:" + session.getAttribute("roleId") + " sessionOpened");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("roleId:" + session.getAttribute("roleId") + " sessionClosed");
		Role role = (Role) RoleCache.getRoleBySession(session);
		if (role != null) {
			try {
				SessionCloseHandler.manipulate(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {

	}

	@Override
	public void exceptionCaught(IoSession session, Throwable e) throws Exception {

	}

	@Override
	public void messageReceived(IoSession session, Object messageObj) throws Exception {
		InputStream input = (InputStream) messageObj;
		input.mark(0);
		try {			
			for (Function func : actionChains) {
				boolean result = (Boolean) func.apply(input, session);
				if (result)
					break;
			}
		} catch (Exception e) {			
			System.out.println("ip:" + getIPAddress(session));			
			e.printStackTrace();
			session.close(true);
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		String messageStr = message.toString();
		if (messageStr.contains("ping") || messageStr.contains("scFightSendKeyFrame")
				|| messageStr.contains("fightReceivePlaneGameControl")) {
		} else {
			System.out.println(messageStr);
		}
	}

	private static String getIPAddress(IoSession session){
		InetSocketAddress address = (InetSocketAddress)session.getRemoteAddress();
		return address.getAddress().getHostAddress();
	}
	/**
	 * 消息事件分发
	 * 
	 * @param message
	 * @param session
	 * @author wcy 2017年1月3日
	 */
	private void actionDispatcher(GeneratedMessage message, IoSession session) {
		Map<FieldDescriptor, Object> allFields = message.getAllFields();
		for (Map.Entry<FieldDescriptor, Object> entrySet : allFields.entrySet()) {

			String name = entrySet.getKey().getName();
			if(name.equals("tag")){
				continue;
			}
			IActionSupport action = Navigation.getAction(name);
			try {
				action.execute(entrySet.getValue(), session);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("伪造的协议ID：" + name);
				session.close(true);
			}
		}
	}
	private class NormalAction implements Function {

		@Override
		public Boolean apply(Object... objects) {
			InputStream input = (InputStream) objects[0];
			IoSession session = (IoSession) objects[1];
			
			boolean result = false;
			try {
				input.reset();
				CSMessage message = CSMessage.parseDelimitedFrom(input);

				if (message != null) {
					int type = message.getTag();
					if (type == 0) {
						result = true;
						printMessage(message);
						actionDispatcher(message, session);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

	}

	private class GMAction implements Function {
		@Override
		public Boolean apply(Object... objects) {
			InputStream input = (InputStream) objects[0];
			IoSession session = (IoSession) objects[1];
			boolean result = false;
			try {
				input.reset();
				GMCSMessage message = GMCSMessage.parseDelimitedFrom(input);

				if (message != null) {
					int type = message.getTag();
					if (type == 1) {
						result = true;
						printMessage(message);
						actionDispatcher(message, session);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	}
	
	private void printMessage(GeneratedMessage message){
		String messageStr = message.toString();
		if (messageStr.contains("pingRequest") || messageStr.contains("pingResponse")
				|| messageStr.contains("fightReceivePlaneGameControl")) {

		} else {
			System.out.println(message);
		}
	}
}
