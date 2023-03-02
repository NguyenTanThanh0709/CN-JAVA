package Controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MainHandleDAO;
import POJO.Manufacture;
import POJO.Phone;

/**
 * Servlet implementation class handleLoadManu
 */
@WebServlet("/handleLoadManu")
public class handleLoadManu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public handleLoadManu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idManu = request.getParameter("idmanu");
		if(idManu == null) {
			response.sendRedirect(request.getContextPath() + "/views/web/home.jsp");
		}else {
			
			request.setAttribute("idmanu", idManu);
			MainHandleDAO MAIN = new MainHandleDAO();
			List<Manufacture> listManu = MAIN.getListManufactureAll();
	        List<Phone> listPhone = MAIN.getListPhoneAll();
	        
	        request.setAttribute("listmanu", listManu);
	        request.setAttribute("listphone", listPhone);
	        
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
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
