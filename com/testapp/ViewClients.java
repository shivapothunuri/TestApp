package com.testapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewClients
 */
@WebServlet("/ViewClients")
public class ViewClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClients() {
        super();
        // TODO Auto-generated constructor stub
        //asdas
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try{

			Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection("jdbc:mysql://aa1231kud64hwzb.cjq7wmcfqfq6.us-west-2.rds.amazonaws.com:3306/ebdb","TestAppDB","eL0cal123");
			ps=con.prepareStatement("select * from client");
			rs=ps.executeQuery();
			out.println("<a href='addNew.jsp'>Add Client</a><center>");
			out.println("<table border='1'><tr><td>Client ID</td><td>Client Name</td><td>Location</td><td>Project Code</td></tr>");
			
			while(rs.next()){
				out.println("<tr><td>"+rs.getString("client_id")+"</td>");
				out.println("<td>"+rs.getString("client_name")+"</td>");
				out.println("<td>"+rs.getString("client_location")+"</td>");
				out.println("<td>"+rs.getString("project_code")+"</td></tr>");
			}
			out.println("</table></center>");
		}catch(SQLException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs != null) 
				try {
				rs.close(); 
				} 
			catch(Exception ex) { 
				System.out.println(ex);
			}
			if (ps != null) 
				try {
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
