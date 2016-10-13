/**
 * @author 小黄----小人藏其余生，一动不动
 * @version 创建时间：2016年10月11日 下午3:38:58
 *
 *
 */
package com.iotek.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.iotek.dao.AddressDao;
import com.iotek.entity.Address;
import com.iotek.entity.User;
import com.iotek.util.HibernateSessionfacory;

public class AddressDaoImpl implements AddressDao {

	@Override
	public boolean saveAddress(Address address) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(address);
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
	public boolean updateAddress(Address address) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(address);
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
	public boolean deleteAdress(Address address) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(address);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			HibernateSessionfacory.closeSession();

		}
		transaction.rollback();
		return false;
	}

	@Override
	public List<Address> listUserAddress(User  user) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		List list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Address.class);
			criteria.add(Restrictions.eq("user", user));
			list = criteria.list();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		return list;
	}

}
