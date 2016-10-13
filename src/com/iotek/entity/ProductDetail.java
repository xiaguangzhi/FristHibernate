/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午9:52:44
*
*
*/
package com.iotek.entity;

import java.io.Serializable;

public class ProductDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String image1;
	private String image2;
	private String image3;
	private String caption;
	public ProductDetail() {
		// TODO Auto-generated constructor stub
	}
	public ProductDetail( String image1, String image2, String image3,
			String caption) {
		super();
		
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.caption = caption;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", image1=" + image1 + ", image2="
				+ image2 + ", image3=" + image3 + ", caption=" + caption + "]";
	}
	
	
	
	
}
