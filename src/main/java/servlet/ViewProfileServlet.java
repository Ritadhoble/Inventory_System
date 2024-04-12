package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;

@SuppressWarnings("serial")
@WebServlet("/profile")
public class ViewProfileServlet extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
        Cookie c[]=req.getCookies();
    	if(c==null)
    	{
    		req.setAttribute("msg", "Session Expired...");
    		RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
            rd.forward(req, res);
    		
    	} else 
    	{
    		String fName=c[0].getValue();
    		req.setAttribute("fname",fName);
            req.setAttribute("cbean", cb);
            req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);

        }
    }

}
