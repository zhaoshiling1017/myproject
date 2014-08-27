package models.utils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

public class StdDataSource implements DataSource {
	private int poolSize=3;//默认为3个
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	public StdDataSource(String driver,String url,String name,String pwd){
	       this(driver,url,name,pwd,3);
	}
	public StdDataSource(String driver,String url,String name,String pwd,int poolSize){
	       try{
	           Class.forName(driver);
	           this.poolSize=poolSize;
	           if(poolSize<=0){
	              throw new RuntimeException("不支持的池大小"+poolSize);
	           }
	           for(int i=0;i<poolSize;i++){
	               Connection con = DriverManager.getConnection(url,name,pwd);
	              con = ConnProxy.getProxyedConnection(con,pool);//获取被代理的对象,equals,hashCode,toString
	              pool.add(con);//添加被代理的对象
	           }
	       }catch(Exception e){
	           throw new RuntimeException(e.getMessage(),e);
	       }
	   }
	/**
     * 获取池大小
     */
    public int getPoolSize() {
       return poolSize;
    }

	@Override
	public Connection getConnection() throws SQLException {
		synchronized (pool) {
	           if(pool.size()==0){
	              try {
	                  pool.wait();
	              } catch (InterruptedException e) {
	                  throw new RuntimeException(e.getMessage(),e);
	              }
	              return getConnection();
	           }else{
	              Connection con = pool.removeFirst();
	              return con;
	           }
	       }
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		return null;
	}

	@Override
	public Connection getConnection(String arg0, String arg1)
			throws SQLException {
		return null;
	}
	
}
