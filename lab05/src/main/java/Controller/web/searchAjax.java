package Controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PhoneDAO;
import POJO.Phone;

/**
 * Servlet implementation class searchAjax
 */
@WebServlet("/searchAjax")
public class searchAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");
        PhoneDAO dao = new PhoneDAO();
        List<Phone> list = dao.getSearchName(txtSearch);
        
        PrintWriter out = response.getWriter();
        for (Phone c : list) {
        	out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\r\n"
        			+ "								<div class=\"card\">\r\n"
        			+ "									<img class=\"card-img-top\" src=\""
        			+ c.getImage()
        			+ " alt=\"Card image cap\">\r\n"
        			+ "									<div class=\"card-body\">\r\n"
        			+ "										<h4 class=\"card-title\">\r\n"
        			+ "											<a href=\"product.html\" title=\"View Product\">"
        			+ c.getName()
        			+ "</a>\r\n"
        			+ "										</h4>\r\n"
        			+ "										<p class=\"card-text\">${c.country}</p>\r\n"
        			+ "										<div class=\"row\">\r\n"
        			+ "											<div class=\"col\">\r\n"
        			+ "												<p class=\"btn btn-danger btn-block\">"
        			+ c.getPrice()
        			+ "$</p>\r\n"
        			+ "											</div>\r\n"
        			+ "											<div class=\"col\">\r\n"
        			+ "												<a href=\"/lab06/showDetail?idphone="
        			+ c.getId()
        			+ "\"\r\n"
        			+ "													class=\"btn btn-success btn-block\">show details</a>\r\n"
        			+ "											</div>\r\n"
        			+ "										</div>\r\n"
        			+ "									</div>\r\n"
        			+ "								</div>\r\n"
        			+ "							</div>");
        	
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
