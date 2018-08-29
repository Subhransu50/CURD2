package com.tcs.product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class Download
 */
@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

    static XSSFWorkbook book;
	static XSSFSheet sheet;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

    	

    	WritableWorkbook wworkbook;
        try {
       	wworkbook = Workbook.createWorkbook(new File("h:/new/absent_details_JAN.xls"));
      			
			
       	
       	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		List<Product> list=ProductDao.getAllProducts();
		
		 WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
		 Label label = new Label(0, 2, "A label record");
		 
		  wsheet.addCell(label);
		  int i=0;
		  int j=1;
		  
		  
         for(Product p:list){  
            
          i=0;
          label = new Label(0, 0, "Si.No");
		  wsheet.addCell(label);
          label = new Label(1, 0, "PNAME");
		  wsheet.addCell(label);
		  label = new Label(2, 0, "PCOLOR");
		  wsheet.addCell(label);
		  label = new Label(3, 0, "PQUANTITY");
		  wsheet.addCell(label);
		  label = new Label(4, 0, "PTOTALPRICE");
		  wsheet.addCell(label);
         
			 label = new Label(i++, j, j+"");
			  wsheet.addCell(label);
			 label = new Label(i++, j, p.getPname());
			  wsheet.addCell(label);
			  label = new Label(i++, j, p.getPcolor());
			  wsheet.addCell(label);
			  label = new Label(i++, j,String.valueOf(p.getPquantity()));
			  wsheet.addCell(label);
			  
			  label = new Label(i++, j,String.valueOf(p.getPtotalprice()));
			  wsheet.addCell(label);
			  
			  
			 
			j++;
         
         }  
         out.print("<html><body><center>");
         out.print("Download successfully");
         out.print("</center></body></html>");
         request.getRequestDispatcher("index.html").include(request, response);
     
         //out.print("<html><body><center><b><a href='index.html'><font color='black'>Back To Homepage</font></a></b></center></body></html>");
         out.close();  
       	
       	
       	
       	
       	
       	
       	
       	
       	
      
        
        wworkbook.write();
        wworkbook.close();
        System.out.println("fineshed");
        
        
        
        
        
        } catch (Exception e) {
        System.out.println(e);
		}
    }

  
    

  
    
	}




