package com.randioo.demo_optimisticframe_server.cache;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.session.IoSession;

import com.randioo.demo_optimisticframe_server.entity.Role;

public class RoleCache {
	private static Set<String> accounts = new HashSet<>();
	private static Set<String> names = new HashSet<>();
	private static Map<Integer, Role> roleMap = new ConcurrentHashMap<>();
	private static Map<String,Role> accountsMap = new ConcurrentHashMap<>();

	public static Set<String> getAccountSet() {
		// TODO Auto-generated method stub
		return accounts;
	}

	public static Set<String> getNameSet() {
		// TODO Auto-generated method stub
		return names;
	}

	public static void putNewRole(Role role) {
		// TODO Auto-generated method stub
		accounts.add(role.getAccount());
		names.add(role.getName());
		roleMap.put(role.getRoleId(), role);
		accountsMap.put(role.getAccount(), role);
	}

	public static Role getRoleByAccount(String account) {
		// TODO Auto-generated method stub
		return accountsMap.get(account);
	}

	public static void putRoleCache(Role role) {
		// TODO Auto-generated method stub
		roleMap.put(role.getRoleId(), role);
		accountsMap.put(role.getAccount(), role);
	}
	
	public static Role getRoleBySession(IoSession ioSession){
		try {
			Integer roleId = (Integer) ioSession.getAttribute("roleId");
			if (roleId == null)
				return null;
			return roleMap.get(roleId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Role getRoleById(int roleId){
		return roleMap.get(roleId);
	}

}
