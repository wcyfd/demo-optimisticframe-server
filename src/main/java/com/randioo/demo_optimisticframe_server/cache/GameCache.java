package com.randioo.demo_optimisticframe_server.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.randioo.demo_optimisticframe_server.entity.Game;

public class GameCache {
	private static int gameId = 0;
	private static Map<Integer, Game> gamesMap = new HashMap<>();
	private static ReentrantLock lock = new ReentrantLock();

	public static int getGameId() {
		return gameId++;
	}

	public static Map<Integer, Game> getGamesMap() {
		return gamesMap;
	}

	public static ReentrantLock getLock() {
		return lock;
	}
}
