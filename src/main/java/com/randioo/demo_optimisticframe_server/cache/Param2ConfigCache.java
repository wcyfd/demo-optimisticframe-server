package com.randioo.demo_optimisticframe_server.cache;

import java.util.HashMap;
import java.util.Map;

import com.randioo.demo_optimisticframe_server.config.Param2Config;

public class Param2ConfigCache {
	private static Map<Integer,Param2Config> configMap = new HashMap<>();
	public static void putConfig(Param2Config config){
		System.out.println(config);
	}
}
