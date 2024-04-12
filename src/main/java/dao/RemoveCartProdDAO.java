package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.CartBean;
import dp.DBConnection;

public class RemoveCartProdDAO {
	 public int k=0;
	    public int delete(CartBean cb1)
	    {
	    	try
	    	{
	    		Connection con=DBConnection.getCon();
	    		PreparedStatement ps=con.prepareStatement("Delete from addtocart where TRIM(CID)=? and TRIM(PCODE)=?");
	    		ps.setString(1, cb1.getCid().trim().toUpperCase());
	    		ps.setString(2,cb1.getPcode());
	    		k=ps.executeUpdate();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
			return k;
	    }
}
