package com.tcs.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
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
	String searchpname=	request.getParameter("searchname");
	
	if(searchpname==null||searchpname.trim().equals("")){  
		out.print("<p>Please enter name!</p>");  
		}else{  
	
	
	List<Product> list=ProductDao.searchProducts(searchpname);	
	
	 out.print("<html><body bgcolor='green'><table border='1' width='100%' bgcolor='pink' background='black'");  
     out.print("<tr><th>ProductName</th><th>Product Color</th><th>Product Quantity</th><th>Total Price</th>  <th>Edit</th><th>Delete</th></tr>");  
     for(Product p:list){  
      out.print("<tr><td>"+p.getPname()+"</td><td>"+p.getPcolor()+"</td><td>"+p.getPquantity()+"</td>  <td>"+p.getPtotalprice()+"</td><td><a href='EditServlet?id="+p.getPname()+"'>edit</a></td>   <td><a href='DeleteServlet?id="+p.getPname()+"'>delete</a></td></tr>");  
     }  
     
    // request.getRequestDispatcher("index.html").include(request, response);
     out.print("<center><b><font color='black'>Product Details</font></b></center>");
     out.print("</table></body></html>");  
     out.print("<html><body><center><b><a href='index.html'><font color='black'>Back To Homepage</font></a></b></center></body></html>");
     
     out.print("<html><body><center><b><a href='SearchThenDownload?searchpname="+searchpname+"'><font color='black'>Download Excel</font></a></b></center></body></html>");
     out.close();  
		
		}
		
		
		
	}

	

}
