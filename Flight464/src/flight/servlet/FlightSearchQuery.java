package flight.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import flight.bizlogic.*;
/**
 * Servlet implementation class FlightSearchQuery
 */
public class FlightSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightSearchQuery() {
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
		FlightRecordList lRecords = new FlightRecordList();
		String sMessage ="";
		//form parameters
		
		String sSource = request.getParameter("sSource");
		String sDestination = request.getParameter("sDestination");
		String sDate = request.getParameter("sDate");
		String sClass = request.getParameter("sClass");
		int nSeats;
		try{
			nSeats = Integer.parseInt(request.getParameter("nSeats"));
		} catch (Exception e) {
			sMessage = "Invalid number of seats selected <br>";
		}
		
		if (sSource == null || sSource.equals("")){
			sMessage += "Please enter a flight source <br>";
		}
		if (sDestination == null || sDestination.equals("")){
			sMessage += "Please enter a flight destination <br>";
		}
		if (sDate == null || sDate.equals("")){
			sMessage += "Please enter a desired date of travel <br>";
		}
		if (sClass == null || sClass.equals("")){
			sMessage += "Please enter a flight class <br>";
		}

		if (sMessage.equals("")){
			//load record
		}
		
		//static test data ===================
		ArrayList<FlightRecord> al = new ArrayList();
		FlightRecord fr;
		
		for (int i=0; i<10; i++){
			fr = new FlightRecord();
			fr.setnID(i);
			fr.setsDateOfTravel("10-22" + i);
			fr.setsDepartureTime("1:23" +i);
			fr.setsSource("source" +i);
			fr.setsArrivalTime("arrival time" +i);
			fr.setsDestination("destination" +i);
			fr.setnNumberOfStops(i*2);
			fr.setsClass("First" + i);
			fr.setdCost(123.00 + i);
			al.add(fr);
		}
		lRecords.setFlightRecordList(al);
		//end test data =======================
		
		
		if (sMessage.equals("")){
			request.setAttribute("SearchResults", lRecords);
			request.setAttribute("Count", lRecords.getLength());	
	
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/FlightSearchResults.jsp");
			rq.forward(request, response);
		} else {
			request.setAttribute("sMessage", sMessage);	
			request.getRequestDispatcher("FlightSearch.jsp").forward(request,response);

		}
	
	}

}
