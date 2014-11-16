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

import flight.bizlogic.FlightRecord;
import flight.data.DbData;
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
		ArrayList<FlightRecord> alRecords = null;
		DbData oData = new DbData();
		
		String sMessage ="";
		//form parameters
		
		String sSource = request.getParameter("sSource");
		String sDestination = request.getParameter("sDestination");
		String sDateStart = request.getParameter("sDateStart");
		String sClass = request.getParameter("sClass");
		int nSeats = 0;
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
		if (sDateStart == null || sDateStart.equals("")){
			sMessage += "Please enter a start date of travel <br>";
		}
		if (sClass == null || sClass.equals("")){
			sMessage += "Please enter a flight class <br>";
		}

		if (sMessage.equals("")){
			try {
				alRecords = (ArrayList <FlightRecord>) oData.searchFlights(sSource, sDestination, sDateStart, nSeats, sClass);
			} catch (Exception ex) {
				sMessage += "Internal Error, please try again later";			
			}
		}
				
		
		if (sMessage.equals("")){
			if (alRecords.size() == 100){
				sMessage = "Showing the top 100 results for your query";
				request.setAttribute("sMessage", sMessage);
			}
			request.setAttribute("lSearchResults", alRecords);
			request.getRequestDispatcher("WEB-INF/FlightSearchResults.jsp").forward(request,response);

		} else {
			request.setAttribute("sMessage", sMessage);	
			request.getRequestDispatcher("FlightSearch.jsp").forward(request,response);

		}
	
	}

}
