/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月14日 下午3:25:14
*
*
*/
package com.iotek.biz;

import com.iotek.entity.User;
import com.iotek.entity.UserDetail;

public  interface UserBiz {
	public boolean LoginUser(User user);
	public User getUser(User user);
	public boolean UpdateUserDetail(UserDetail  userDetail);
	

}
