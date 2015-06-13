package com.zzti.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class Common {
	public static String ServiceURL;
	
	public static int PageSize;
	public static String PageType;
	
	public static String EmailHost;
	public static String EmailPort;
	public static String EmailFrom;
	public static String EmailUser;
	public static String EmailPwd;
	public static String EmailAuth;
	
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
		
		PageSize= Integer.parseInt(pro.getProperty("pageSize","20"));
		PageType = pro.getProperty("pageType","English");
		
		EmailHost = pro.getProperty("emailHost");
		EmailPort = pro.getProperty("emailPort");
		EmailFrom = pro.getProperty("emailFrom");
		EmailUser = pro.getProperty("emailUser");
		EmailPwd = pro.getProperty("emailPwd");
		EmailAuth = pro.getProperty("emailAuth","false");
		//System.out.println(String.format("%1$s,%2$s,%3$s,%4$s", ServiceURL,EmailHost,EmailPort,EmailFrom));
	}
	
	
	/*
	 * get string md5
	 */
	public static String getMD5(String source) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
