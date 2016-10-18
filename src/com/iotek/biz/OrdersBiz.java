/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月18日 下午3:37:35
*
*
*/
package com.iotek.biz;

import java.util.List;

import com.iotek.entity.OrderItem;
import com.iotek.entity.Orders;
import com.iotek.entity.User;

public interface OrdersBiz {
	public boolean saveOrders(Orders orders);
	public boolean deleteOrders(Orders orders);
	public boolean updateOrders(Orders orders);
	public List<Orders> listOrders(User user);
	public List<OrderItem> listOrdersItem(int orderId);

}
