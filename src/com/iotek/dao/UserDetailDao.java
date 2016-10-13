/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午2:41:23
*
*
*/
package com.iotek.dao;

import com.iotek.entity.UserDetail;

public interface UserDetailDao {
	
	public boolean updateUserDeatil(UserDetail userDetail);
	public UserDetail getUserDetail(int user_id);

}
