

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String path = this.getServletContext().getRealPath("/");
		String sUserName = request.getParameter("UserName");
		String sPassword = request.getParameter("Password");
		PrintWriter out = response.getWriter();
		
		Users newUser = new Users(path);
		boolean bIsUniqueUser = newUser.isUnique(sUserName);
		if (bIsUniqueUser){
			newUser.addUser(sUserName, sPassword);
			
		}
		else{
			out.println("<html><body onload=\"alert('Username already exists');\"></body></html>");
		}
		response.sendRedirect("Login.jsp");
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
