/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午9:57:42
*
*
*/
package com.iotek.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;



public class Orders implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private Set<OrderItem> items;
	private Timestamp ordersDate;
	private BigDecimal totalMoney;
	private int ordersState;
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<OrderItem> getItems() {
		return items;
	}
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	public Timestamp getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(Timestamp ordersDate) {
		this.ordersDate = ordersDate;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getOrdersState() {
		return ordersState;
	}
	public void setOrdersState(int ordersState) {
		this.ordersState = ordersState;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", user=" + user + ", ordersDate="
				+ ordersDate + ", totalMoney=" + totalMoney + ", ordersState="
				+ ordersState + "]";
	}
	
	
	
	

}
