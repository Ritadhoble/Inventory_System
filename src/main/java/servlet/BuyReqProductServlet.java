package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.BuyReqProductDAO;
import java.util.Date;
@SuppressWarnings("serial")
@WebServlet("/updateqty")
public class BuyReqProductServlet extends HttpServlet 
{
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);
    	if(hs==null) {
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);
    	}
    	else {
    		String pCode=req.getParameter("pCode");
    		ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
    		ProductBean pb=null;
    		Iterator<ProductBean>it=al.iterator();
    		while(it.hasNext())
    		{
    			pb=it.next();
    			if(pCode.equals(pb.getPcode())) {
    				break;
    			}
    		}
    		pb.setQty((Integer.parseInt(req.getParameter("pQty")))-(Integer.parseInt(req.getParameter("preg"))));
    		int regProduct=Integer.parseInt(req.getParameter("preg"));
    		float totprice=Float.parseFloat(req.getParameter("sPrice"));
    		float totAmt=regProduct*totprice;
    		int k=new BuyReqProductDAO().updateqty(pb);
    		 Date currentDate = new Date();
    		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	     String formattedDate = dateFormat.format(currentDate);
    		if(k>0)
    		{
    			req.setAttribute("pReg", req.getParameter("preg"));
    			req.setAttribute("pbean", pb);
    			req.setAttribute("ans",totAmt+"<br>");
    			req.setAttribute("date",formattedDate+"<br>");
    			req.setAttribute("msg","Payment successfully...<br>");
    			req.getRequestDispatcher("BuyReqProduct.jsp").forward(req, res);;
    		}
    	}
    }
}
