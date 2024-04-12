package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import bean.ProductBean;
import dp.DBConnection;
public class AddProductDAO
{
    public int k=0;
    public int insert(ProductBean pb)
    {
    	try {
    		Connection con=DBConnection.getCon();
    		PreparedStatement ps=con.prepareStatement("insert into Product Values(?,?,?,?,?,?)");
    		ps.setString(1, pb.getPcode());
    		ps.setString(2, pb.getPname());
    		ps.setString(3, pb.getBrand());
    		ps.setInt(4,pb.getQty());
    		ps.setFloat(5,pb.getCprice());
    		ps.setFloat(6,pb.getSprice());
    		k=ps.executeUpdate();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
		return k;
    }
}
