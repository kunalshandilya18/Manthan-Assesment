package com.manthan.shoppingapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession(false);
		if (session!=null) {
			session.invalidate();
			req.setAttribute("logoutMsg", "You are Logout!!");
			req.getRequestDispatcher("./login").include(req, resp);
		} else {
			req.getRequestDispatcher("./login").include(req, resp);
		}
	}

}
