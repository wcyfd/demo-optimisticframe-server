package com.randioo.demo_optimisticframe_server.entity.file;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.randioo.demo_optimisticframe_server.cache.file.PlayerPlaneConfigCache;

public class PlayerPlaneConfig{
	public static String urlKey="playerPlane.tbl";
	/**ID*/
	public int id;
	/**name*/
	public String name;
	/**skin*/
	public String skin;
	/**bulletID*/
	public int bulletID;
	/**hpMax*/
	public int hpMax;
	/**speed*/
	public int speed;
	/**price*/
	public int price;
	/**type*/
	public int type;
		
	public static void parse(ByteBuffer data){
		data.order(ByteOrder.LITTLE_ENDIAN);
		while(data.hasRemaining()){
			byte[] b = null;
			PlayerPlaneConfig config = new PlayerPlaneConfig();
			config.id=data.getInt();
			b = new byte[data.getShort()];data.get(b);config.name=new String(b);
			b = new byte[data.getShort()];data.get(b);config.skin=new String(b);
			config.bulletID=data.getInt();
			config.hpMax=data.getInt();
			config.speed=data.getInt();
			config.price=data.getInt();
			config.type=data.getInt();
			
			PlayerPlaneConfigCache.putConfig(config);
		}
	}
}
