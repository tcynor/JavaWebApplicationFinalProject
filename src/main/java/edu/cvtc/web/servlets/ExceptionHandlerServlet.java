package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExceptionHandlerServlet
 */
@WebServlet("/ExceptionHandlerServlet")
public class ExceptionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
				
		final Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
			
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
				
		String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
			if (requestURI == null) {
				requestURI = "Unknown";
		}
				
		response.setContentType("text/html");
				
		final PrintWriter out = response.getWriter();
				
		out.append("<!doctype html><html>\n<head>\n\t<title>Exception/Error Details</title>\n</head>\n<body>");
				
		if (statusCode != 500) {
			out.append("\n\t<h3>Error Details</h3>");
			out.append("\n\t<strong>Status Code</strong>: " + statusCode + "<br>");
			out.append("\n\t<strong>RequestedURI</strong>: " + requestURI);			
		} else {
			out.append("\n\t<h3>Exception Details</h3>");
			out.append("\n\t<ul>\n\t\t<li>Requested URI: " + requestURI + "</li>");
			out.append("\n\t\t<li>Servlet Name: " + servletName + "</li>");
			out.append("\n\t\t<li>Exception Name: " + throwable.getClass().getName() + "</li>");
			out.append("\n\t\t<li>Exception Messages: " + throwable.getMessage() + "</li>\n\t</ul>");
		}
				
		out.append("\n</body>\n</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
