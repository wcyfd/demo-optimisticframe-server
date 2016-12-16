package com.randioo.demo_optimisticframe_server.cache.file;

import java.util.HashMap;
import java.util.Map;

import com.randioo.demo_optimisticframe_server.entity.file.EnemyPlaneConfig;

public class EnemyPlaneConfigCache {
	private static Map<Integer,EnemyPlaneConfig> map = new HashMap<>();
	public static void putConfig(EnemyPlaneConfig config){
		map.put(config.id, config);
	}
}
