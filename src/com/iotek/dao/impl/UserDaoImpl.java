/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午2:45:35
*
*
*/
package com.iotek.dao.impl;

import java.io.Serializable;

import org.hibernate.BasicQueryContract;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iotek.dao.UserDao;
import com.iotek.entity.User;
import com.iotek.entity.UserDetail;
import com.iotek.util.HibernateSessionfacory;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean saveUser(User user) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction=null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}finally{
			HibernateSessionfacory.closeSession();
		}
		
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		}finally{
			HibernateSessionfacory.closeSession();
		}
	
		return false;
	}

	
		

	@Override
	public User getUser(String name, String password) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		User user=null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where name=:name and password=:password");
			query.setString("name", name);
			query.setParameter("password", password);
			 user = (User) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}finally{
			HibernateSessionfacory.closeSession();
		}
	
		
		return user;
	}
	@Override
	public boolean updateUserDeatil(UserDetail userDetail) {
		Session session = HibernateSessionfacory.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(userDetail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			HibernateSessionfacory.closeSession();
		}
		
		return false;
	}

	

}
