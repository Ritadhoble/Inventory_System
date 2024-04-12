package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.CartBean;
import dp.DBConnection;

public class ViewCartDAO {
    public ArrayList<CartBean>al=new ArrayList<CartBean>();
	public ArrayList<CartBean> retrive(String cid,String pcode) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from addtocart where cid=? and pcode=?");
			ps.setString(1,cid);
			ps.setString(2,pcode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CartBean cb=new CartBean();
				cb.setCid(rs.getString(1));
				cb.setPcode(rs.getString(2));
				cb.setPname(rs.getString(3));
				cb.setBrand(rs.getString(4));
				cb.setQty(rs.getInt(5));
				cb.setSprice(rs.getDouble(6));
				al.add(cb);
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return al;
	}

}
