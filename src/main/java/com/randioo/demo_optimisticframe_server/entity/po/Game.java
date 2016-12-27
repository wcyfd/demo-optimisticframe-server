package com.randioo.demo_optimisticframe_server.entity.po;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import com.randioo.demo_optimisticframe_server.entity.bo.Role;
import com.randioo.randioo_server_base.utils.game.game_type.real_time_strategy_game.RTSGame;

/**
 * @author wcy 2016年11月4日
 *
 */
public class Game extends RTSGame {
	/** 游戏id */
	private int gameId;
	/** 玩家数量 */
	private int controlCount;
	/** 总时间 */
	private int totalTime;
	/** 一秒刷多少帧 */
	private int frameCountInOneSecond;

	/** 是否开始 */
	private boolean start;
	/** 是否结束 */
	private boolean end;
	/** 玩家列表 */
	private Map<Integer, Role> roleMap = new HashMap<>();
	/** 玩家控制信息表 */
	private Map<Integer, GameInfo> gameInfoMap = new HashMap<>();
	/** 房间锁 */
	private ReentrantLock lock = new ReentrantLock();
	private long startTime;
	private boolean hasStartTime;

	public Game(int playCount, int totalSecond, int addDeltaFrame, int frameCountInOneSecond) {
		controlCount = playCount;
		totalTime = totalSecond;
		this.addDeltaFrame = addDeltaFrame;
		this.frameCountInOneSecond = frameCountInOneSecond;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public ReentrantLock getLock() {
		return lock;
	}

	public Map<Integer, Role> getRoleMap() {
		return roleMap;
	}

	public int getControlCount() {
		return controlCount;
	}

	public Map<Integer, GameInfo> getGameInfoMap() {
		return gameInfoMap;
	}

	public void setControlCount(int controlCount) {
		this.controlCount = controlCount;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}

	public int getAddDeltaFrame() {
		return addDeltaFrame;
	}

	public void setAddDeltaFrame(int addDeltaFrame) {
		this.addDeltaFrame = addDeltaFrame;
	}

	public int getFrameCountInOneSecond() {
		return frameCountInOneSecond;
	}

	public void setFrameCountInOneSecond(int frameCountInOneSecond) {
		this.frameCountInOneSecond = frameCountInOneSecond;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public boolean isHasStartTime() {
		return hasStartTime;
	}

	public void setHasStartTime(boolean hasStartTime) {
		this.hasStartTime = hasStartTime;
	}

}
