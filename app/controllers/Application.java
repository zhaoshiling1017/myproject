package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.driver.DBConversion;

import models.Persion;
import play.Play;
import play.db.DB;
import play.db.jpa.JPAPlugin;
import play.modules.redis.Redis;
import play.mvc.Controller;
import play.server.Server;

public class Application extends Controller {

    public static void index(){
    	/*Persion p = new Persion();
    	p.setAddress("北京海淀区");
    	p.setAge(27);
    	p.setEmail("zhaoshiling1017@163.com");
    	p.setName("zhaoshiling");
    	p.create();*/
    	//ExcuProc.createBussinKinds("beijing","zhongruan","ruanjian");
    	//ExcuProc.executeProcedure();
    	//setPersion();
    
    	/*String sql = "select new list(name,address,email) from Persion";
    	List<List<String>> map = Persion.find(sql).fetch();
    	System.out.println("-------"+map.size());
    	for(List<String> m : map){
    		System.out.println(m.get(0)+"------"+m.get(1)+"---------"+m.get(2));
    	}*/
    	/*CallableStatement proc = null;
    	ResultSet rs = null;
        proc = DB.getConnection().prepareCall("call testc(?)");
        proc.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
        proc.execute();
        rs = (ResultSet)proc.getObject(1);
        
        while(rs.next())
        {
            System.out.println("<tr><td>" + rs.getLong(1) + "</td><td>"+rs.getString(2)+"</td></tr>");
        }*/
    	/*List<String> list = new ArrayList<String>();
    	list.add("name");
    	list.add("address");
    	list.add("email");*/
    	
    	//List<String> ids = Persion.find("select address as addr from Persion where 1=1").fetch();
    	//System.out.println(ids.size());
    	//System.out.println(">>>>>>>>>>>>"+ids.size());
    	//Persion.delete("id in (?1)", ids);
    	/*List<Persion> pList = Persion.find("1=1").fetch();
    	Collections.sort(pList, new BeanComparator("address"));
    	for(Persion p : pList){
    		System.out.println(p.getAddress()+"---"+p.getName()+"----"+p.getEmail());
    	}
        render(); */
    	/*boolean flag;
		try {
			flag = DB.getConnection().createStatement().execute("insert into job_test(a,b,c) values(date'2017-08-05','2017','08')");
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
    	/*String name = "ZHAOSHILING";
    	String sql = "select NAME,eMAIL from t_persion";
    	ResultSet rs = DB.executeQuery(sql);
    	try {
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	render(name);*/
    	/*Map<String,Object> map = new HashMap<String,Object>();
    	map.put("name", "lenzhao");
    	map.put("age", 26.555);
    	map.put("email", "zhaoshiling1017@163.com");
    	map.put("i", 2);
    	map.put("j", 3);
    	Map<String,Map<String,Object>> map1 = new HashMap<String,Map<String,Object>>();
    	map1.put("2014", map);
    	List<String> list = new ArrayList<String>();
    	list.add("zhao");
    	list.add("shi");
    	list.add("ling");*/
    	render();
    }
    public static void setPersion(){
    	Persion p1 = new Persion();
    	p1.setAddress("beijing");
    	p1.setAge(21);
    	p1.setEmail("zhaoshiling@163.com");
    	p1.setName("lenzhao");
    	p1.save();
    	Persion p2 = new Persion();
    	p2.setAddress("shanghai");
    	p2.setAge(22);
    	p2.setEmail("zhaoshiling@163.com");
    	p2.setName("lenzhao");
    	p2.save();
    	Persion p3 = new Persion();
    	p3.setAddress("guangzhou");
    	p3.setAge(23);
    	p3.setEmail("zhaoshiling@163.com");
    	p3.setName("lenzhao");
    	p3.save();
    }
}