package com.zzti.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Common {
	public static String ServiceURL;
	static
	{
		readConfig();
	}
	
	private static void readConfig()
	{	
		InputStream in = Common.class.getClassLoader()
				.getResourceAsStream("config.properties");
		//
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			System.out.println("读取配置文件信息发送错误，错误信息如下：");
			e.printStackTrace();
		}
		//
		ServiceURL = pro.getProperty("serviceUrl");
		System.out.println(ServiceURL);
	}
}
