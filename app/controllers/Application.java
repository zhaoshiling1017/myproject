package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import models.Person;
import models.utils.MyDsUtils;
import play.cache.Cache;
import play.data.validation.Required;
import play.libs.Codec;
import play.libs.Images;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() throws Exception{
    	render();
    }
    public static void captcha(String id) {
        Images.Captcha captcha = Images.captcha();
        String code = captcha.getText("#E4EAFD");
        Cache.set(id, code, "3mn");
        renderBinary(captcha);
    }
    public static void show(Long id) {
    	Person ps = null;
    	if(null != id){
    		ps = Person.findById(id);
    	}
        String randomID = Codec.UUID();
        render(ps, randomID);
    }
    public static void postComment(
            Long psId, 
            @Required(message="Author is required") String name, 
            @Required(message="A message is required") String address, 
            @Required(message="Please type the code") String code, 
            String randomID) 
    {
    	 Person ps = null;
    	if(null != psId){
    		ps = Person.findById(psId);
    	}else{
    		ps = new Person();
    	}
        validation.equals(code, Cache.get(randomID)).message("Invalid code. Please type it again");
        if(validation.hasErrors()) {
            render("Application/show.html", ps, randomID);
        }
        ps.setName(name);
        ps.setAddress(address);
        ps.save();
        flash.success("Thanks for posting %s", name);
        Cache.delete(randomID);
        show(psId);
    }
    public static class MyThread implements Runnable{
		@Override
		public void run() {
			try{
				Connection conn = MyDsUtils.getThreadConn();
		    	System.out.println("-------curr thread--------"+Thread.currentThread().getName());
		    	Statement stmt = conn.createStatement();
		    	ResultSet rs = stmt.executeQuery("select * from t_persion");
		    	while(rs.next()){
		    		System.out.println("id:"+rs.getLong("id")+",name:"+rs.getString("name")+",email:"+rs.getString("email"));
		    		break;
		    	}
			}catch(SQLException e){
				e.printStackTrace();
			}
			System.out.println("hello world");
		}
    }
}