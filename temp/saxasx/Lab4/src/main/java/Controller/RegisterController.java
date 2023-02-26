package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
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
		String user = request.getParameter("name");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String birthtime = request.getParameter("birthtime");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String[] f_ide = request.getParameterValues("favorite_ide");
		String toeic = request.getParameter("toeic");
		String message = request.getParameter("message");
		
		
		for (String string : f_ide) {
			System.out.print(string + " --- ");
		}

		
		request.setAttribute("f_ide", f_ide);
			RequestDispatcher rd = request.getRequestDispatcher("/views/PrintRegister.jsp");
			rd.forward(request, response);
	}

}
