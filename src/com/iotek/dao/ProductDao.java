/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月12日 下午8:17:44
*
*
*/
package com.iotek.dao;

import java.util.List;

import com.iotek.entity.Product;
import com.iotek.entity.ProductDetail;


public interface ProductDao {
	public boolean saveProduct(Product product);
	public boolean updateProduct(Product product);
	public  Product getProduct(int productId);
	public boolean updateProductDeatil(ProductDetail  productDetail) ;
	public List<Product> listProduct();

}
