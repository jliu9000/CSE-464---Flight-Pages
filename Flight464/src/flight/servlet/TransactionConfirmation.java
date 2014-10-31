package flight.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flight.bizlogic.FlightRecord;
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
				
		//request params
		String sAccountHolder = "";
		Integer nRoutingNumber = 0;
		Integer nAccountNumber = 0;
		Integer nFlightID = 0;
		Integer nSeats = 0;
		
		//check params
		try{
			nRoutingNumber = (Integer) request.getAttribute("nRoutingNumber");
		} catch (Exception ex) {
			sMessage = "Invalid routing number<BR>";
		}
		try{
			nAccountNumber = (Integer) request.getAttribute("nAccountNumber");
		} catch (Exception ex) {
			sMessage += "Invalid account number<BR>";
		}
		try{
			nFlightID = (Integer) request.getAttribute("nFlightId");
		} catch (Exception ex) {
			sMessage += "Invalid flight id<BR>";
		}
		try{
			nSeats = (Integer) request.getAttribute("nSeats");
		} catch (Exception ex) {
			sMessage += "Invalid number of seats<BR>";
		}
		if (nSeats == 0){
			sMessage += "Invalid number of seats selected (0) <BR> ";
		}
		sAccountHolder = (String) request.getAttribute("sAccountHolder");
		if (sAccountHolder == null || sAccountHolder.equals("")){
			sMessage += "Invalid Account Holder <BR>";
		}
		
		
		if (sMessage.equals("")){
			oTransactionRecord = new UserTransaction();
			oTransactionRecord.setsAccountHolder(sAccountHolder);
			oTransactionRecord.setnAccountNumber(nAccountNumber);
			oTransactionRecord.setnRoutingNumber(nRoutingNumber);
			oTransactionRecord.setnFlightId(nFlightID);
			oTransactionRecord.setnSeats(nSeats);
		}
		
		
		
		
		//get seats
		
		//get payment
		
		if (sMessage.equals("")) {
			request.setAttribute("sMessage", "Your flight has been booked");
			request.setAttribute("ConfirmedFlight", oTransactionRecord);
		} else {
			sMessage = "We were unable to book your flight for the following reasons:<BR>" + sMessage;
			request.setAttribute("sMessage", sMessage);
			request.setAttribute("ConfirmedFlight", oTransactionRecord);
		}
		request.getRequestDispatcher("WEB-INF/TransactionConfirmation.jsp").forward(request, response);
		
		
	}

}
