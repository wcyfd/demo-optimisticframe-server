package com.randioo.demo_optimisticframe_server.module.role.service;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.randioo_server_base.module.BaseServiceInterface;

public interface RoleService extends BaseServiceInterface{
	/**
	 * 选择飞机
	 * @param role
	 * @param planeId
	 * @param index
	 * @return
	 * @author wcy 2016年12月14日
	 */
	public GeneratedMessage choosePlane(Role role,int planeId,int index);
	
	/**
	 * 飞机下阵
	 * @param role
	 * @param index
	 * @return
	 * @author wcy 2016年12月14日
	 */
	public GeneratedMessage fallPlane(Role role,int index);
}
