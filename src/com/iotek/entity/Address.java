/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午2:00:19
*
*
*/
package com.iotek.entity;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String  province;
	private String city;
	private String contry;
	private String road;
	private User user;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", province=" + province + ", city="
				+ city + ", contry=" + contry + ", road=" + road + ", user="
				+ user + "]";
	}
	
	
	

}
