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

import bean.CartBean;
import dao.RemoveCartProdDAO;

@SuppressWarnings("serial")
@WebServlet("/remove")
public class RemoveCartProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);
        if (hs == null) {
            req.setAttribute("msg", "Session Expired...<br>");
            req.getRequestDispatcher("Home.jsp").forward(req, res);
        } else {
            String cId = req.getParameter("cid");
            String pCode = req.getParameter("pcode");
            ArrayList<CartBean> al2 = (ArrayList<CartBean>) hs.getAttribute("list");
            
            CartBean cb1 = null;
            Iterator<CartBean> it = al2.iterator();
            while (it.hasNext()) {
                cb1 = it.next();
                if (cId.trim().equals(cb1.getCid().trim()) && pCode.trim().equals(cb1.getPcode().trim())) {
                    break;
                }
            }
            int k = new RemoveCartProdDAO().delete(cb1);
            if (k > 0) {
                req.setAttribute("msg", "Cart product deleted successfully...<br>");
                
                al2.remove(cb1);
                
                hs.setAttribute("list", al2);
            }
            req.getRequestDispatcher("DeleteCartProduct.jsp").forward(req, res);
        }
    }
}
