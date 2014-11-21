package flight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flight.bizlogic.FlightRecord;
import flight.bizlogic.User;
import flight.bizlogic.UserTransaction;
import flight.data.DbData;

/**
 * Servlet implementation class ConfirmTransaction
 */
public class TransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionConfirmation() {
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
		String sMessage = "";
		DbData oData = new DbData();
		HttpSession session = request.getSession(true);
		
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");
		if (alRecords == null){
			sMessage = "No flights selected in your shopping cart, please try again";
		}
		
		User user = (User) request.getSession().getAttribute("User");
		if (user == null){
			//shouldn't get here... right?
			request.setAttribute("sMessage", "Please login first before attempting to select a site");
			request.getRequestDispatcher("Login").forward(request, response);
		}
		
		
		if (sMessage.equals("")){
			for (FlightRecord fr : alRecords){
				if (sMessage.equals("")){
					try {
						oData.AddBooking(fr.getnID(), fr.getnNumSelectedSeats(), fr.getsClass(), 0, user.getnUserId(), fr.getdCost(), fr.getsDateOfTravel());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						sMessage += "Interal Error <BR>";
					}
				}
				if (! sMessage.equals("")){
					break;
				}
			}
		}
		Boolean bSuccess = false;
		String JSONResponse;

		if (sMessage.equals("")) {
			sMessage = "Your flight has been booked";
			session.setAttribute("ShoppingCart", null);
		}
		
		JSONResponse = "{\"sMessage\":" +"\"" +sMessage +"\"," +"\"bSuccess\":\"" +bSuccess +"\"}";
		
        PrintWriter responseWriter  = response.getWriter();
        responseWriter.println(JSONResponse);
        responseWriter.close();

		
	}

}
