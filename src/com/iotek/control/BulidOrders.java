package com.iotek.control;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iotek.biz.OrdersBiz;
import com.iotek.biz.UserBiz;
import com.iotek.biz.impl.OrdersBizImpl;
import com.iotek.biz.impl.UserBizImpl;
import com.iotek.dao.OrdersDao;
import com.iotek.entity.OrderItem;
import com.iotek.entity.Orders;
import com.iotek.entity.Product;
import com.iotek.entity.User;
import com.iotek.entity.UserDetail;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * Servlet implementation class BulidOrders
 */
@WebServlet("/bulid_orders.do")
public class BulidOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String User = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BulidOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String provPassword = request.getParameter("provPassword");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Product product = (Product) session.getAttribute("productitem");
		// 取得验证密码 如果验证成功
		if (user.getPassword().equals(provPassword)) {

			// 创建订单
			Orders orders = new Orders();
			orders.setUser(user);
			orders.setOrdersDate(new Timestamp(new Date().getTime()));
			orders.setOrdersState(0);// 订单状态为0为未支付 1：支付 2：已发货 3：已收货
			orders.setTotalMoney(new BigDecimal(product.getProductPrice()
					.doubleValue() * 1));
				
			Set<OrderItem> items=new HashSet<OrderItem>();
			OrderItem oi=new OrderItem();
			oi.setItemState(0);
			oi.setProduct(product);
			oi.setProductCount(1);
			items.add(oi);
			orders.setItems(items);
			
			//生成订单
			OrdersBiz ordersBiz=new OrdersBizImpl();
			boolean ordersFlag = ordersBiz.saveOrders(orders);
			if (ordersFlag) {
				//保存订单成功了
				// 判断用户的金额是否能够支付该订单
				
				
				if (Double.parseDouble(user.getUserDetail().getMoney())>=orders.getTotalMoney().doubleValue()) {
					// 如果能够支付订单 更新用户金额 支付成功 状态为支付
					UserBiz userBiz=new UserBizImpl();
					UserDetail userDetail = user.getUserDetail();
					userDetail.setMoney(String.valueOf(Double.parseDouble(userDetail.getMoney())-orders.getTotalMoney().doubleValue()));
					
					boolean updateUserDetail = userBiz.UpdateUserDetail(userDetail);
					if (updateUserDetail) {
						orders.setOrdersState(1);
					//更新订单子项
						orders.getItems().iterator().next().setItemState(1);
						ordersBiz.updateOrders(orders);
						response.getWriter()
						.print("<script language='javascript'>alert('购买成功');window.location.href='pages/success.jsp';</script>");
					}else {
						response.getWriter()
						.print("<script language='javascript'>alert('支付失败，请重新支付');window.location.href='pages/order_detail.jsp';</script>");
					}
					
				}else {
					// 如果不能够支付订单 状态为未支付
					response.getWriter()
					.print("<script language='javascript'>alert('余额不足，请先充钱');window.location.href='pages/order_detail.jsp';</script>");
				}
				
				
			}else {
				//保存订单不成功
				response.getWriter()
				.print("<script language='javascript'>alert('订单生成失败，请重新下单');window.location.href='pages/order_detail.jsp';</script>");
			}
			
			
		} else {
			// 如果验证密码不成功 刷新页面
			response.getWriter()
					.print("<script language='javascript'>alert('密码验证失败');window.location.href='pages/order_detail.jsp';</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
