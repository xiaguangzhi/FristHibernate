/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月14日 下午3:26:06
*
*
*/
package com.iotek.biz.impl;

import com.iotek.biz.UserBiz;
import com.iotek.dao.UserDao;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.User;
import com.iotek.entity.UserDetail;

public class UserBizImpl implements UserBiz{
	private UserDao userDao;
	public UserBizImpl() {
		userDao=new UserDaoImpl();
	}

	@Override
	public boolean LoginUser(User user) {
		User user2 = userDao.getUser(user.getName(), user.getPassword());
		if (user2!=null) {
			return true;
		}
		return false;
	}

	@Override
	public User getUser(User user) {
		
		return userDao.getUser(user.getName(),user.getPassword());
	}

	@Override
	public boolean UpdateUserDetail(UserDetail  userDetail) {
		
		return userDao.updateUserDeatil(userDetail);
	}

}
