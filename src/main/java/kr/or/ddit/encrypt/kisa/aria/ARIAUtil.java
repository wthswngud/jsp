﻿/**
 * 전자정부 제공 ARIAUTIL
 * ARIAUtil
 */
//package crdf.regi.egov.security;
package kr.or.ddit.encrypt.kisa.aria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

public class ARIAUtil {

	public static String ariaEncrypt(String str, String privateKey) 
			throws InvalidKeyException, UnsupportedEncodingException {
		if (str==null || str.equals("")) return "";

		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);
		p = new byte[str.getBytes().length]; 
		p = str.getBytes();

		int len = str.getBytes().length;
		if ((len % 16) != 0) {
			len = (len / 16 + 1) * 16;
		}
		c = new byte[len];
		System.arraycopy(p, 0, c, 0, p.length);
		instance.encrypt(p, c, p.length);

		return ARIAEngine.byteArrayToHex(c).toUpperCase();
	}

	/**
	 * @param privateKey
	 * @param src
	 * @param dest
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 */
	public static void ariaFileEncrypt(String privateKey, String src, String dest) 
	throws IOException, InvalidKeyException, UnsupportedEncodingException {
		File f = new File(src); 
		FileInputStream fis = new FileInputStream(src);

		long length = f.length();
		byte[] b = new byte[(int)length];

		try {
			int offset = 0;
			int numRead = 0;
			while (offset < b.length && (numRead=fis.read(b, offset, b.length-offset)) >= 0) {
				offset += numRead;
			}
			if (offset < b.length) {
				throw new IOException(f.getName());
			}
		} finally{
			fis.close(); 
		}

		ARIAEngine instance = new ARIAEngine(256, privateKey);
		int len = b.length;
		if ((len % 16) != 0) {
			len = (len / 16 + 1) * 16;
		}
		byte[] c = new byte[len];
		System.arraycopy(b, 0, c, 0, b.length);
		instance.encrypt(b, c, b.length);
		FileOutputStream fos = new FileOutputStream(dest);
		try {
			fos.write(c);
		} catch (IOException e) {

		} finally {
			try {
				fos.close();
			} catch (IOException e) {}
		}
	}

	/*
	 *Aria 복호화
	 */
	public static String ariaDecrypt(String strHex, String privateKey) 
	throws InvalidKeyException, UnsupportedEncodingException  {
		if (strHex==null || strHex.equals("")) return "";

		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);

		c = ARIAEngine.hexToByteArray(strHex);
		p = new byte[c.length];
		instance.decrypt(c, p, p.length);

		StringBuffer buf = new StringBuffer();
		buf.append(new String(p));

		return buf.toString().trim();
	}


	public static void ariaFileDecrypt(String privateKey, String src, String dest) 
	throws IOException, InvalidKeyException, UnsupportedEncodingException {
		File f = new File(src); 
		FileInputStream fis = new FileInputStream(src);

		long length = f.length();
		byte[] b = new byte[(int)length];

		try {
			int offset = 0;
			int numRead = 0;
			while (offset < b.length && (numRead=fis.read(b, offset, b.length-offset)) >= 0) {
				offset += numRead;
			}
			if (offset < b.length) {
				throw new IOException(f.getName());
			}
		} finally{
			fis.close(); 
		}

		ARIAEngine instance = new ARIAEngine(256, privateKey);
		int len = b.length;
		if ((len % 16) != 0) {
			len = (len / 16 + 1) * 16;
		}
		byte[] c = new byte[len];
		System.arraycopy(b, 0, c, 0, b.length);
		instance.decrypt(b, c, b.length);

		FileOutputStream fos = new FileOutputStream(dest); 
		try {
			fos.write(c); 
		} catch (IOException e) {

		} finally {
			try {
				fos.close();
			} catch (IOException e) {}
		}
	}

	private static String makeMasterKey(String str) {
		String appendStr = "Naravision KebiPortal Solution";
		StringBuffer buf = new StringBuffer();
		buf.append(str).append(appendStr);

		return buf.substring(0,32);
	}


	/*
	 *Aria 기본 복호화
	 */
	public static String ariaDecrypt(String strHex) 
	throws InvalidKeyException, UnsupportedEncodingException  {
		String originalData = strHex;
		if (strHex==null || strHex.equals("")) return "";
		StringBuffer buf = null;
		try {
			String privateKey = "dkaghghkzl@l";
			
			byte[] p;
			byte[] c;
			ARIAEngine instance = new ARIAEngine(256, privateKey);
			
			c = hexToByteArray(strHex);
			p = new byte[c.length];
			instance.decrypt(c, p, p.length);
			
			buf = new StringBuffer();
			buf.append(new String(p));
			return buf.toString().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return originalData;
		}
	}
	/*
	*aria 기본 암호화
	*/
	public static String ariaEncrypt(String str) 
	throws InvalidKeyException, UnsupportedEncodingException {
		if (str==null || str.equals("")) return "";
		String privateKey = "dkaghghkzl@l";

		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);
		p = new byte[str.getBytes().length];
		p = str.getBytes();

		int len = str.getBytes().length;
		if ((len % 16) != 0) {
			len = (len / 16 + 1) * 16;
		}
		c = new byte[len];
		System.arraycopy(p, 0, c, 0, p.length);
		instance.encrypt(p, c, p.length);

		return byteArrayToHex(c).toUpperCase();
	}
	
	/*
	*캐릭터셋 변경 암호화
	*/
	public static String ariaCharEncrypt(String str, String charset) 
	throws InvalidKeyException, UnsupportedEncodingException {
		if (str==null || str.equals("")) return "";
		String privateKey = "dkaghghkzl@l";
		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);
		p = new byte[str.getBytes(charset).length];
		p = str.getBytes(charset);
		int len = str.getBytes(charset).length;
		if ((len % 16) != 0) {
			len = (len / 16 + 1) * 16;
		}
		c = new byte[len];
		System.arraycopy(p, 0, c, 0, p.length);
		instance.encrypt(p, c, p.length);

		return byteArrayToHex(c).toUpperCase();
	}
	
	/*
	*캐릭터셋 변경 암호화
	*(서버타입설정 열람서버 : read, 등록관리서버 : regi)
	*/
	public static String ariaCharEncrypt(String str, String charset, String server) 
	throws InvalidKeyException, UnsupportedEncodingException {
		if (str==null || str.equals("")) return "";
		String privateKey = "";
		if(server.equals("regi")) privateKey = "dkaghghkzl@l";
		else privateKey = "dkaghghkzl@l";

		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);
		p = new byte[str.getBytes(charset).length];
		p = str.getBytes(charset);
		int len = str.getBytes(charset).length;
		if ((len % 16) != 0) {
			len = (len / 16 + 1) * 16;
		}
		c = new byte[len];
		System.arraycopy(p, 0, c, 0, p.length);
		instance.encrypt(p, c, p.length);

		return byteArrayToHex(c).toUpperCase();
	}



	/*
	 *Aria 캐릭터셋 변경 복호화
	 */
	public static String ariaCharDecrypt(String strHex,  String charset) 
	throws InvalidKeyException, UnsupportedEncodingException  {
		if (strHex==null || strHex.equals("")) return "";
		String privateKey = "dkaghghkzl@l";

		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);

		c = hexToByteArray(strHex);
		p = new byte[c.length];
		instance.decrypt(c, p, p.length);

		StringBuffer buf = new StringBuffer();
		buf.append(new String(p,charset));

		return buf.toString().trim();
	}
	
	/*
	 *Aria 캐릭터셋 변경 복호화
	 *(서버타입설정 열람서버 : read, 등록관리서버 : regi)
	 */
	public static String ariaCharDecrypt(String strHex,  String charset, String server) 
	throws InvalidKeyException, UnsupportedEncodingException  {
		if (strHex==null || strHex.equals("")) return "";
		String privateKey = "";
		if(server.equals("regi")) privateKey = "dkaghghkzl@l";
		else privateKey = "dkaghghkzl@l";
		 
		byte[] p;
		byte[] c;
		ARIAEngine instance = new ARIAEngine(256, privateKey);

		c = hexToByteArray(strHex);
		p = new byte[c.length];
		instance.decrypt(c, p, p.length);

		StringBuffer buf = new StringBuffer();
		buf.append(new String(p,charset));

		return buf.toString().trim();
	}

	// hex to byte[] 
	public static byte[] hexToByteArray(String hex) { 
		if (hex == null || hex.length() == 0) { 
			return null; 
		} 

		byte[] ba = new byte[hex.length() / 2]; 
		for (int i = 0; i < ba.length; i++) { 
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16); 
		} 
		return ba; 
	} 

	// byte[] to hex 
	public static String byteArrayToHex(byte[] ba) { 
		if (ba == null || ba.length == 0) { 
			return null; 
		} 

		StringBuffer sb = new StringBuffer(ba.length * 2); 
		String hexNumber; 
		for (int x = 0; x < ba.length; x++) { 
			hexNumber = "0" + Integer.toHexString(0xff & ba[x]); 

			sb.append(hexNumber.substring(hexNumber.length() - 2)); 
		} 
		return sb.toString(); 

	}
}