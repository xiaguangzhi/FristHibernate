/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月14日 下午4:35:19
*
*
*/
package com.iotek.biz.impl;

import java.util.List;

import com.iotek.biz.ProductBiz;
import com.iotek.dao.ProductDao;
import com.iotek.dao.impl.ProductDaoImpl;
import com.iotek.entity.Product;

public class ProductBizImpl implements ProductBiz{
	private ProductDao productDao;
	public ProductBizImpl() {
		productDao=new ProductDaoImpl();
	}

	@Override
	public boolean saveProduct(Product product) {
		
		return productDao.saveProduct(product);
	}

	@Override
	public List<Product> listProduct() {
	
		return productDao.listProduct();
	}

}
