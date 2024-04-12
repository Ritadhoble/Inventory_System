package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.ProductBean;
import dao.ViewProductDAO;
@SuppressWarnings("serial")
@WebServlet("/currstock")
public class AdminCurrentStock extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);  
    	if(hs==null)
    	{
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);;
    	}
    	else {
            ArrayList<ProductBean> al = new ViewProductDAO().retrive();
            ArrayList<ProductBean> currStock = new ArrayList<>();
            for (ProductBean product : al) {
                if (product.getQty() > 0) {
                    currStock.add(product);
                }
            }
            hs.setAttribute("alist", currStock);
            req.getRequestDispatcher("AdminCurrentStock.jsp").forward(req, res);
        }
    }
}
