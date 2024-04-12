package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.ProductBean;
import dp.DBConnection;
public class ViewProductDAO 
{
    public ArrayList<ProductBean>al=new ArrayList<ProductBean>();
    public ArrayList<ProductBean>retrive()
    {
    	try {
    		Connection con=DBConnection.getCon();
    		PreparedStatement ps=con.prepareStatement("select * from product ORDER BY TO_NUMBER(REGEXP_REPLACE(PCODE, '[^0-9]', '')) ASC");
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			ProductBean pb=new ProductBean();
    			pb.setPcode(rs.getString(1));
    			pb.setPname(rs.getString(2));
    			pb.setBrand(rs.getString(3));
    			pb.setQty(rs.getInt(4));
    			pb.setCprice(rs.getInt(5));
    			pb.setSprice(rs.getInt(6));
    			al.add(pb);
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return al;
    	
    }
    
}
