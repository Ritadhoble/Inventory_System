package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlt extends HttpServlet
{
	@Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	  HttpSession hs=req.getSession();
	  if(hs==null){
		  req.setAttribute("msg","Session expired...<br>");
		  req.getRequestDispatcher("Home.jsp").forward(req, res);
	  }
	  else{
		  req.getRequestDispatcher("Logout.jsp").forward(req, res);
	  }
   }

}
