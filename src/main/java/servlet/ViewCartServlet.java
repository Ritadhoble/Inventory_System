package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import bean.CustomerBean;
import dao.ViewCarttoDAO;

@SuppressWarnings("serial")
@WebServlet("/cart")
public class ViewCartServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);
    	
    	if(hs==null) 
    	{
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);
    	}
    	else {
    		CustomerBean cb=(CustomerBean)hs.getAttribute("cbean");
    		ArrayList<CartBean>al=new ViewCarttoDAO().retrive(cb.getCid());
    		hs.setAttribute("list", al);
    		req.getRequestDispatcher("ViewCartProduct.jsp").forward(req, res);
    	}
    }
}
