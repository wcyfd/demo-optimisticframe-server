package com.randioo.demo_optimisticframe_server.module.fight.service;

import java.util.List;

import org.apache.mina.core.session.IoSession;

import com.google.protobuf.GeneratedMessage;
import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.demo_optimisticframe_server.entity.po.Game;
import com.randioo.randioo_server_base.module.BaseServiceInterface;
import com.randioo.randioo_server_base.module.match.Matchable;

public interface FightService extends BaseServiceInterface {

	public void loadComplete(Role role, IoSession session);

	public void loadResource(int playCount, List<? extends Matchable> matchables);

	public void receive_HitGame_ControlInfo(Role role, int enemyId);

	public void receive_PlaneGame_ControlInfo(Role role, GeneratedMessage gameActionMessage);

	/**
	 * 发送关键帧信息
	 * 
	 * @param game
	 * @author wcy 2016年11月24日
	 */
	void sendKeyFrameInfo(Game game);

	void runGameLogic(Game game);

	/**
	 * 游戏服务器初始化
	 * 
	 * @param matchInfo
	 * @return
	 * @author wcy 2016年11月29日
	 */
	Game serverGameInit(int playCount, List<? extends Matchable> matchables);

	/**
	 * 游戏结束
	 * 
	 * @param score
	 * @return
	 * @author wcy 2016年12月12日
	 */
	void gameOver(Role role, int score, IoSession session);

	void offline(Role role);

	/**
	 * 游戏结束统一接口
	 * 
	 * @param role
	 * @param score
	 * @author wcy 2016年12月22日
	 */
	void gameOver(Role role, int score);

}
