package com.iotek.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iotek.entity.Product;

/**
 * Servlet implementation class ShowProductDetail
 */
@WebServlet("/show_product_detail.do")
public class ShowProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String productIdString= request.getParameter("productid");
		int productId = Integer.parseInt(productIdString);
		HttpSession session = request.getSession();
		List<Product> listProuct =(List)session.getAttribute("listProduct");
		for (Product product : listProuct) {
			if (product.getId()==productId) {
				session.setAttribute("productitem", product);
			}
		}
		/*如果将数据放在requst里传值 只能被取出来一次
		 *如果将数据放在session里生命周期更长，只要浏览器不关闭
		 *都可以将该对象取出来使用
		 * 
		 * 
		 * 
		 * */
		request.getRequestDispatcher("pages/show_product_item.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		
		
	}

}
