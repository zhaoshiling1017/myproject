package models.gson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class GsonDemo {
	public static void main(String[] args) {
		/*Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.add(Calendar.MINUTE, -2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(cal1.getTime()));
		System.out.println(df.format(cal2.getTime()));
		System.out.println(cal1.getTimeInMillis()-cal2.getTimeInMillis());
		System.out.println(cal2.after(cal1));*/
		
		/*try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			String str  = "zhaoshiling";
			md.update(str.getBytes());
			byte[] b = md.digest();
			System.out.println(convertToHexString(b));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		/*try {
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
		}*/
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
