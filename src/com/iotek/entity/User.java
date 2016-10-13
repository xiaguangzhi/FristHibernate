/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午1:51:37
*
*
*/
package com.iotek.entity;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String fristName;
	private String lastName ;
	private String password;
	private String age;
	private UserDetail userDetail;
	
	public User() {
		
	}
	public User(int id, String fristName, String lastName, String password,
			String age) {
		super();
		this.id = id;
		this.fristName = fristName;
		this.lastName = lastName;
		this.password = password;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setName(String name){
		StringTokenizer st=new StringTokenizer(name);
		this.fristName=st.nextToken();
		this.lastName=st.nextToken();
	}
	
	public String getName(){
		return fristName+" "+lastName;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fristName=" + fristName + ", lastName="
				+ lastName + ", password=" + password + ", age=" + age
				+ ", userDetail=" + userDetail + "]";
	}
	
	
	

}
