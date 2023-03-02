package Controller;

import java.io.IOException;
import java.util.List;

import DataBase.MainHandle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MainHandleDAO;
import POJO.Account;
import POJO.Manufacture;
import POJO.Phone;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();  
		MainHandleDAO MAIN = new MainHandleDAO();
		
		Account acc =null;
		
		if(null == session.getAttribute("acc")) {
			String name = request.getParameter("user");
			String pass = request.getParameter("pass");
			acc = MAIN.getAcc(name, pass);
		}else {
			acc = (Account) session.getAttribute("acc");
		}
		
		

		if(acc == null) {
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
		}else {
			
	        session.setAttribute("acc",acc); 
	        
			String chucvu = acc.getChucVu();
			List<Phone> listPhone = MAIN.getListPhoneAll();
			List<Manufacture> listManu = MAIN.getListManufactureAll();
			
			 if(chucvu.equalsIgnoreCase("1")) {
				
		        
				request.setAttribute("listphone", listPhone);
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
				rd.forward(request, response);
				
				
			}else if(chucvu.equalsIgnoreCase("0")) {
				
		        
		        request.setAttribute("listmanu", listManu);
		        request.setAttribute("listphone", listPhone);
		        
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/views/login.jsp");
			}
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
