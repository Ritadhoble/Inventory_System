package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.ProductBean;
import dp.DBConnection;

public class UpdateProductDAO 
{
    public int k=0;
    public int update(ProductBean pb)
    {
    	try
    	{
    		Connection con=DBConnection.getCon();
    		PreparedStatement ps = con.prepareStatement("UPDATE Product SET cprice=?, sprice=?, qty=? WHERE pcode=?");
            ps.setFloat(1,pb.getCprice());
    		ps.setFloat(2,pb.getSprice());
    		ps.setInt(3,pb.getQty());
    		ps.setString(4, pb.getPcode());
    		k=ps.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return k;
    }
}
