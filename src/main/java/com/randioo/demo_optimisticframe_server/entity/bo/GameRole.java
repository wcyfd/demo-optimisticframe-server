package com.randioo.demo_optimisticframe_server.entity.bo;

import com.randioo.randioo_server_base.entity.RoleInterface;
import com.randioo.randioo_server_base.utils.db.Saveable;
import com.randioo.randioo_server_base.utils.game.Gameable;
import com.randioo.randioo_server_base.utils.game.game_type.GameBase;
import com.randioo.randioo_server_base.utils.game.inviter.Invitable;
import com.randioo.randioo_server_base.utils.game.inviter.Invitation;
import com.randioo.randioo_server_base.utils.game.matcher.MatchInfo;
import com.randioo.randioo_server_base.utils.game.matcher.Matchable;

public abstract class GameRole implements Matchable, RoleInterface,Gameable,Saveable,Invitable {
	private MatchInfo matchInfo;
	private boolean npc;

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
	public void setNpc(boolean isNpc) {
		// TODO Auto-generated method stub
		this.npc = isNpc;
	}

	@Override
	public boolean isNPC() {
		// TODO Auto-generated method stub
		return npc;
	}

	private String account;
	private String name;
	private int roleId;

	@Override
	public String getAccount() {
		// TODO Auto-generated method stub
		return account;
	}

	@Override
	public void setAccount(String account) {
		// TODO Auto-generated method stub
		this.account = account;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public int getRoleId() {
		// TODO Auto-generated method stub
		return roleId;
	}

	@Override
	public void setRoleId(int roleId) {
		// TODO Auto-generated method stub
		this.roleId = roleId;
	}
	
	private GameBase gameBase;

	@Override
	public void setGame(GameBase game) {
		// TODO Auto-generated method stub
		this.gameBase = game;
	}

	@Override
	public GameBase getGame() {
		// TODO Auto-generated method stub
		return gameBase;
	}

	private boolean change;
	@Override
	public void setChange(boolean change) {
		// TODO Auto-generated method stub
		this.change = change;
	}

	@Override
	public boolean isChange() {
		// TODO Auto-generated method stub
		if(change){
			return true;
		}
		return checkChange();
	}

	@Override
	public abstract boolean checkChange();
	
	private Invitation invitation;
	
	@Override
	public Invitation getInvitation() {
		// TODO Auto-generated method stub
		return invitation;
	}

	@Override
	public void setInvitation(Invitation invitation) {
		// TODO Auto-generated method stub
		this.invitation = invitation;
	}
}
