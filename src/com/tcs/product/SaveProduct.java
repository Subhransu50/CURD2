package com.tcs.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/SaveProduct")
public class SaveProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Pname=request.getParameter("name");
		String Pcolor=request.getParameter("color");
		String PQuantity=request.getParameter("quantity");
		String Pprice=request.getParameter("price");
		int q=Integer.parseInt(PQuantity);
		int p1=Integer.parseInt(Pprice);
		int r=q*p1;
		Product p=new Product();
		p.setPname(Pname);
		p.setPcolor(Pcolor);
		p.setPquantity(q);
		p.setPtotalprice(r);
		int status=ProductDao.save(p);
		
		if(status>0)
		{
			out.print("<html><head><style>blink, .blink {animation: blinker 1s linear infinite;}@keyframes blinker {  50% { opacity: 0; }}</style><body><center><p><blink>Record saved successfully!Your Total Bill is Rs.</blink>"+r+"</p></center></body></html>");  
            request.getRequestDispatcher("index.html").include(request, response);  
		}
		else
		{
			out.print("Error occurred during saving");
		}
		
	}
	
}
