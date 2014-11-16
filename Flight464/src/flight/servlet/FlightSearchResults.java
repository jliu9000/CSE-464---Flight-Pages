package flight.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flight.bizlogic.FlightRecord;
import flight.data.DbData;

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
		String sMessage = "";
		DbData oData = new DbData();
		FlightRecord fr = null;
		//ArrayList<FlightRecord> lShoppingCart = null;
		//HttpSession session = request.getSession();
		
		Integer nFlightId = 0;
		Double dCost = 0.0;
		String sClass = "";
		
		try{
			nFlightId = Integer.parseInt(request.getParameter("nFlightId"));
		} catch (Exception ex) {
			sMessage += "Invalid flight id, please try again <BR>";
		}
		try{
			dCost = Double.parseDouble(request.getParameter("dCost"));
		} catch (Exception ex){
			sMessage += "Invalid cost <BR>";
		}
		sClass = (String) request.getParameter("sClass");
		if (sClass == null || sClass.equals("")){
			sMessage += "Invalid seat class <BR>";
		}
		
		if (sMessage.equals("")){
			try{
				fr = oData.GetFlight(nFlightId, sClass);
			} catch (Exception ex){
				sMessage += "Internal Error";
				ex.printStackTrace();
			}
		}
		
		if (fr == null){
			sMessage += "Unable to retrieve the selected flight, please go back and try again <br>";
		}
		
		/**
		lShoppingCart = (ArrayList<FlightRecord>) session.getAttribute("lShoppingCart");
		if (lShoppingCart == null){
			lShoppingCart = new ArrayList<FlightRecord>();
		}
		**/
		
		
		if (sMessage.equals("")){
			fr.setdCost(dCost);
			fr.setsClass(sClass);
			request.setAttribute("SelectedFlight", fr);
			request.setAttribute("nAvailableSeats", fr.getnSeats());
			RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/ViewAndBook.jsp");
			rq.forward(request, response);
		} else {
			request.setAttribute("sMessage", sMessage);
			request.getRequestDispatcher("WEB-INF/FlightSearchResults.jsp").forward(request,response);
		}
	}

}
