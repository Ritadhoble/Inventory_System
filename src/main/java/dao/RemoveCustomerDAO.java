package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.CustomerBean;
import dp.DBConnection;

public class RemoveCustomerDAO 
{
    public int k=0;
    public int delete(CustomerBean cb)
    {
    	try
    	{
    		Connection con=DBConnection.getCon();
    		PreparedStatement ps=con.prepareStatement("Delete from Customer where cid=?");
    		ps.setString(1,cb.getCid());
    		k=ps.executeUpdate();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return k;
    }
}
