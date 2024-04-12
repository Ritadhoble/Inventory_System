package servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;

import dao.CartDAO;
import dao.ViewCartDAO;

@SuppressWarnings("serial")
@WebServlet("/addtocart")
public class AddtoCartServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	HttpSession hs=req.getSession(false);
    	if(hs==null) {
    		req.setAttribute("msg","Session Expired...<br>");
    		req.getRequestDispatcher("Home.jsp").forward(req, res);;

    	}
    	else {
    		CartBean cb=new CartBean();
    		cb.setCid(req.getParameter("cid"));
    		cb.setPcode(req.getParameter("pcode"));
    		cb.setPname(req.getParameter("pname"));
    		cb.setBrand(req.getParameter("brand"));
    		cb.setQty(Integer.parseInt(req.getParameter("qty")));
    		cb.setSprice(Double.parseDouble(req.getParameter("sprice")));
    		 boolean productExists = false;
    		    ArrayList<CartBean> al = new ViewCartDAO().retrive(cb.getCid(), cb.getPcode());
                for (CartBean prod : al) {
    		        if (prod.getCid().equals(cb.getCid()) && prod.getPcode().equals(cb.getPcode())) {
    		            productExists = true;
    		            break;
    		        }
    		    }
    		    if (productExists) {
    		        req.setAttribute("msg", "Product is already in your cart.");
    		    } else {
    		        int k = new CartDAO().insert(cb);
    		        if (k > 0) {
    		            req.setAttribute("msg", "Product added successfully to your cart.");
    		        }
    		    }
    		    req.getRequestDispatcher("AddtoCartProd.jsp").forward(req, res);
    		} 
    	}
}
