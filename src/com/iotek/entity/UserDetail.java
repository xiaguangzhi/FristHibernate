/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午2:34:26
*
*
*/
package com.iotek.entity;

import java.io.Serializable;
import java.util.Arrays;

public class UserDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String money;
	private String phone;
	private String email;
	private byte[] image;
	public UserDetail() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", money=" + money + ", phone=" + phone
				+ ", email=" + email + ", image=" + Arrays.toString(image)
				+ "]";
	}

	

}
