package com.randioo.demo_optimisticframe_server.config;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.randioo.demo_optimisticframe_server.cache.ParamConfigCache;

public class ParamConfig{
	public static String urlKey="parameter.tbl";
	/**参数项*/
	public String param;
	/**性别*/
	public String value;
	/**颜色*/
	public int color;
		
	public static void parse(ByteBuffer data){
		data.order(ByteOrder.LITTLE_ENDIAN);
		while(data.hasRemaining()){
			byte[] b = null;
			ParamConfig config = new ParamConfig();
			b = new byte[data.getShort()];data.get(b);config.param=new String(b);
			b = new byte[data.getShort()];data.get(b);config.value=new String(b);
			config.color=data.getInt();
			
			ParamConfigCache.putConfig(config);
		}
	}
}
