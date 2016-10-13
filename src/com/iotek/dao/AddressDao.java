/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月11日 下午2:41:49
*
*
*/
package com.iotek.dao;


import java.util.List;

import com.iotek.entity.Address;
import com.iotek.entity.User;

public interface AddressDao {
	public boolean saveAddress(Address address);
	public boolean updateAddress(Address address);
	public boolean deleteAdress(Address address);
	public List<Address> listUserAddress(User user);
	
}
