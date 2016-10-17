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
		String productName = request.getParameter("name");
		String productType = request.getParameter("type");
		String productPrice= request.getParameter("price");
		String caption = request.getParameter("caption");
		
		//每一个文件对应都会生成一个part   如果多个文件通过request.getParts()返回出来一个part容器
		Collection<Part> parts = request.getParts();
		//保存图片路径
		Map<String, String> imageNames=new HashMap<String, String>();
		
		if (parts != null) {
			String realPath = request.getServletContext().getRealPath("/");
			System.out.println("程序应用实例的根目录："+realPath);
			
			for (Part part : parts) {
				if (part != null) {
					//part对应的名字是表单元素的名字
					String name = part.getName();
					//过滤出通过名字以image的开头的part
					if (name.startsWith("image")) {
						//得到文件名
						String fileName = getFileName(part);
						System.out.println("fileName:"+fileName);
						//保存文件
						saveFile(part, fileName, realPath);
						imageNames.put(name, "/images/"+fileName);
					}
				}else {
					System.out.println("part为空");
				}

			}

		}
		//从map里取出名字对应的图片保存相对位置
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
		
		
		ProductBiz productBiz=new ProductBizImpl();
		boolean saveProduct = productBiz.saveProduct(product);
		
	
		List<Product> listProduct = productBiz.listProduct();
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
		OutputStream os = new FileOutputStream(realPath +"/images/"+ fileName);
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
			
		} finally {
			is.close();
			os.close();
		}

	}

	private String getFileName(Part part) {
		//通过part的头文件取出来header  header的信息里包含了上传文件的信息
		String header = part.getHeader("Content-Disposition");
		System.out.println("header:"+header);
		// 火狐浏览器
		String filename = header.substring(header.indexOf("filename=\"") + 10,
				header.lastIndexOf("\""));
		return filename;
	}

}
