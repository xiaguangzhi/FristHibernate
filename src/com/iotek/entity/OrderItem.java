/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午9:58:48
*
*
*/
package com.iotek.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Product product;
	private int  productCount;
	private int  itemState;
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderItem(Product product, int productCount, int itemState) {
		super();
		this.product = product;
		this.productCount = productCount;
		this.itemState = itemState;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public int getItemState() {
		return itemState;
	}
	public void setItemState(int itemState) {
		this.itemState = itemState;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", product=" + product
				+ ", productCount=" + productCount + ", itemState=" + itemState
				+ "]";
	}
	
	

}
