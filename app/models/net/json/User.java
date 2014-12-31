package models.net.json;

import java.util.Date;
import java.util.List;

public class User {
  public String uname;
  public String pwd;
  public int age;
  public String addr;
  public User user;
  public String phone;
  public Date time;
  public String card;
  
  
public String getCard() {
	return card;
}
public void setCard(String card) {
	this.card = card;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public static void main(String[] args) {
	User user = new User();
	user.addr = "北京海淀";
	user.age = 26;
	user.phone = "18612700346";
	user.uname = "lenzhao";
	System.out.println(user.card);
}
}
