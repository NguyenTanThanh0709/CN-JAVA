package Controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PhoneDAO;
import POJO.Phone;

/**
 * Servlet implementation class showDetail
 */
@WebServlet("/showDetail")
public class showDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idPhone = request.getParameter("idphone");
		if(idPhone == null) {
			response.sendRedirect(request.getContextPath() + "/loginController");
		}else {
			PhoneDAO dao = new PhoneDAO();
			Phone phone = dao.get(idPhone);
			request.setAttribute("phone", phone);
	        
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/detailProduct.jsp");
			rd.forward(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
