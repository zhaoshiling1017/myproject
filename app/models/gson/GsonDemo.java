package models.gson;

import java.util.ArrayList;
import java.util.List;

import org.h2.constant.SysProperties;

import com.google.gson.Gson;
public class GsonDemo {
	public static void main(String[] args) {
		User u = new User();
		u.setName("zhao");
		u.setRemark("001");
		Phone p1 = new Phone();
		p1.setPhNum("10086");
		Phone p2 = new Phone();
		p2.setPhNum("10010");
		List<Phone> list = new ArrayList<Phone>();
		list.add(p1);
		list.add(p2);
		u.setPhones(list);
		Gson gson = new Gson();
		String json = gson.toJson(u);
		System.out.println(json);
		User uu = gson.fromJson(json, User.class);
		List<Phone> pp = uu.getPhones();
		for(Phone pe : pp){
			System.out.println(pe.getPhNum());
			System.out.println(pe.getArea());
			System.out.println(pe.getCity());
		}
	}
}
