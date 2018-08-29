package com.tcs.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
         
		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();  */

		HttpSession session=request.getSession();


		//session.removeAttribute("userId");
		
		//session.invalidate();
		//out.print("You are successfully logged out!!!");
		
		
		/*response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
				response.setDateHeader("Expires", -1);
		//response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		//session.invalidate();
		String userName = (String) session.getAttribute(null);
		session.invalidate();
		System.out.println(userName);
		if (null == userName) {
		   request.setAttribute("Error", "Session has ended.  Please login.");
		   RequestDispatcher rd = request.getRequestDispatcher("login.html");
		   rd.forward(request, response);
		}
	*/	
		

        request.getSession(false);
        session.invalidate();
        response.sendRedirect("newlogin.jsp");
	}

	
}
