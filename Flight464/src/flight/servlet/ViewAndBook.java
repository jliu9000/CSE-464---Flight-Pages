package flight.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flight.bizlogic.FlightRecord;
import flight.data.DbData;

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
		DbData oData = new DbData();
		String sMessage = "";
		Integer nFlightId = 0;
		Integer nSeats = 0;
		Double dCost = 0.0;
		String sClass = "";
		FlightRecord fr = null;
		
		try{
			nFlightId = Integer.parseInt(request.getParameter("nFlightId"));
			nSeats = Integer.parseInt(request.getParameter("nSeats"));
		} catch (Exception ex){
			sMessage = "Something went wrong, please go back and try again <br>";			
		}
		try {
			dCost = Double.parseDouble(request.getParameter("dCost"));
		} catch (Exception ex){
			sMessage += "Invalid cost <br>";
		}
		sClass = (String) request.getParameter("sClass");
		if (sClass == null || sClass.equals("")){
			sMessage += "Invalid seating class<br>";
		}
		
		if (sMessage.equals("")) {
			try {
			fr = oData.GetFlight(nFlightId, sClass);
			} catch (Exception ex){
				sMessage += "Internal Error <br>";
			}
		}		
		if (fr != null && fr.getnSeats() < nSeats){
			sMessage += "Your number of selected seats exceeds the number of available seats <br>";
		}

		
		if (sMessage.equals("")) {
			fr.setdCost(dCost);
			fr.setnQueuedSeats(nSeats);
	
			request.setAttribute("SelectedFlight", fr);
			request.getRequestDispatcher("WEB-INF/Transaction.jsp").forward(request, response);
		} else {
			//redirect to error handling page
			request.setAttribute("sMessage", sMessage);
			request.getRequestDispatcher("WEB-INF/ViewAndBook.jsp").forward(request, response);
		}
	}
	
	

}
