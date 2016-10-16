/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月14日 下午4:34:01
*
*
*/
package com.iotek.biz;

import java.util.List;

import com.iotek.entity.Product;

public interface ProductBiz {
	public boolean saveProduct(Product product);
	public List<Product> listProduct();

}
