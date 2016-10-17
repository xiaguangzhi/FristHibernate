/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月12日 下午8:20:18
*
*
*/
package com.iotek.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iotek.dao.ProductDao;
import com.iotek.entity.Product;
import com.iotek.entity.ProductDetail;
import com.iotek.util.HibernateSessionfacory;

public class ProductDaoImpl implements ProductDao{

	@Override
	public boolean saveProduct(Product product) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		
		return false;
	}

	@Override
	public Product getProduct(int productId) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		Product product = null;
		 try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eqOrIsNull("id", productId));
			product = (Product) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		return product;
	}

	@Override
	public boolean updateProductDeatil(ProductDetail productDetail) {
		
		return false;
	}

	@Override
	public List<Product> listProduct() {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		List list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(10);
//			select *from product limit 0, 20;
			list = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		return list;
	}

}
