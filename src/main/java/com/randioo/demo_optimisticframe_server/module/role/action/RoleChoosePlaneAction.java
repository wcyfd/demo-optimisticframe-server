package com.randioo.demo_optimisticframe_server.module.role.action;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.module.role.service.RoleService;
import com.randioo.demo_optimisticframe_server.protocal.Role.RoleChoosePlaneRequest;
import com.randioo.randioo_server_base.cache.RoleCache;
import com.randioo.randioo_server_base.net.ActionSupport;
import com.randioo.randioo_server_base.net.PTAnnotation;

@PTAnnotation(RoleChoosePlaneRequest.class)
public class RoleChoosePlaneAction extends ActionSupport {
	private RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public void execute(Object data, IoSession session) {
		RoleChoosePlaneRequest request = (RoleChoosePlaneRequest) data;
		Role role = (Role) RoleCache.getRoleBySession(session);
		GeneratedMessage message = roleService.choosePlane(role, request.getPlaneId(), request.getIndex());
		if (message != null) {
			session.write(message);
		}
	}
}
