package com.randioo.demo_optimisticframe_server;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.filter.codec.ProtocolCodecFilter;

import com.randioo.demo_optimisticframe_server.utils.DefaultSystemManager;
import com.randioo.randioo_server_base.module.ServiceManager;
import com.randioo.randioo_server_base.net.ServerConfig;
import com.randioo.randioo_server_base.net.SpringContext;
import com.randioo.randioo_server_base.net.WanServer;
import com.randioo.randioo_server_base.net.protocal.protobuf.ServerMessageCodecFactory;
import com.randioo.randioo_server_base.utils.ConfigLoader;
import com.randioo.randioo_server_base.utils.db.DatabaseInitialization;
import com.randioo.randioo_server_base.utils.sensitive.SensitiveWordDictionary;
import com.randioo.randioo_server_base.utils.system.SystemManager;

/**
 * Hello world!
 *
 */
public class OptimisticFrameDemoServerApp {
	public static void main(String[] args) {
		int port = 6666;
		SensitiveWordDictionary.readAll("./sensitive.txt");
		ConfigLoader.loadConfig("com.randioo.demo_optimisticframe_server.entity.file", "./config.zip");
		SpringContext.initSpringCtx("ApplicationContext.xml");

		DatabaseInitialization databaseInit = (DatabaseInitialization) SpringContext.getBean("databaseInitialization");
		databaseInit.setDatabaseName(databaseInit.getDatabaseName() + port);
		databaseInit.initialize();

		((ServiceManager) SpringContext.getBean("serviceManager")).initServices();
		
		// 服务器开关
		SystemManager systemManager = SpringContext.getBean("systemManager");
		systemManager.close();
		
		System.out.println("Hello OptimisticFrameDemoServerApp!");
		WanServer.startServer(
				new ProtocolCodecFilter(new ServerMessageCodecFactory(Charset.forName(ServerConfig.getCharSet()))),
				new ServerHandler(), new InetSocketAddress(port));
		
		systemManager.open();
	}

}
