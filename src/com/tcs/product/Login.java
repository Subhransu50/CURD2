package com.tcs.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userId=request.getParameter("uid");
		String password=request.getParameter("pwd");
		/*HttpSession session=request.getSession();
		session.setAttribute("userId", userId);*/
		if(password.equals("Raj"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("userId", userId);
			out.print("Login is success");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			out.print("Login failure!!!");
		}
	}

	

}
