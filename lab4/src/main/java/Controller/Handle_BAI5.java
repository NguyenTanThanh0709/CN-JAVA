package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Handle_BAI5
 */
@WebServlet("/Handle_BAI5")
public class Handle_BAI5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Handle_BAI5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("action");
		if(type != null) {
			if(type.equalsIgnoreCase("contact")) {
				response.sendRedirect(request.getContextPath() + "/views/contact_BAI5.jsp");
			}else if(type.equalsIgnoreCase("help")) {
				response.sendRedirect(request.getContextPath() + "/views/help_BAI5.jsp");
			}else if(type.equalsIgnoreCase("about")) {
				response.sendRedirect(request.getContextPath() + "/views/about_BAI5.jsp");
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
