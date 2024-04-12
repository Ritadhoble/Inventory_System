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
import dao.AddProductDAO;
import dao.ViewProductDAO;

@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);  
    	if(hs==null)
    	{
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);;
    	}
    	else
    	{
    		ProductBean pb=new ProductBean();
    		pb.setPcode(req.getParameter("pcode"));
    		pb.setPname(req.getParameter("pname"));
    		pb.setBrand(req.getParameter("brand"));
    		pb.setQty(Integer.parseInt(req.getParameter("qty")));
    		pb.setCprice(Integer.parseInt(req.getParameter("cprice")));
    		pb.setSprice(Integer.parseInt(req.getParameter("sprice")));
    		
    		int k=new AddProductDAO().insert(pb);
    		if(k>0) {
    			ArrayList<ProductBean>al=new ViewProductDAO().retrive();
        		hs.setAttribute("alist", al);
    			req.setAttribute("msg","Product added successfully....<br>");
    		}
    		req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
    	}
    }
}
