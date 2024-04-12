package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.ProductBean;
import dp.DBConnection;

public class DeleteProductDAO 
{
    public int k=0;
    public int delete(ProductBean pb)
    {
    	try
    	{
    		Connection con=DBConnection.getCon();
        	PreparedStatement ps=con.prepareStatement("Delete from Product where pcode=?");
        	ps.setString(1,pb.getPcode());
        	k=ps.executeUpdate();
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return k;
    	
    }
}
