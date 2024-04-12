package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductBean;
import dao.SearchProductDAO;

@SuppressWarnings("serial")
@WebServlet("/searchCust")
public class SearchProdCustServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	ProductBean pb=new SearchProductDAO().search(req.getParameter("pcode"));
    	if(pb==null)
    	{
    		req.setAttribute("msg","Invalid Product Code...<br>");
    		req.getRequestDispatcher("DeleteProfile.jsp").forward(req,res);
        }
    	else {
    		HttpSession hs=req.getSession();
    		hs.setAttribute("pbean",pb);
    		req.getRequestDispatcher("SearchProdCust.jsp").forward(req, res);
    	}
    }
}

