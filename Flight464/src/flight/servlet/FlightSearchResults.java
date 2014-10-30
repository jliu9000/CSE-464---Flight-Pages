package flight.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flight.bizlogic.FlightRecord;

/**
 * Servlet implementation class FlightSearchResults
 */
public class FlightSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearchResults() {
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
		String sMessage = "";
		FlightRecord fr = null;
		
		/****************************************************************************************
		Integer nFlightId = Integer.parseInt(request.getParameter("nFlightId"));
		
		if (nFlightId == null){
			sMessage = "Something went wrong, please go back and try again <br>";
		} else {
			//get flight record
		}
		
		if (fr == null){
			sMessage += "Unable to retrieve the selected flight, please go back and try again <br>";
		}
		****************************************************************************************/
		
		//test record ========================
		fr = new FlightRecord();
		fr.setnID(1);
		fr.setsDateOfTravel("10-22");
		fr.setsDepartureTime("1:23");
		fr.setsSource("source");
		fr.setsArrivalTime("arrival time");
		fr.setsDestination("destination");
		fr.setnNumberOfStops(2);
		fr.setsClass("First");
		fr.setdCost(123.00);
		fr.setnSeats(3);
		//end test record ====================
		
		if (sMessage.equals("")){
			request.setAttribute("SelectedFlight", fr);
			request.setAttribute("nAvailableSeats", fr.getnSeats());
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/ViewAndBook.jsp");
			rq.forward(request, response);
		} else {
			//redirect to error handling 
		}
	}

}
