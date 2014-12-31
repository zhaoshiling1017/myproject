package models.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Person;

public class TestSeril {
	/**
	 * *将对象序列化到磁盘文件中
	 * @param o
	 * @throws Exception
	 */
	public static void writeObject(Object o) throws Exception{
		File f=new File("d:/dev/file.txt");
	       if(f.exists()){
	           f.delete();
	       }
	       FileOutputStream os=new FileOutputStream(f);
	       //ObjectOutputStream 核心类
	       ObjectOutputStream oos=new ObjectOutputStream(os);
	       oos.writeObject(o);
	       oos.close();
	       os.close();
	}
	/**
	 * 反序列化,将磁盘文件转化为对象
	 * @param f
	 * @return
	 * @throws Exception
	 */
	 public static Person readObject(File f) throws Exception{
	       InputStream is=new FileInputStream(f);
	       //ObjectOutputStream 核心类
	       ObjectInputStream ois=new ObjectInputStream(is);
	       return (Person)ois.readObject();

	 }
	 public static void main(String[] args) {
		/*Persion p = new Persion();
		p.setAddress("北京海淀中关村");
		p.setAge(26);
		p.setEmail("zhaosl1017@gmail.com");
		p.setName("lenzhao");
		try {
			writeObject(p);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		 try {
			 Person p = readObject(new File("d:/dev/file.txt"));
			System.out.println(p.getAddress()+"-----"+p.getAge()+"------"+p.getEmail()+"-------"+p.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
