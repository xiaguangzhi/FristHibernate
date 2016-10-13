/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午10:16:38
*
*
*/
package com.iotek.entity;

import java.io.Serializable;
import java.util.Set;

public class BuyCar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private User  user;
	private Set<Product> products;
	private int productCount;
	public BuyCar() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@Override
	public String toString() {
		return "BuyCar [id=" + id + ", user=" + user + ", products=" + products
				+ ", productCount=" + productCount + "]";
	}
	
	

}
