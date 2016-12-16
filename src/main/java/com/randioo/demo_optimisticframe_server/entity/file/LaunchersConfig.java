package com.randioo.demo_optimisticframe_server.entity.file;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.randioo.demo_optimisticframe_server.cache.file.LaunchersConfigCache;

public class LaunchersConfig{
	public static String urlKey="launchers.tbl";
	/**ID*/
	public int id;
	/**NAME*/
	public String name;
	/**SKIN*/
	public String skin;
	/**VALUE*/
	public int value;
	/**INTERVAL*/
	public int interval;
		
	public static void parse(ByteBuffer data){
		data.order(ByteOrder.LITTLE_ENDIAN);
		while(data.hasRemaining()){
			byte[] b = null;
			LaunchersConfig config = new LaunchersConfig();
			config.id=data.getInt();
			b = new byte[data.getShort()];data.get(b);config.name=new String(b);
			b = new byte[data.getShort()];data.get(b);config.skin=new String(b);
			config.value=data.getInt();
			config.interval=data.getInt();
			
			LaunchersConfigCache.putConfig(config);
		}
	}
}
