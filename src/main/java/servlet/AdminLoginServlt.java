package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminBean;
import dao.AdminLoginDAO;

@SuppressWarnings("serial")
@WebServlet("/adminLog")
public class AdminLoginServlt extends HttpServlet
{
	 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	    {
	    	AdminBean ab=new AdminLoginDAO().login(req.getParameter("uname"),req.getParameter("pword"));
	    	if(ab==null)
	    	{
	    		req.setAttribute("msg", "Invalid Login process...<br>");
	    		req.getRequestDispatcher("Home.jsp").forward(req, res);
	    	}
	    	else
	    	{
	    		HttpSession hs=req.getSession();
	    		hs.setAttribute("abean", ab);
	    		req.getRequestDispatcher("AdminLogin.jsp").forward(req, res);
	    	}
	    }
}
