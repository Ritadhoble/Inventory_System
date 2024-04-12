package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.CartBean;
import dp.DBConnection;

public class CartDAO 
{
   public int k=0;
   public int insert(CartBean cb)
   {
	   try {
		   Connection con=DBConnection.getCon();
		   PreparedStatement ps=con.prepareStatement("insert into addtocart Values(?,?,?,?,?,?)");
		   ps.setString(1, cb.getCid());
		   ps.setString(2,cb.getPcode());
		   ps.setString(3,cb.getPname());
		   ps.setString(4,cb.getBrand());
		   ps.setInt(5,cb.getQty());
		   ps.setDouble(6,cb.getSprice());
		   k=ps.executeUpdate();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	return k;
	   
   }
}
