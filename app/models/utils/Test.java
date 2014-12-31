package models.utils;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author lenzhao 
 * @email zhaosl1017@gmail.com
 * @date  2014-10-31 下午12:16:37
 */
public class Test {
	public static XMLGregorianCalendar asXMLGregorianCalendar(Date date) throws Exception {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        }
    }
	public static void main(String[] args){
		try {
			XMLGregorianCalendar calendar = asXMLGregorianCalendar(new Date());
			System.out.println(calendar.toXMLFormat());
		} catch (Exception e) {
			e.printStackTrace();
		}
		BigInteger bt = new BigInteger("12345567");
		System.out.println(bt.longValue());
		/*DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			Date date = df.parse("29/09/2014 08:46:11 MEST");
			System.out.println(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		/*Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.add(Calendar.MINUTE, -2);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(cal1.getTime()));
		System.out.println(df.format(cal2.getTime()));
		System.out.println(cal1.getTimeInMillis()-cal2.getTimeInMillis());
		System.out.println(cal2.after(cal1));*/
		
		try {
			//统一资源标识符
			URI uri = new URI("http://192.168.21.77:8080/swp/mainPage?aa=11&bb%3D22");
			//统一资源定位符
			URL url2;
			try {
				url2 = new URL("http://192.168.21.77:8080/swp/mainPage?aa=11&bb%3D22");
				 System.out.println(url2.getQuery());//不解码  
				 System.out.println(uri.getQuery());//解码
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}   
			//用户信息（root:root）
			System.out.println(uri.getPort());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
