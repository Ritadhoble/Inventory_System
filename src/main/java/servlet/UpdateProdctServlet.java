
package servlet;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import bean.ProductBean;
import dao.UpdateProductDAO;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProdctServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession();
    	if(hs==null)
    	{
    		req.setAttribute("msg", "Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);
    	}
    	else
    	{
    		String pCode=req.getParameter("pcode");
    		ArrayList<ProductBean>al=(ArrayList<ProductBean>)hs.getAttribute("alist");
    		ProductBean pb=null;
    		Iterator<ProductBean> it=al.iterator();
    		while(it.hasNext())
    		{
    			pb=it.next();
    			if(pCode.equals(pb.getPcode()))
    			{
    				break;
    			}
    		}
    		pb.setCprice(Float.parseFloat(req.getParameter("cprice")));
    		pb.setSprice(Float.parseFloat(req.getParameter("sprice")));
    		pb.setQty(pb.getQty()+(Integer.parseInt(req.getParameter("qty"))));
    		int k=new UpdateProductDAO().update(pb);
    		if(k>0)
    		{
    			req.setAttribute("msg", "Product detail Updated Successfully...<br>");
    			req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
    		}
    	}
    }
}

