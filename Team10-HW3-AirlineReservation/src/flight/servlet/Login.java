package flight.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flight.bizlogic.User;
import flight.bizlogic.Users;
import flight.bizlogic.Users;
import flight.data.DbData;

import java.sql.SQLException;
import java.util.*;
import java.io.*;
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				System.out.println("In here");

				//Users newUser = new Users(path);
				String sUserName = request.getParameter("Username");
				String sPassword = request.getParameter("Password");
				String sMessage;
				
				
				DbData dbData = new DbData();
				String sReturnPass = null;
				
				try {
					sReturnPass = dbData.getUserCredentials(sUserName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("sql exceptions for get user credential");
					sMessage = "Invalid User, please try again, or register";
				}
				if (sReturnPass == null){
					sMessage = "Invalid Login or Password";
					
					request.setAttribute("sMessage", sMessage);
					request.getRequestDispatcher("Login.jsp").forward(request,response);
				}else{
					int hashPass = sPassword.hashCode();
					String sHassPass = String.valueOf(hashPass);
					
					if(sHassPass.equals(sReturnPass)){
						User user = new User();
						try {
							user.setnUserId(dbData.getUserId(sUserName));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						user.setUsername(sUserName);
						request.getSession().setAttribute("User", user);
						response.sendRedirect("FlightSearch.jsp");
					}else{
						sMessage = "Incorrect login credentials";
						request.setAttribute("sMessage", sMessage);
						request.getRequestDispatcher("Login.jsp").forward(request,response);
					}
					
				}
				
				
				
				
				

	}

}
