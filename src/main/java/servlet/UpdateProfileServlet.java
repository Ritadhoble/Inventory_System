package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;
import dao.UpdateProfileDAO;

@SuppressWarnings("serial")
@WebServlet("/updateProf")
public class UpdateProfileServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		 HttpSession session = req.getSession();
	     CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	     Cookie c[]=req.getCookies();
		 if(c==null) {
			req.setAttribute("msg","Session Expired...<br>");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else{
			cb.setpWord(req.getParameter("pwd"));
			cb.setfName(req.getParameter("fName"));
			cb.setlName(req.getParameter("lName"));
			cb.setPhNo(Long.parseLong(req.getParameter("phno")));
			cb.setAddr(req.getParameter("address"));
			
			int k=new UpdateProfileDAO().update(cb);
			String fName=c[0].getValue();
			req.setAttribute("fname", fName);
			if(k>0)
			{
				req.setAttribute("msg","Your profile updated successfully...<br>");
			}
			req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
		}
	}
}

