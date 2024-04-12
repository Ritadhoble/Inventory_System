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

import bean.CustomerBean;

@SuppressWarnings("serial")
@WebServlet("/edit2")
public class EditCustomerServlet extends HttpServlet
{
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);
    	if(hs==null){
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req,res);
    	}
    	else{
    		String cId=req.getParameter("Cid");
    		ArrayList<CustomerBean>al=(ArrayList<CustomerBean>)hs.getAttribute("alist");
    		CustomerBean cb=null;
    		Iterator<CustomerBean>it=al.iterator();
    		while(it.hasNext())
    		{
    			cb=it.next();
    			if(cId.equals(cb.getCid())){
    				break;
    			}
    		}
    		req.setAttribute("cbean",cb);
    		req.getRequestDispatcher("EditCustomer.jsp").forward(req, res);
    	}
    }
}
