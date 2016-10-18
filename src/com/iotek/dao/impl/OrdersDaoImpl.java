/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月12日 下午7:12:43
*
*
*/
package com.iotek.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.iotek.dao.OrdersDao;
import com.iotek.entity.OrderItem;
import com.iotek.entity.Orders;
import com.iotek.entity.User;
import com.iotek.util.HibernateSessionfacory;

public class OrdersDaoImpl implements OrdersDao{

	@Override
	public boolean saveOrders(Orders orders) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(orders);
			transaction.commit();
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		return false;
	}

	@Override
	public boolean deleteOrders(Orders orders) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(orders);
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
	public boolean updateOrders(Orders orders) {
		
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(orders);
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
	public List<Orders> listOrders(User user) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		List list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Orders.class);
			criteria.add(Restrictions.eq("user", user));
			list = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
			
		}
	
		
		return list;
	}

	@Override
	public List<OrderItem> listOrdersItem(int orderId) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = session.beginTransaction();
//		session.createQuery("from Order ")
		transaction.commit();
		transaction.rollback();
		return null;
	}

}
