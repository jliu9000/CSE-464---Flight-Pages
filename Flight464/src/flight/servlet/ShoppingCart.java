package flight.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flight.bizlogic.FlightRecord;

/**
 * Servlet implementation class ShoppingCart
 */
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
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
		//System.out.println("Made it to shopping cart");
		
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");	
		FlightRecord oAddedFlightRecord = (FlightRecord) session.getAttribute("RequestedFlight");
		
		if (request.getParameter("sSelectedNumSeats") != null){
			String temp  =(String) request.getParameter("sSelectedNumSeats");
			oAddedFlightRecord.setnNumSelectedSeats(Integer.parseInt(temp));
			
			if(alRecords == null ){
				alRecords = new ArrayList<FlightRecord>();
				alRecords.add(oAddedFlightRecord);
				
			}else{
				alRecords.add(oAddedFlightRecord);
			}
		}
		if (request.getParameter("UpdateCart") != null){
			int temp  =Integer.parseInt((String) request.getParameter("UpdateCart"));
			int value = Integer.parseInt((String) request.getParameter("Value"));
			System.out.println("ASdAsdasdas: " + temp + " - " + value);
			FlightRecord updateCartRecord = alRecords.get(temp);
			updateCartRecord.setnNumSelectedSeats(value);
			alRecords.set(temp, updateCartRecord);
			
		}
		
		
		
		
		System.out.println("number in cart:" + alRecords.size());
		session.setAttribute("ShoppingCart", alRecords);
		
	}

}
