package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CustomerBean;
import dao.CustomerRegisterDAO;

@SuppressWarnings("serial")
@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	CustomerBean cb=new CustomerBean();
    	cb.setCid(req.getParameter("cid"));
    	cb.setpWord(req.getParameter("pword"));
    	cb.setfName(req.getParameter("fname"));
    	cb.setlName(req.getParameter("lname"));
    	cb.setPhNo(Long.parseLong(req.getParameter("phno")));
    	cb.setAddr(req.getParameter("addr"));
      	    	
    	int k=new CustomerRegisterDAO().register(cb);
    	if(k>0)
    	{
    		req.setAttribute("msg", "Customer registred Successfully...<br>");
    		RequestDispatcher rd=req.getRequestDispatcher("DeleteProfile.jsp");
    		rd.forward(req, res);
    	}
    }
}
