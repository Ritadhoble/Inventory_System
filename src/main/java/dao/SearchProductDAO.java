package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.ProductBean;
import dp.DBConnection;

public class SearchProductDAO 
{
   public ProductBean pb=null;
   public ProductBean search(String pcode)
   {
	   try
	   {
		   Connection con=DBConnection.getCon();
		   PreparedStatement ps=con.prepareStatement("select * from Product where pcode=?");
		   ps.setString(1, pcode);
		   ResultSet rs=ps.executeQuery();
		   if(rs.next())
		   {
			   pb=new ProductBean();
			   pb.setPcode(rs.getString(1));
			   pb.setPname(rs.getString(2));
			   pb.setBrand(rs.getString(3));
			   pb.setQty(rs.getInt(4));
			   pb.setCprice(rs.getFloat(5));
			   pb.setSprice(rs.getFloat(6)); 
		   }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	return pb;
	   
   }
}
