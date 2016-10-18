/**
 * @author 小黄----小人藏其余生，一动不动
 * @version 创建时间：2016年10月11日 下午3:07:43
 *
 *
 */
package com.iotek.test;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.iotek.dao.AddressDao;
import com.iotek.dao.OrdersDao;
import com.iotek.dao.ProductDao;
import com.iotek.dao.UserDao;
import com.iotek.dao.impl.AddressDaoImpl;
import com.iotek.dao.impl.OrdersDaoImpl;
import com.iotek.dao.impl.ProductDaoImpl;
import com.iotek.dao.impl.UserDaoImpl;
import com.iotek.entity.Orders;
import com.iotek.entity.Product;
import com.iotek.entity.User;
public class Test {
	public static void main(String[] args) {
		/*ProductDao productDao = new ProductDaoImpl();
		OrdersDao ordersDao = new OrdersDaoImpl();
		UserDao userDao=new UserDaoImpl();
		AddressDao addressDao=new AddressDaoImpl();
		//注册用户
		
		 //当用户信息发送到服务器，创建用户对象
		User user=new User();
		user.setAge("23");
		user.setName("xiao huang");
		user.setPassword("123456");
		//创建用户详情对象
		UserDetail userDetail=new UserDetail();
		userDetail.setPhone("13167253358");
		userDetail.setEmail("1484073720@qq.com");
		user.setUserDetail(userDetail);
		userDao.saveUser(user);
		
		
		
		
		//用户登录
		User user = userDao.getUser("xiao huang", "123456");
		System.out.println(user);
		
		//用户修改密码
		user.setPassword("1234567");
		userDao.updateUser(user);
		
		//用户增加余额
		UserDetail userDetail = user.getUserDetail();
		userDetail.setMoney(String.valueOf(Double.parseDouble(userDetail.getMoney())+1000));
		userDao.updateUserDeatil(userDetail);
		
		//管理员增加商品
		//提交后在服务端创建product对象
		Product product=new Product();
		product.setProductName("矿泉水");
		product.setProductPrice(new BigDecimal(12345));
		product.setProductType("饮用水");
		//创建商品细节对象
		ProductDetail productDetail=new ProductDetail();
		productDetail.setImage1("假装有照片1");
		productDetail.setImage2("假装有照片2");
		productDetail.setImage3("假装有照片3");
		productDetail.setCaption("这个商品好水啊");
		product.setProductDetail(productDetail);
		productDao.saveProduct(product);
		
		
		//用户查看商品
		 List<Product> listProduct = productDao.listProduct();
		System.out.println(listProduct.size());
		for (Product product : listProduct) {
			System.out.println(product);
		}
		
		//用户购买商品
		Product product = productDao.getProduct(1);
		OrderItem item=new OrderItem();
		item.setProduct(product);
		item.setProductCount(12);
		item.setItemState(0);
		Orders orders=new Orders();
		HashSet<OrderItem> items= new HashSet<OrderItem>();
		items.add(item);
		orders.setItems(items);
		orders.setOrdersDate(new Timestamp(new Date().getTime()));
		orders.setOrdersState(0);
		orders.setTotalMoney(new BigDecimal(12345));
		orders.setUser(user);
		ordersDao.saveOrders(orders);
		
		//用户查询订单
		List<Orders> listOrders = ordersDao.listOrders(user);
		
		for (Orders orders : listOrders) {
			System.out.println(orders.getItems());
			
		}
		
		//用户取消订单
		Orders orders=listOrders.get(0);
		ordersDao.deleteOrders(orders);
		*/
		Timestamp timestamp=new Timestamp(new Date().getTime());
		System.out.println(timestamp.toString());
	

	}

}
