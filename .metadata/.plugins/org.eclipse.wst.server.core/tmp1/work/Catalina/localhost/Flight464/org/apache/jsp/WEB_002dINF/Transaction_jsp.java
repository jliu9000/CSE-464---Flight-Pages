package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;
import flight.bizlogic.User;

public final class Transaction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
	String sMessage;
	sMessage = (String) request.getAttribute("sMessage");
	if(sMessage == null || sMessage.equals("")){
		sMessage = "";
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/FlightStyles.css\">\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("<title>Transaction</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      flight.bizlogic.FlightRecord SelectedFlight = null;
      synchronized (request) {
        SelectedFlight = (flight.bizlogic.FlightRecord) _jspx_page_context.getAttribute("SelectedFlight", PageContext.REQUEST_SCOPE);
        if (SelectedFlight == null){
          SelectedFlight = new flight.bizlogic.FlightRecord();
          _jspx_page_context.setAttribute("SelectedFlight", SelectedFlight, PageContext.REQUEST_SCOPE);
        }
      }
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='sidebar' class='sidebar'>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../sidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class='main'>\r\n");
      out.write("\t\t<p class='PageTitle'>Transactions</p>\r\n");
      out.write("\t\t<p class='subheading'>Flight Information:</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class='ErrorMessage'>");
      out.print(sMessage );
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class='key'>Flight Number: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getnID())));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class='key'>Flight Date: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsDateOfTravel())));
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class='key'>Departure Time:</td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsDepartureTime())));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td class='key'>Arrival Time:</td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsArrivalTime())));
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class='key'>Number of Stops:</td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getnNumberOfStops())));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td></td><td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<p><b>Cost:</b> $");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getdCost())));
      out.write("</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p class='subheading'>Payment Information:</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action='ConfirmTransaction' method=post>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"nFlightId\" value=\"");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getnID())));
      out.write("\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='key'>Account Holder's Name: </td><td><input type=\"text\" name=\"sAccountHolder\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='key'>Routing Number: </td><td><input type=\"text\" name=\"nRoutingNumber\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='key'>Account Number: </td><td><input type=\"password\" name=\"nAccountNumber\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td></td><td></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class='button' colspan=2>\t\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Confirm\"></input>\r\n");
      out.write("\t\t\t\t        &nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" onclick=\"Cancel()\">Cancel</button>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("<br><br><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\tfunction Cancel() {\r\n");
      out.write("\t\twindow.location.replace(\"FlightSearch.jsp\");\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
