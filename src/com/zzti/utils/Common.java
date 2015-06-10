package com.zzti.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
