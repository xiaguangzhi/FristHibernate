/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月12日 下午7:13:01
*
*
*/
package com.iotek.dao;

import java.util.List;

import com.iotek.entity.OrderItem;
import com.iotek.entity.Orders;
import com.iotek.entity.User;

public interface OrdersDao {
	public boolean saveOrders(Orders orders);
	public boolean deleteOrders(Orders orders);
	public boolean updateOrders(Orders orders);
	public List<Orders> listOrders(User user);
	public List<OrderItem> listOrdersItem(int orderId);
	

}
