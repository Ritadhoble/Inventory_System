package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CustomerBean;
import dp.DBConnection;

public class ViewCustomerDAO 
{
	 public ArrayList<CustomerBean>al=new ArrayList<CustomerBean>();
	    public ArrayList<CustomerBean>retrive()
	    {
	    	try {
	    		Connection con=DBConnection.getCon();
	    		PreparedStatement ps=con.prepareStatement("select * from Customer ORDER BY TO_NUMBER(REGEXP_REPLACE(CID, '[^0-9]', '')) ASC");
	    		ResultSet rs=ps.executeQuery();
	    		while(rs.next())
	    		{
	    			CustomerBean cb=new CustomerBean();
	    			cb.setCid(rs.getString(1));
	    			cb.setpWord(rs.getString(2));
	    			cb.setfName(rs.getString(3));
	    			cb.setlName(rs.getString(4));
	    			cb.setPhNo(rs.getLong(5));
	    			cb.setAddr(rs.getString(6));
	    			al.add(cb);
	    		}
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
			return al;
	    	
	    }

}
