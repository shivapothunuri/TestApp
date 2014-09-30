package com.testapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@SuppressWarnings("serial")
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8804276765241348239L;

	/**
	 * @throws IOException 
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String lname=request.getParameter("loginName");
		String lpwd=request.getParameter("loginPwd");
		System.out.println("lname-->"+lname);
		System.out.println("Pwd--->"+lpwd);
		
		out.println("Name---->"+lname);
		out.println("Pwd---->"+lpwd);
		out.close();
	}

}
