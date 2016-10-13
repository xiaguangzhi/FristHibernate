/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午2:40:31
*
*
*/
package com.iotek.dao;

import com.iotek.entity.User;
import com.iotek.entity.UserDetail;

public interface UserDao {
	public boolean saveUser(User user);
	public boolean updateUser(User user);
	public User getUser(String name,String password);
	public boolean updateUserDeatil(UserDetail userDetail) ;
}
