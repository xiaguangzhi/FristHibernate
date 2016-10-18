package com.iotek.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iotek.entity.User;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/buy_product.do")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyProduct() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String buyPorductIdString = request.getParameter("productId");
		session.setAttribute("buyproductSate",buyPorductIdString );
		if (user!=null) {
			//跳转到生成订单的界面
			request.getRequestDispatcher("pages/order_detail.jsp").forward(request, response);
			
			
			
		}else {
			//跳转到  注册登录的界面
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
