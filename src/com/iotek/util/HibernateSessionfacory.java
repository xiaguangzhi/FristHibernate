/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午1:33:38
*
*
*/
package com.iotek.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionfacory {
	public static final String  FILE="hibernate.cfg.xml";
	public static final Configuration CONFIGURATION=new Configuration();
	public static  SessionFactory factory;
	public static final ThreadLocal<Session> THREAD_LOCAL=new ThreadLocal();
	public static Session getSession(){
		Session session = THREAD_LOCAL.get();
		if (session==null) {
			if (factory==null) {
				CONFIGURATION.configure(FILE);
				factory= CONFIGURATION.buildSessionFactory();
				
				
			}
			 session = factory.openSession();
			THREAD_LOCAL.set(session);
		}
		return session;
		
	} 
	public static void closeSession(){
		Session session = THREAD_LOCAL.get();
		THREAD_LOCAL.set(null);
		if (session!=null) {
			session.close();
			
		}
	}

}
