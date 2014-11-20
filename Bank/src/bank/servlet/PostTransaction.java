package bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bank.data.DBBank;

/**
 * Servlet implementation class PostTransaction
 */
public class PostTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTransaction() {
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
		DBBank oBank = new DBBank();
		String sMessage = "";
		boolean bSuccess = false;
		String JSONresponse;
		//input param
		int nAccountNumber;
		int nRoutingNumber;
		double dCost;
		
		nAccountNumber = Integer.parseInt(request.getParameter("nAccountNumber"));
		nRoutingNumber = Integer.parseInt(request.getParameter("nRoutingNumber"));
		dCost = Double.parseDouble(request.getParameter("dCost"));
		
		try{
			bSuccess = oBank.completeTransaction(nAccountNumber, nRoutingNumber, dCost);
		} catch (Exception ex){
			ex.printStackTrace();
			sMessage = "Internal Error:  We are unable to process your bank transaction, please try again later";
		}
		
		JSONresponse = "{ \"bSuccess\" : \"" +bSuccess +"\", \"sMessage\": \"" +sMessage +"\"}" ;
		
		//write response
        PrintWriter responseWriter  = response.getWriter();
        responseWriter.println(JSONresponse);
        responseWriter.close();
        
	}

}