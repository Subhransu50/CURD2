package com.tcs.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Raj");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Product p){  
	        int status=0;  
	        try{  
	            Connection con=ProductDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into user900(Pname,Pcolor,Pquantity,Ptotalprice) values (?,?,?,?)");  
	            ps.setString(1,p.getPname());  
	            ps.setString(2,p.getPcolor());  
	            ps.setInt(3,p.getPquantity());  
	            ps.setInt(4,p.getPtotalprice());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    
	    
	    public static List<Product> getAllProducts()
	    {
	    	List<Product> list=new ArrayList<Product>();
	    	try{
	    		Connection con=ProductDao.getConnection();
	    		PreparedStatement ps=con.prepareStatement("select * from user900");
	    		ResultSet rs=ps.executeQuery();
	    		while(rs.next())
	    		{
	    			Product p=new Product();
	    			
	    			p.setPname(rs.getString(1));
	    			p.setPcolor(rs.getString(2));
	    			p.setPquantity(rs.getInt(3));
	    			p.setPtotalprice(rs.getInt(4));
	    			list.add(p);
	    		}
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			return list;
	    	
	    }
	    
	    public static List<Product> searchProducts(String pname)
	    {
	    	List<Product> list=new ArrayList<Product>();
	    	try{
	    		Connection con=ProductDao.getConnection();
	    		//PreparedStatement ps=con.prepareStatement("select * from user900 where pname=?");
	    		
	    		PreparedStatement ps=con.prepareStatement("select * from user900 where pname like '"+pname+"%'");
	    		//ps.setString(1, pname);
	    		ResultSet rs=ps.executeQuery();
	    		while(rs.next())
	    		{
	    			Product p=new Product();
	    			
	    			p.setPname(rs.getString(1));
	    			p.setPcolor(rs.getString(2));
	    			p.setPquantity(rs.getInt(3));
	    			p.setPtotalprice(rs.getInt(4));
	    			list.add(p);
	    		}
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			return list;
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
