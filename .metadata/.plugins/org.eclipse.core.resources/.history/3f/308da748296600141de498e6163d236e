package flight.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flight.bizlogic.Users;
import flight.data.DbData;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
		private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sUserName = request.getParameter("UserName");
		String sPassword = request.getParameter("Password");
		
		String sMessage;
	
		
		DbData dbData = new DbData();
		String sReturnPass = null;
		try {
			sReturnPass = dbData.getUserCredentials(sUserName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql exceptions for get user credential");
			sMessage = "Invalid request, please try again";
		}
		if (sReturnPass == null){
			try {

				dbData.addUser(sUserName, sPassword.hashCode());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				sMessage = "Username Already Exists";
			}
			sMessage = "User Added Successfully";
		}
		else{
			sMessage = "User Already Exists";
			System.out.println("user already exists");
		}
		
		request.setAttribute("sMessage", sMessage);
		request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

}
