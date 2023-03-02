package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AccountDAO;
import DAO.MainHandleDAO;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String pass_ = request.getParameter("pass_");
		AccountDAO acc = new AccountDAO();
		if(name != null && user != null && pass != null) {
			if(pass.equalsIgnoreCase(pass_)) {
				MainHandleDAO dao = new MainHandleDAO();
				if(dao.getAcc(user, "") != null) {
					acc.AddAcc(name, user, pass);
				}else {
					request.setAttribute("message", "Error! exist username");
					RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
					rd.forward(request, response);
				}
			}else {
				request.setAttribute("message", "Error! password check");
				RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
				rd.forward(request, response);
			}
		}else {
			request.setAttribute("message", "Error! fill all");
			RequestDispatcher rd = request.getRequestDispatcher("/views/register.jsp");
			rd.forward(request, response);
		}
	}

}
