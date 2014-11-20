package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;
import java.util.ArrayList;
import flight.bizlogic.User;

public final class ConfirmBooking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/LoginHelper.jsp");
    _jspx_dependants.add("/WEB-INF/ErrorMessageHelper.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
 
	
	
	User user = null;
	
	user = (User) session.getAttribute("User");
	
	
	
	if (user == null){
		request.setAttribute("sMessage", "Please login to view any flight pages");
		request.getRequestDispatcher("./Login.jsp").forward(request,response);
	}


      out.write('\r');
      out.write('\n');
 
	String sMessage = "";
	sMessage = (String) request.getAttribute("sMessage");
	if(sMessage == null || sMessage.equals("")){
		sMessage = "";
	}

      out.write(' ');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Confirm Booking</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\t");
  
		int nTotalRecords = 0;
		Double dTotalCost = 0.0;
		ArrayList<FlightRecord> alRecords = (ArrayList <FlightRecord>) session.getAttribute("ShoppingCart");
		if (alRecords == null){
			sMessage += "Unable to load your shopping cart transactions, please try again.<BR>";
		} else {
			nTotalRecords = alRecords.size();
		}
		dTotalCost = (Double) request.getAttribute("dTotalCost");
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='sidebar' class='sidebar'>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div class='main'>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<p class=\"PageTitle\">Shopping Cart</p>\r\n");
      out.write("\t\t<p class=\"subheading\"></p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class='ErrorMessage'>");
      out.print(sMessage );
      out.write("</div>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<th>Flight ID</th>\r\n");
      out.write("\t\t\t\t<th>Date</th>\r\n");
      out.write("\t\t\t\t<th>Departure Time</th>\r\n");
      out.write("\t\t\t\t<th>Arrival Time</th>\r\n");
      out.write("\t\t\t\t<th>Number of Stops</th>\r\n");
      out.write("\t\t\t\t<th>Cost</th>\r\n");
      out.write("\t\t\t\t<th>Number of Seats</th>\r\n");
      out.write("\t\t\t</TR>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");

				FlightRecord frTemp;
			
				for (int i = 0; i<nTotalRecords; i++){
      out.write("\r\n");
      out.write("\t\t\t\t<tr class='");
      out.print( i % 2 == 1 ? "repeatalt" : "repeat" );
      out.write("'>\r\n");
      out.write("\t\t\t\t\t");
 frTemp = alRecords.get(i);  
      out.write("\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getnID() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getsDateOfTravel() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getsDepartureTime() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getsArrivalTime() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getnNumberOfStops() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<TD>");
      out.print( frTemp.getdCost() );
      out.write("</TD>\r\n");
      out.write("\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t<select name=\"");
      out.print(i );
      out.write("\" id=\"Select\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
 for (int j=0; j<=frTemp.getnSeats(); j++) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if(j == frTemp.getnNumSelectedSeats()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(j );
      out.write("\" selected=\"selected\">");
      out.print(j );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t");
 }else{
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(j );
      out.write('"');
      out.write('>');
      out.print(j );
      out.write("</option>");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t<BR><BR>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='key'>Account Holder's Name: </td><td><input type=\"text\" id=\"sAccountHolder\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='key'>Routing Number: </td><td><input type=\"text\" id=\"nRoutingNumber\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='key'>Account Number: </td><td><input type=\"password\" id=\"nAccountNumber\" /></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='button' colspan=2>\t\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" onclick=\"ConfirmTransaction()\">Confirm</button>\r\n");
      out.write("\t\t\t\t        &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" onclick=\"Cancel()\">Cancel</button>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<input id='dTotalCost' value='");
      out.print(dTotalCost );
      out.write("' type=hidden></input>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction ConfirmTransaction(){\r\n");
      out.write("\t\talert(\"clicked\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar dTotalCost = $(\"#dTotalCost\").val();\r\n");
      out.write("\t\tvar nAcctNumber = $(\"#nAccountNumber\").val();\r\n");
      out.write("\t\tvar nRoutingNumber = $(\"#nRoutingNumber\").val();\r\n");
      out.write("//\t\tif (isNaN(dTotalCost) || dTotalCost <= 0 || isNaN(nAcctNumber) || isNaN(nRoutingNumber)){\r\n");
      out.write("\t\tif (isNaN(dTotalCost) || dTotalCost <= 0 || isNaN(nAcctNumber) || isNaN(nRoutingNumber)){\r\n");
      out.write("\r\n");
      out.write("\t\t\talert(dTotalCost, nAcctNumber);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$.ajax\r\n");
      out.write("            ({\r\n");
      out.write("                type: \"POST\",\r\n");
      out.write("                url: '../Bank/PostTransaction',\r\n");
      out.write("                dataType: 'json',\r\n");
      out.write("                data:{ \t\r\n");
      out.write("\t\t\t\t\"nAccountNumber\":nAcctNumber,\r\n");
      out.write("\t\t\t\t\"nRoutingNumber\":nRoutingNumber,\r\n");
      out.write("\t\t\t\t\"dCost\":dTotalCost\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("\t\t\t\t\talert(JSON.stringify(data));\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(data){\r\n");
      out.write("\t\t\t\t\talert(\"error\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("  \t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\talert('done');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction Cancel() {\r\n");
      out.write("\t\twindow.location.replace(\"FlightSearch.jsp\");\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
