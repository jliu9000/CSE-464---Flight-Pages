package flight.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flight.bizlogic.Organizations;
import flight.bizlogic.User;
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
		String sFullName = request.getParameter("FullName");
		String sOrganization = request.getParameter("Organization");
		String sAddress = request.getParameter("Address");
		
		
		String sMessage;
		
		User oUser = new User(sUserName);
		boolean userAdded = oUser.addUser(sUserName, sPassword.hashCode(), sFullName);
		
		Organizations oOrg = new Organizations(sUserName);
		boolean orgAdded = oOrg.addOrgInfo(sOrganization,sAddress);
		
		if (userAdded && orgAdded){
			sMessage = "User Added Successfully";
		}else if(userAdded){
			sMessage = "User added: Org Data not updated!";
		}else{
			sMessage = "User Already Exists";
		}
		
		request.setAttribute("sMessage", sMessage);
		request.getRequestDispatcher("Login.jsp").forward(request,response);
		/*try {
			sReturnPass = dbData.getUserCredentials(sUserName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("sql exceptions for get user credential");
			sMessage = "Invalid request, please try again";
		}
		if (sReturnPass == null){
			try {

				dbData.addUser(sUserName, sPassword.hashCode(),"","");
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
		*/
		
	}	

}
