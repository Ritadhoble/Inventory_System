package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.CustomerBean;
import dp.DBConnection;

public class CustomerLoginDAO 
{
	public CustomerBean cb=null;
	public CustomerBean login(String cid,String pWord)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from Customer where cid=? and pword=?");
			ps.setString(1, cid);
			ps.setString(2, pWord);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				cb=new CustomerBean();
				cb.setCid(rs.getString(1));
				cb.setpWord(rs.getString(2));
				cb.setfName(rs.getString(3));
				cb.setlName(rs.getString(4));
				cb.setPhNo(rs.getLong(5));
				cb.setAddr(rs.getString(6));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return cb;
		
	}

}
