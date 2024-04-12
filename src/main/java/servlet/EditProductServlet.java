package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;

@SuppressWarnings("serial")
@WebServlet("/edit1")
public class EditProductServlet extends HttpServlet
{
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);
    	if(hs==null){
    		req.setAttribute("msg", "Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);
    	}
    	else{
    		String pCode=req.getParameter("pcode");
    		ArrayList<ProductBean>al=(ArrayList<ProductBean>)hs.getAttribute("alist");
    		ProductBean pb=null;
    		Iterator<ProductBean>it=al.iterator();
    		while(it.hasNext())
    		{
    			pb=it.next();
    			if(pCode.equals(pb.getPcode()))
    			{
    				break;
    			}
    		}
    		req.setAttribute("pbean", pb);
    		req.getRequestDispatcher("EditProduct.jsp").forward(req, res);;
    	}
    }
}
