package com.zzti.utils;

import java.io.UnsupportedEncodingException;

public class StringUtils {

	public StringUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * ×Ö·û´®×ªÂë
	 * 
	 * @param context
	 *            ×Ö·û´®ÄÚÈÝ
	 * @param sCode
	 *            À´Ô´±àÂë
	 * @param dCode
	 *            Ä¿±ê±àÂë
	 * @return
	 */
	public static String ConvertString(String context, String sCode,
			String dCode) {
		try {
			return new String(context.getBytes(sCode), dCode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return context;
	}

	/**
	 * ×Ö·û´®×ªÂë
	 * @param context ×Ö·û´®ÄÚÈÝ
	 * @param dCode Ä¿±ê±àÂë
	 * @return
	 */
	public static String ConvertString(String context, String dCode) {
		try {
			return new String(context.getBytes(System
					.getProperty("file.encoding")), dCode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return context;

	}
}
