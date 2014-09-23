package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Persion;
import models.utils.MyDsUtils;
import play.mvc.Controller;

public class Application extends Controller {

    public static void index() throws Exception{
    	render();
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
			
		}
    	
    }
}