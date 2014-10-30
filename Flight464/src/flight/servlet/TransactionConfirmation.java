package flight.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flight.bizlogic.FlightRecord;

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
		FlightRecord ConfirmedFlight = null;
		
		//request params
		String sAccountHolder;
		Integer nRoutingNumber;
		Integer nAccountNumber;
		Integer nFlightID;
		Integer nSeats;
		
		//check params
		try{
			nRoutingNumber = (Integer) request.getAttribute("nRoutingNumber");
			nAccountNumber = (Integer) request.getAttribute("nAccountNumber");
			nFlightID = (Integer) request.getAttribute("nFlightId");
			nSeats = (Integer) request.getAttribute("nSeats");
		} catch (Exception ex) {
			sMessage = "Invalid numerical data sent <BR>";
		}
		sAccountHolder = (String) request.getAttribute("sAccountHolder");
		if (sAccountHolder == null || sAccountHolder.equals("")){
			sMessage += "Invalid Account Holder <BR>";
		}
		
		//get seats
		
		//get payment
		
		if (sMessage.equals("")) {
			request.setAttribute("sMessage", "Your flight has been booked");
			request.setAttribute("ConfirmedFlight", ConfirmedFlight);
		} else {
			sMessage = "We were unable to book your flight for the following reasons:<BR>" + sMessage;
			request.setAttribute("sMessage", sMessage);
			request.setAttribute("ConfirmedFlight", ConfirmedFlight);
		}
		request.getRequestDispatcher("WEB-INF/TransactionConfirmation.jsp").forward(request, response);
		
		
	}

}
