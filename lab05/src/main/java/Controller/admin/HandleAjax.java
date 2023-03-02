package Controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PhoneDAO;
import POJO.Phone;

/**
 * Servlet implementation class HandleAjax
 */
@WebServlet("/HandleAjax")
public class HandleAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String txtSearch = request.getParameter("txt");
		String type = request.getParameter("type");
		PhoneDAO  dao =new PhoneDAO();
		if(type.equalsIgnoreCase("delete")) {
			dao.remove(txtSearch);
		}else if(type.equalsIgnoreCase("update")) {
//			Phone phone = new Phone();
//			
			String multi = request.getParameter("multi");
//			String name = request.getParameter("name");
//			String price = request.getParameter("price");
//			String country = request.getParameter("country");
			System.out.println(multi);
			String[] arr = multi.split(",");
			
			dao.update(arr[0], arr[1],arr[2], arr[3]);
			
			
			
//			phone.setColor("red");
//			phone.setCountry(country);
//			phone.setPrice(0);
//			dao.add(phone);
		}
		//response.sendRedirect(request.getContextPath() + )
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
