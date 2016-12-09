package com.randioo.demo_optimisticframe_server.entity;

import com.randioo.randioo_server_base.entity.Matcher;
import com.randioo.randioo_server_base.utils.game.Gameable;
import com.randioo.randioo_server_base.utils.game.game_type.GameBase;

public class Role extends Matcher implements Gameable {
	private int roleId;
	private String name;
	private String account;
	private Game game;
	private boolean prepare;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setPrepare(boolean prepare) {
		this.prepare = prepare;
	}

	public boolean isPrepare() {
		return prepare;
	}

	@Override
	public void setGame(GameBase game) {
		// TODO Auto-generated method stub
		this.game = (Game) game;
	}

	@Override
	public GameBase getGame() {
		// TODO Auto-generated method stub
		return game;
	}

}
