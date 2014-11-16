package flight.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		UserTransaction oTransactionRecord = null;
		DbData oData = new DbData();
		FlightRecord fr = null;
		//request params
		String sAccountHolder = "";
		Integer nRoutingNumber = 0;
		Integer nAccountNumber = 0;
		Integer nFlightID = 0;
		Integer nSeats = 0;
		String sClass = "";
		double dAccountBalance = 0;
		double dCost = 0.0;
		double dTotalCost = Double.MAX_VALUE;
		
		User user = (User) request.getSession().getAttribute("User");
		if (user == null){
			//shouldn't get here... right?
			request.setAttribute("sMessage", "Please login first before attempting to select a site");
			request.getRequestDispatcher("Login").forward(request, response);
		}
		
		//check params
		try{
			nRoutingNumber = Integer.parseInt(request.getParameter("nRoutingNumber"));
		} catch (Exception ex) {
			sMessage = "Invalid routing number<BR>";
		}
		try{
			nAccountNumber = Integer.parseInt(request.getParameter("nAccountNumber"));
		} catch (Exception ex) {
			sMessage += "Invalid account number<BR>";
		}
		try{
			nFlightID = Integer.parseInt(request.getParameter("nFlightId"));
		} catch (Exception ex) {
			sMessage += "Invalid flight id<BR>";
		}
		try{
			nSeats = Integer.parseInt(request.getParameter("nSeats"));
		} catch (Exception ex) {
			sMessage += "Invalid number of seats<BR>";
		}

		if (nSeats == 0){
			sMessage += "Invalid number of seats selected (0) <BR> ";
		}
		sAccountHolder = (String) request.getParameter("sAccountHolder");
		if (sAccountHolder == null || sAccountHolder.equals("")){
			sMessage += "Invalid Account Holder <BR>";
		}
		sClass = (String) request.getParameter("sClass");
		if (sClass == null || sClass.equals("")){
			sMessage +="Unable to retrieve seating class <BR>";
		}
		
		
		if (sMessage.equals("")){
			//check seats
			try{
				fr = oData.GetFlight(nFlightID, sClass);
			} catch (Exception ex){
				sMessage += "Internal Error <BR>";
				ex.printStackTrace();
			}
			
			if (fr.getnSeats() <= nSeats){
				sMessage += "Not enough seats available <BR>";
			} else {
				//check balance
				try {
					dAccountBalance = oData.getBalance(nRoutingNumber, nAccountNumber);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sMessage += "Internal Error <BR>";
				}				
			}
			dTotalCost = fr.getdCost() * nSeats;
			//commit transaction
			if (sMessage.equals("") && dAccountBalance >= dTotalCost){
				//take money
				try {
					oData.completeTransaction(user.getnUserId(), nAccountNumber, nRoutingNumber, fr.getdCost());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					sMessage += "Internal Error <BR>";
					e.printStackTrace();
				}
				//add to flight record
				if (sMessage.equals("")){
					try {
						oData.AddBooking(nFlightID, nSeats, sClass, nAccountNumber, user.getnUserId(), dCost, fr.getsDateOfTravel());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						sMessage += "Interal Error <BR>";
					}
				}
				
			}
		
		}
		
		if (sMessage.equals("")) {
			request.setAttribute("sMessage", "Your flight has been booked");
			request.setAttribute("sAccountHolder", sAccountHolder);
			request.setAttribute("dTotalCost", dTotalCost);
			request.setAttribute("ConfirmedFlight", fr);
		} else {
			sMessage = "We were unable to book your flight for the following reasons:<BR><BR>" + sMessage;
			request.setAttribute("sMessage", sMessage);
			request.setAttribute("ConfirmedFlight", oTransactionRecord);
		}
		request.getRequestDispatcher("WEB-INF/TransactionConfirmation.jsp").forward(request, response);
		
		
	}

}
