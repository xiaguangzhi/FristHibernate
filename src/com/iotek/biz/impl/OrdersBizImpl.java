/**
* @author 小黄----小人藏其余生，一动不动
* @version 创建时间：2016年10月18日 下午3:38:04
*
*
*/
package com.iotek.biz.impl;

import java.util.List;

import com.iotek.biz.OrdersBiz;
import com.iotek.dao.OrdersDao;
import com.iotek.dao.impl.OrdersDaoImpl;
import com.iotek.entity.OrderItem;
import com.iotek.entity.Orders;
import com.iotek.entity.User;


public class OrdersBizImpl implements OrdersBiz {
	private OrdersDao ordersDao;
	public OrdersBizImpl() {
		ordersDao=new OrdersDaoImpl();
	}
	@Override
	public boolean saveOrders(Orders orders) {
	
		return ordersDao.saveOrders(orders);
	}
	@Override
	public boolean deleteOrders(Orders orders) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateOrders(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.updateOrders(orders);
	}
	@Override
	public List<Orders> listOrders(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderItem> listOrdersItem(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
