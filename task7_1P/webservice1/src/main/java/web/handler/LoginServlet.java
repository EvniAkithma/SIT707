package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;

/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		String username = req.getParameter("username");
		String password = req.getParameter("passwd");
		String dob = req.getParameter("dob");

		String loginStatus = "fail";

		if (LoginService.login(username, password, dob)) {
			loginStatus = "success";
		}

		String htmlResponse =
				"<html>" +
				"<head><title>" + loginStatus + "</title></head>" +
				"<body><h2>Login status: " + loginStatus + "</h2></body>" +
				"</html>";

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		writer.println(htmlResponse);
		writer.flush();
	}
}
