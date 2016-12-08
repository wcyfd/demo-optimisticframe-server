package com.randioo.demo_optimisticframe_server.entity;

import com.randioo.randioo_server_base.utils.game.Gameable;
import com.randioo.randioo_server_base.utils.game.game_type.GameBase;
import com.randioo.randioo_server_base.utils.game.matcher.MatchInfo;
import com.randioo.randioo_server_base.utils.game.matcher.Matchable;

public class Role implements Matchable, Gameable {
	private int roleId;
	private String name;
	private String account;
	private Game game;
	private MatchInfo matchInfo;
	private boolean prepare;
	private boolean isNPC;

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

	@Override
	public void setMatchInfo(MatchInfo matchInfo) {
		// TODO Auto-generated method stub
		this.matchInfo = matchInfo;
	}

	@Override
	public MatchInfo getMatchInfo() {
		// TODO Auto-generated method stub
		return matchInfo;
	}

	@Override
	public void setPrepare(boolean prepare) {
		// TODO Auto-generated method stub
		this.prepare = prepare;
	}

	@Override
	public boolean isPrepare() {
		// TODO Auto-generated method stub
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

	@Override
	public void setNpc(boolean isNpc) {
		// TODO Auto-generated method stub
		this.isNPC = isNpc;
	}

	@Override
	public boolean isNPC() {
		// TODO Auto-generated method stub
		return isNPC;
	}

}
