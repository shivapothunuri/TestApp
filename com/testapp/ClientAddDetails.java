package com.testapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientAddDetails extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2566328536897720903L;

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String cloc=request.getParameter("cloc");
		String pcode=request.getParameter("pcode");
		
		Connection con=null;
		PreparedStatement ps=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("org.gjt.mm.mysql.driver");
		  con=DriverManager.getConnection("jdbc:mysql://aa1231kud64hwzb.cjq7wmcfqfq6.us-west-2.rds.amazonaws.com:3306/ebdb","TestAppDB","eL0cal123");
		String qry="insert into client(client_id,client_name,client_location,project_code) values (?,?,?,?)";
		  ps=con.prepareStatement(qry);
		ps.setString(1, cid);
		ps.setString(2, cname);
		ps.setString(3, cloc);
		ps.setString(4, pcode);
		int i=ps.executeUpdate();
	if(i>0){
		out.println("Client Details inserted Successfully---<a href='index.html'>Home</a>");
	}else{
		out.println("Please check the details---<a href='addNew.jsp'>Add New Client</a>");
	}
			
		}
		catch(SQLException e){
			System.out.println("Exception[-->"+e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception[-->"+e);
			out.println("Please check the details---<a href='addNew.jsp'>Add New Client</a>");
		}
		finally{
			if (ps != null) try {
				ps.close(); 
				} 
			catch(Exception ex) { 
				System.out.println(ex);
 }
			if(con != null)
				try{
					con.close();
				}catch(Exception e){
					System.out.println(e);
				}
				}
		}
		
	 

}
