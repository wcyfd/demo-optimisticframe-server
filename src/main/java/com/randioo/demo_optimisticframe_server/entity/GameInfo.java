package com.randioo.demo_optimisticframe_server.entity;


public class GameInfo {
	private int roleId;
	private int score;

	

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
