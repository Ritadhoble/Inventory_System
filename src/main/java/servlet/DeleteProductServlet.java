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
import dao.DeleteProductDAO;
import dao.ViewProductDAO;

@SuppressWarnings("serial")
@WebServlet("/delete1")
public class DeleteProductServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);
    	if(hs==null)
    	{
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req,res);
    	}
    	else
    	{
    		String pCode=req.getParameter("pcode");
    		ArrayList<ProductBean> al=(ArrayList<ProductBean>)hs.getAttribute("alist");
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
    		int k=new DeleteProductDAO().delete(pb);
    		if(k>0)
    		{
    			al=new ViewProductDAO().retrive();
        		hs.setAttribute("alist", al);
    			req.setAttribute("msg","Product deleted successfully...<br>");
    			req.getRequestDispatcher("AddProduct.jsp").forward(req,res);
    		}
    		
    	}
    }
}
