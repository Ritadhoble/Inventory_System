package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.CustomerBean;
import dao.ViewCustomerDAO;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewCustomerServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);  
    	if(hs==null)
    	{
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);;
    	}
    	else
    	{
    		ArrayList<CustomerBean>al=new ViewCustomerDAO().retrive();
    		hs.setAttribute("alist", al);
    		req.getRequestDispatcher("ViewCustomer.jsp").forward(req, res);
    	}
    }
}
