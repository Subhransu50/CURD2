package com.tcs.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	static XSSFWorkbook book;
	static XSSFSheet sheet;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		  /*MultipartRequest m=new MultipartRequest(request,"h:/new");
		 out.print("successfully uploaded");*/
		 
		UploadBean upb=new UploadBean();
		try {
			upb.setFolderstore("h:/new");
		
		upb.setOverwrite(false);
		MultipartFormDataRequest req;
	
			req = new MultipartFormDataRequest(request);
		
		
			upb.store(req);
		
		Hashtable ht=req.getFiles();
		Enumeration e1=ht.elements();
		while(e1.hasMoreElements())
		{
			UploadFile file5=(UploadFile) e1.nextElement();
			
		
String filename=file5.getFileName();
			/*String excelFilePath = "H:/Automation"
					+ "/CRUD2/src/com/tcs/product/ok.xlsx";*/
String excelFilePath = "H:/new/"+filename;
			//FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			//String a = null;
			//Workbook workbook = new XSSFWorkbook(inputStream);
			//Sheet firstSheet = workbook.getSheetAt(0);
			//Iterator<Row> iterator = firstSheet.iterator();
		
			FileInputStream file = null;
			
				file = new FileInputStream(excelFilePath);
			
				book = (XSSFWorkbook) WorkbookFactory.create(file);
			
			sheet = book.getSheetAt(0);
			//Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			//DataFormatter formatter = new DataFormatter();

			int rowcount = sheet.getLastRowNum();

			
			//String l = sheet.getRow(1).getCell(1).getStringCellValue();
			int status=0;
			for(int i=1;i<=rowcount;i++)
			{
				
			System.out.println("===================");
				XSSFCell cell6 = sheet.getRow(i).getCell(0);
				String cellText = cell6.getStringCellValue();
				System.out.println(cellText);

				XSSFCell cell7 = sheet.getRow(i).getCell(1);
				String cellText1 = cell7.getStringCellValue();
				System.out.println(cellText1);
				
				XSSFCell cell8 = sheet.getRow(i).getCell(2);
				double ui=cell8.getNumericCellValue();
				int yo=(int)ui;
				System.out.println(yo);
				
				XSSFCell cell9 = sheet.getRow(i).getCell(3);
				double uii=cell9.getNumericCellValue();
				int vo=(int)uii;
				System.out.println(vo);
				
				Product p = new Product();
				p.setPname(cellText);
				p.setPcolor(cellText1);
				p.setPquantity(yo);
				p.setPtotalprice(vo);
				 status = ProductDao.save(p);
				

				
			
			}
			
			if (status > 0) {
				out.print("<html><head><style>blink, .blink {animation: blinker 1s linear infinite;}@keyframes blinker {  50% { opacity: 0; }}</style><body bgcolor='pink' background='black'><center><p><blink>File "+filename+" Uploaded Successfully and Record saved in DB successfully!</blink></p>");
				out.print("<a href='index.html'><b>Back To HomePage</b>");
				out.print("</center></body></html");
				
			} else {
				out.print("Error occurred during saving");
			}
			
			/*
			 * int a= ProductDao.Products(); if(a==1) {
			 * out.print("Successfully uploaded"); } else {
			 * out.print("Error in uploading"); }
			 */
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
