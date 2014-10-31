package models.encode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @author lenzhao 
 * @email zhaosl1017@gmail.com
 * @date  2014-10-31 下午12:29:43
 */
public class MD5Test {
	public static void main(String[] args) {
		try {
			String str = "zhaoshiling";
			System.out.println(enCode(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String enCode(String str) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] b = md.digest();
		return convertToHexString(b);
	}
	
	public static String convertToHexString(byte data[]) {
		  StringBuffer strBuffer = new StringBuffer();
		  for (int i = 0; i < data.length; i++) {
			  //位与
			  strBuffer.append(Integer.toHexString(0xff & data[i]));
		  }
		  return strBuffer.toString();
	}
}
