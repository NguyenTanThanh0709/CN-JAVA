package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController2
 */
@WebServlet("/loginController2")
public class loginController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(121);
		String name = request.getParameter("user");
		String pass = request.getParameter("pass");
		System.out.println(name + " " + pass);
		if(name.equals("tdtu") && pass.equals("1234")) {
			request.setAttribute("name", name);
			request.setAttribute("pass", pass);
			RequestDispatcher rd = request.getRequestDispatcher("/views/PrintLogin.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
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
