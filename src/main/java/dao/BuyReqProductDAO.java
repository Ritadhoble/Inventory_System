package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.ProductBean;
import dp.DBConnection;

public class BuyReqProductDAO 
{
   public int k=0;
   public int updateqty(ProductBean pb)
   {
	   try
	   {
		   Connection con=DBConnection.getCon();
		   PreparedStatement ps=con.prepareStatement("Update Product set qty=? where pcode=?");
		   ps.setInt(1, pb.getQty());
		   ps.setString(2,pb.getPcode());
		   k=ps.executeUpdate();
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	return k;
	   
   }
}
