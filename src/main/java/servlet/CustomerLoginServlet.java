package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.CustomerBean;
import dao.CustomerLoginDAO;
@SuppressWarnings("serial")
@WebServlet("/customerLog")
public class CustomerLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		   CustomerBean cb=new CustomerLoginDAO().login(req.getParameter("cid"), req.getParameter("pword"));
		   if(cb==null){
			   req.setAttribute("msg", "Invalid Login process...<br>");
			   req.getRequestDispatcher("customerLogin.html").forward(req,res);
		   }
		   else {
			   HttpSession hs=req.getSession();
			   hs.setAttribute("cbean", cb);
			   req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		   }
	}
}
