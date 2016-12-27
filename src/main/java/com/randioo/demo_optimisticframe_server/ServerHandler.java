package com.randioo.demo_optimisticframe_server;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.Map;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.google.protobuf.Descriptors.FieldDescriptor;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.protocal.ClientMessage.CSMessage;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.navigation.Navigation;
import com.randioo.randioo_server_base.net.IActionSupport;
import com.randioo.randioo_server_base.net.IoHandlerAdapter;

public class ServerHandler extends IoHandlerAdapter {

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
		try {
			CSMessage message = CSMessage.parseDelimitedFrom(input);

			if (null == message) {
				System.out.println("ERR_MESSAGE_REC");
				return;
			}
			String messageStr = message.toString();
			if (messageStr.contains("pingRequest") || messageStr.contains("pingResponse")
					|| messageStr.contains("fightReceivePlaneGameControl")) {

			} else {
				System.out.println(message);
			}

			Map<FieldDescriptor, Object> allFields = message.getAllFields();
			for (Map.Entry<FieldDescriptor, Object> entrySet : allFields.entrySet()) {

				String name = entrySet.getKey().getName();
				IActionSupport action = Navigation.getAction(name);
				Integer roleId = (Integer) session.getAttribute("roleId");

//				System.out.println("服务器接收用户：" + roleId + "的消息，请求指令号为:" + name);

				try {
					action.execute(entrySet.getValue(), session);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("伪造的协议ID：" + name);
					// 判断是否属于无效的协议号 TODO 处理方式可能需要变更
					// if(e.getClass().equals(NumberFakeException.class))
					// {
					session.close(true);
					// }
				}
			}
		} catch (Exception e) {			
			System.out.println("ip:" + getIPAddress(session));			
			e.printStackTrace();
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
}
