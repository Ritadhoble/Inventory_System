package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.ViewProductDAO;

@SuppressWarnings("serial")
@WebServlet("/stock1")
public class ViewProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);  
    	if(hs==null)
    	{
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);
    	}
    	else
    	{
    		ArrayList<ProductBean>al=new ViewProductDAO().retrive();
    		hs.setAttribute("alist", al);
    		req.getRequestDispatcher("ViewProduct.jsp").forward(req, res);
    	}
    }  
}
