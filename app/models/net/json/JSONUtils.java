package models.net.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.google.gson.Gson;

public class JSONUtils {
	public static List<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		User user = new User();
		user.setAddr("北京 海淀 中关村");
		user.setAge(25);
		user.setUname("lenzhao");
		
		User user1 = new User();
		user1.setAddr("北京 海淀 中关村");
		user1.setAge(25);
		user1.setPwd("123456");
		user1.setUname("lenzhao");
		user1.setTime(new Date());
		user1.setUser(user);
		
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false); 
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT); 	
		config.setExcludes(new String[] { "user"}); 
		config.registerJsonBeanProcessor(Date.class, new MyDefaultDateProcessor());
		JSONObject json = JSONObject.fromObject(user1,config);
		System.out.println(json.toString());
		
		Gson gson = new Gson();
		String str = gson.toJson(user1);
		System.out.println(str);
		System.out.println(JSONUtils.class.toString());
		
	}
	
}
