

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
				String path = this.getServletContext().getRealPath("/");
				Users newUser = new Users(path);
				String sUserName = request.getParameter("Username");
				String sPassword = request.getParameter("Password");
				boolean ValidLogin = newUser.VerifyPassword(sUserName, sPassword);
				if (ValidLogin){
					response.sendRedirect("FlightSearch.jsp");
				}
				else response.sendRedirect("Registration.jsp");
				
				
				
				//if user exists, redirect somewhere, else redirect elsewhere
				
				
//				PrintWriter out = response.getWriter();
//			      out.println("<h1>" + "this is a test thingy" + "</h1>");
	}

}
