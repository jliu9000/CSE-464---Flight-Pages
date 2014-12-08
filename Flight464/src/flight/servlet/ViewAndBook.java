package flight.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
		Double dTotalCost = 0.0;
		DbData oData = new DbData();
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");	
		
		
		if (alRecords != null && alRecords.size() > 0) {
			FlightRecord frTemp, frRetrievedFlight;
			for(int i = 0;i<alRecords.size();i++){
				frTemp = alRecords.get(i);
				dTotalCost += (frTemp.getdCost() * frTemp.getnNumSelectedSeats());
				
				try {
					frRetrievedFlight = oData.GetFlight(frTemp.getnID(), frTemp.getsClass());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					sMessage += "Internal Error: unable to retrieve your flight<BR>";
					break;
				}
				if (frRetrievedFlight.getnSeats() < frTemp.getnSeats()){
					sMessage += "Not enough seats on flight " +frTemp.getnID() +"<BR>";
				}
				System.out.println("total cost = " + dTotalCost);
				System.out.println("seats:" + frTemp.getnNumSelectedSeats());

			}
		} else {
			//redirect to error handling page
			sMessage = "Shopping cart is empty<BR>";
		}
		
		//forward request
		if (sMessage.equals("")){
			request.setAttribute("dTotalCost", dTotalCost);
			request.getRequestDispatcher(response.encodeURL("/WEB-INF/ConfirmBooking.jsp")).forward(request,response);
			
		} else {
			request.setAttribute("sMessage", sMessage);
			request.getRequestDispatcher(response.encodeURL("./ShoppingCart.jsp")).forward(request, response);
		}

	
	
	
	}
	
	

}
