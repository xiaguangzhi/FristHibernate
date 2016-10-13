/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午9:17:20
*
*
*/
package com.iotek.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private ProductDetail productDetail;
	private String productName;
	private BigDecimal productPrice;
	private String productType;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductType() {
		return productType;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productDetail=" + productDetail
				+ ", productName=" + productName + ", productPrice="
				+ productPrice + ", productType=" + productType + "]";
	}
	
	

}
