package flight.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import flight.bizlogic.FlightRecord;
import flight.bizlogic.User;
import flight.data.DbData;

/**
 * Servlet implementation class BookingHistory
 */
public class BookingHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingHistory() {
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
		User user = (User) request.getSession().getAttribute("User");
		DbData oData = new DbData();
		ArrayList<FlightRecord> al = new ArrayList<FlightRecord>();
		String sMessage = "";
		
		if (user == null){
			sMessage = "No user logged in, please log in first<BR>";
			request.getRequestDispatcher("./Login.jsp").forward(request,response);
		}
		
		try {
			al = (ArrayList<FlightRecord>) oData.GetBookings(user.getnUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			sMessage += "Internal Error <BR>";
		}
		
		
		if (sMessage.equals("")) {
			request.setAttribute("alBookings", al);
			request.getSession().setAttribute("alBooking", al);
			response.sendRedirect("./BookingHistory.jsp");
		}else{
			request.setAttribute("sMessage",sMessage);
			request.getRequestDispatcher("./BookingHistory.jsp");
		}
		
		
		
	}

}