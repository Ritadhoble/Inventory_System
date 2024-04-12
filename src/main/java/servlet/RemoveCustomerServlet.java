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
import dao.RemoveCustomerDAO;
import dao.ViewCustomerDAO;

@SuppressWarnings("serial")
@WebServlet("/delete2")
public class RemoveCustomerServlet extends HttpServlet
{
     @SuppressWarnings("unchecked")
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
    		 String cId=req.getParameter("Cid");
    		 ArrayList<CustomerBean> al=(ArrayList<CustomerBean>)hs.getAttribute("alist");
    		 CustomerBean cb=null;
    		 Iterator<CustomerBean>it=al.iterator();
    		 while(it.hasNext())
    		 {
    			 cb=it.next();
    			 if(cId.equals(cb.getCid())){
    				 break;
    			 }
    		 }
    		 int k=new RemoveCustomerDAO().delete(cb);
    		 if(k>0)
    		 {
    			 al=new ViewCustomerDAO().retrive();
         		 hs.setAttribute("alist", al);
    			 req.setAttribute("msg","Customer detail deleted successfully...<br>");
    		 }
    		 req.getRequestDispatcher("UpdateCustProf.jsp").forward(req, res);
    	 }
     }
}
