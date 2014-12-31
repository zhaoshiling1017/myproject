package models.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;

public class ConnProxy implements InvocationHandler {
	private Object o;
    private LinkedList<Connection> pool;
    private ConnProxy(Object o,LinkedList<Connection> pool){
        this.o=o;
        this.pool=pool;
    }
    public static Connection getProxyedConnection(Object o,LinkedList<Connection> pool){
        Object proxed = Proxy.newProxyInstance(o.getClass().getClassLoader(),
               new Class[]{Connection.class},new ConnProxy(o,pool));
        return (Connection) proxed;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		 if(method.getName().equals("close")){
             synchronized (pool) {
                 pool.add((Connection) proxy);//将被代理的对象放回池中
                 pool.notify();//通知等待线程去获取一个连接吧
             }
             return null;
          }else{
             return method.invoke(o, args);
          }

	}

}
