package com.iotek.control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.iotek.biz.ProductBiz;
import com.iotek.biz.impl.ProductBizImpl;
import com.iotek.entity.Product;
import com.iotek.entity.ProductDetail;

/**
 * Servlet implementation class AddProductServlet
 */
@MultipartConfig
@WebServlet("/add_product.do")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();

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
		/*String productName = request.getParameter("name");
		String productType = request.getParameter("type");
		System.out.println(productType);
		String productPrice= request.getParameter("price");
		String caption = request.getParameter("caption");
		Collection<Part> parts = request.getParts();
		Map<String, String> imageNames=new HashMap<String, String>();
		
		if (parts != null) {
			String realPath = request.getServletContext().getRealPath("/");
			for (Part part : parts) {
				if (part != null) {
					String name = part.getName();
					System.out.println("name:"+name);
					if (name.startsWith("image")) {
						String fileName = getFileName(part);
						System.out.println("fileName:"+fileName);
						saveFile(part, fileName, realPath);
						imageNames.put(name, "images/"+fileName);
					}else {
						System.out.println(part+"1kong");
					}
				}else {
					System.out.println(parts+"2kong");
				}

			}

		}
		String  image1=imageNames.get("image1");
		String  image2=imageNames.get("image2");
		String  image3=imageNames.get("image3");
		Product product=new Product();
		product.setProductName(productName);
		product.setProductType(productType);
		product.setProductPrice(new BigDecimal(productPrice));
		ProductDetail productDetail=new ProductDetail();
		productDetail.setCaption(caption);
		productDetail.setImage1(image1);
		productDetail.setImage2(image2);
		productDetail.setImage3(image3);
		product.setProductDetail(productDetail);
		
		
		
		boolean saveProduct = productBiz.saveProduct(product);
		*/
		ProductBiz productBiz=new ProductBizImpl();
		List<Product> listProduct = productBiz.listProduct();
		for (Product product : listProduct) {
			System.out.println(product);
		}
		HttpSession session = request.getSession();
		session.setAttribute("listProduct", listProduct);
		request.getRequestDispatcher("pages/show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void saveFile(Part part, String fileName, String realPath)
			throws IOException {
		InputStream is = null;
		OutputStream os = new FileOutputStream(realPath +"images/"+ fileName);
		;
		try {
			is = part.getInputStream();
			byte[] car = new byte[1024];
			int len = -1;
			while (-1 != (len = is.read(car))) {
				os.write(car, 0, len);
			}
			os.flush();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			is.close();
			os.close();
		}

	}

	private String getFileName(Part part) {
		String header = part.getHeader("Content-Disposition");
		System.out.println(header);
		// 火狐浏览器
		String filename = header.substring(header.indexOf("filename=\"") + 10,
				header.lastIndexOf("\""));
		return filename;
	}

}
