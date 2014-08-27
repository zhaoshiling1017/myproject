package models.gson;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
public class GsonDemo {
	public static void main(String[] args) {
		/*try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String str  = "zhaoshiling";
			md.update(str.getBytes());
			byte[] b = md.digest();
			System.out.println(convertToHexString(b));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		try {
			//统一资源标识符
			URI uri = new URI("http://192.168.21.77:8080/swp/mainPage?aa=11&bb%3D22");
			URL url2;
			try {
				url2 = new URL("http://192.168.21.77:8080/swp/mainPage?aa=11&bb%3D22");
				 System.out.println(url2.getQuery());//不解码  
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
			//用户信息（root:root）
			System.out.println(uri.getPort());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
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
