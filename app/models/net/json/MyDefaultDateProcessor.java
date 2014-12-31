package models.net.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

public class MyDefaultDateProcessor implements JsonBeanProcessor{

	@Override
	public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
		JSONObject jsonObject = new JSONObject();
		Date date = (Date) bean;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		jsonObject.element("time", df.format(date));
		return jsonObject;
	}

	
}
