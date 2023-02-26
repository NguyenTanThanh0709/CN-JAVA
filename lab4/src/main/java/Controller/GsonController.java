package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.product;
import utils.utilsSession;

/**
 * Servlet implementation class GsonController
 */
@WebServlet("/GsonController")
public class GsonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<product> productList;
	private Gson _gson = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GsonController() {
		super();
		productList = new ArrayList<product>();
		_gson = new Gson();
		// TODO Auto-generated constructor stub
	}

	private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {

		response.setContentType("application/json");

		String res = _gson.toJson(obj);

		PrintWriter out = response.getWriter();

		out.print(res);
		out.flush();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String type = request.getParameter("type");
		System.out.println(type);
		if (type.equals("add")) {
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String price = request.getParameter("price");
			product pro = new product(id, name, price);
			productList.add(pro);
			response.sendRedirect(request.getContextPath() + "/views/GSON_BAI3.jsp");

		} else if (type.equals("update")) {
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String price = request.getParameter("price");
			update(id, name, price);

		} else if (type.equals("delete")) {
			String id = request.getParameter("id");
			if (id != null) {
				find(id);
			}

		} else {

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			Gson gson = new Gson();
			String employeeJsonString = gson.toJson(productList);
			out.print(employeeJsonString);

		}
	}

	private void find(String id) {
		product pr = null;
		for (product product : productList) {
			if (product.getId().equals(id)) {
				productList.remove(product);
			}
		}
	}

	private void update(String id, String name, String price) {
		product pr = null;
		for (product product : productList) {
			if (product.getId().equals(id)) {
				product.setName(name);
				product.setPrice(price);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
