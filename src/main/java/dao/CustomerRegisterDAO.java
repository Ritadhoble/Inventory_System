package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.CustomerBean;
import dp.DBConnection;


public class CustomerRegisterDAO 
{
	 public int k=0;
	    public int register(CustomerBean cb)
	    {
	    	try
	    	{
	    		Connection con=DBConnection.getCon();
	    		PreparedStatement ps=con.prepareStatement("insert into Customer values(?,?,?,?,?,?)");
	    		ps.setString(1, cb.getCid());
	  		    ps.setString(2, cb.getpWord());
	  		    ps.setString(3, cb.getfName());
	  		    ps.setString(4, cb.getlName());
	  		    ps.setLong(5, cb.getPhNo());
	  		    ps.setString(6, cb.getAddr());
	  		    k=ps.executeUpdate();
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			return k;
	    }
}
