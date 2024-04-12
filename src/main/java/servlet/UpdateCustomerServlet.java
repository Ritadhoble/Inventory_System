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
import dao.UpdateCustomerDAO;
@SuppressWarnings("serial")
@WebServlet("/updateCust")
public class UpdateCustomerServlet extends HttpServlet
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			String cId=req.getParameter("cid");
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
			cb.setpWord(req.getParameter("pwd"));
			cb.setfName(req.getParameter("fName"));
			cb.setlName(req.getParameter("lName"));
			cb.setPhNo(Long.parseLong(req.getParameter("phn")));
			
			int k=new UpdateCustomerDAO().update(cb);
			if(k>0){
				req.setAttribute("msg","Customer detail updated successfully...<br>");
				req.getRequestDispatcher("UpdateCustProf.jsp").forward(req, res);
			}
		}
	}

}
