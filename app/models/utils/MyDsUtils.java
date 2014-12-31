package models.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyDsUtils {
	private static DataSource dataSource;
	//线程本地变量
    private static ThreadLocal<Connection> thread = new ThreadLocal<Connection>();
    static{
       dataSource =
              new StdDataSource("com.mysql.jdbc.Driver",
                     "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8",
                     "root","root",3);
    }
    /**
     * 直接获取一个Connection
     */
    public static Connection getConn(){
       Connection con = null;
       try {
           con= dataSource.getConnection();
       } catch (SQLException e) {
           throw new RuntimeException(e.getMessage(),e);
       }
       return con;
    }
    /**
     * 获取线程局部的Connection
     */
    public static Connection getThreadConn(){
       Connection con = thread.get();//先从线程局部中取数据
       if(con==null){
           con = getConn();
           thread.set(con);
       }
       return con;
    }
    /**
     * 可选的调用删除局部线程中的对象
     */
    public static void remove(){
       thread.remove();
    }
    /**
     * 获取一个DataSource
     */
    public static DataSource getDataSource(){
       return dataSource;
    }

}
