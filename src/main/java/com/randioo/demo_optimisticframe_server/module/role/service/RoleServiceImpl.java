package com.randioo.demo_optimisticframe_server.module.role.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.protocal.Role.RoleChoosePlaneResponse;
import com.randioo.demo_optimisticframe_server.protocal.Role.RoleFallPlaneResponse;
import com.randioo.demo_optimisticframe_server.protocal.ServerMessage.SCMessage;
import com.randioo.randioo_server_base.module.BaseService;

public class RoleServiceImpl extends BaseService implements RoleService {

	@Override
	public GeneratedMessage choosePlane(Role role, int planeId, int index) {
		//选择某个栏位的飞机
		role.getUsePlanes().put(index, planeId);
		return SCMessage.newBuilder().setRoleChoosePlaneResponse(RoleChoosePlaneResponse.newBuilder()).build();
	}

	@Override
	public GeneratedMessage fallPlane(Role role, int index) {
		//移除飞机
		role.getUsePlanes().remove(index);		
		return SCMessage.newBuilder().setRoleFallPlaneResponse(RoleFallPlaneResponse.newBuilder()).build();
	}

}
