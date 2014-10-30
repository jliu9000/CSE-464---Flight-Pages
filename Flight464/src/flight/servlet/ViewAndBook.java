package flight.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flight.bizlogic.FlightRecord;

/**
 * Servlet implementation class ViewAndBook
 */
public class ViewAndBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndBook() {
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
		Integer nFlightId = 0;
		Integer nSeats = 0;
		
		try{
			nFlightId = Integer.parseInt(request.getParameter("nFlightId"));
			nSeats = Integer.parseInt(request.getParameter("nSeats"));
		} catch (Exception ex){
			sMessage = "Something went wrong, please go back and try again <br>";			
		}
		
		if (sMessage.equals("")) {
			//get flightrecord 
		}
		FlightRecord oSelectedFlight = null;
		
		/**************************************************************************************
		if (oSelectedFlight.getnSeats() < nSeats){
			sMessage += "Your number of selected seats exceeds the number of available seats <br>";
		}
		**************************************************************************************/
		sMessage = "";
		if (sMessage.equals("")) {
			request.setAttribute("nSeats", nSeats);
			request.setAttribute("nFlightId", nFlightId);
			request.setAttribute("SelectedFlight", oSelectedFlight);
			request.getRequestDispatcher("WEB-INF/Transaction.jsp").forward(request, response);
		} else {
			//redirect to error handling page
			request.setAttribute("sMessage", sMessage);
			request.getRequestDispatcher("WEB-INF/ViewAndBook.jsp").forward(request, response);
		}
	}
	
	

}
