package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;

public final class ViewAndBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/FlightStyles.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>View and Book</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id='sidebar' class='sidebar'>\r\n");
      out.write("\t    <script>\r\n");
      out.write("            $(\"#sidebar\").load(\"sidebar.jsp\");\r\n");
      out.write("        </script>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t");
  
		RecordFactory records = new RecordFactory(1);
		FlightRecord r = records.TestRecord();
		
	
      out.write('\r');
      out.write('\n');
      flight.bizlogic.FlightRecord SelectedFlight = null;
      synchronized (session) {
        SelectedFlight = (flight.bizlogic.FlightRecord) _jspx_page_context.getAttribute("SelectedFlight", PageContext.SESSION_SCOPE);
        if (SelectedFlight == null){
          SelectedFlight = new flight.bizlogic.FlightRecord();
          _jspx_page_context.setAttribute("SelectedFlight", SelectedFlight, PageContext.SESSION_SCOPE);
        }
      }
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("<div class='main'>\r\n");
      out.write("\r\n");
      out.write("\t<p class=\"PageTitle\">View and Book</p>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<form action='Transaction.jsp' method=get>\r\n");
      out.write("\t\t\t\t<tr><td class=\"key\">Number of Seats</td><td>\r\n");
      out.write("\t\t\t\t\t<select name=\"nSeats\">\r\n");
      out.write("\t\t\t\t\t\t");
 for (int i=1; i<=r.getSeats(); i++) {
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class=\"key\">Flight ID: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getnID())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Flight Date: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsDateOfTravel())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Departure Time: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsDepartureTime())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Departure Location: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsSource())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Arrival Time: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsArrivalTime())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Arrival Location: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsDestination())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Number of Stops: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getnNumberOfStops())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Class: </td><td>");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getsClass())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t<tr><td class='key'>Cost: </td><td>$");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((flight.bizlogic.FlightRecord)_jspx_page_context.findAttribute("SelectedFlight")).getdCost())));
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t</table>\t\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<tr><td><a href=\"FlightSearchResults.jsp\"><button type=\"button\" onclick=\"goBack()\">Back</button></a></td>\r\n");
      out.write("\t<td><input type=\"submit\" value=\"Submit\" style=\"font-weight:bold;\"></input></td>\r\n");
      out.write("\t<td><button type=button onclick=\"goHome()\">Home</button></td></tr>\r\n");
      out.write("\t</table>\t\t</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction goBack() {\r\n");
      out.write("\r\n");
      out.write("\t\twindow.location.replace(\"FlightSearchResults.jsp\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction goHome() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\twindow.location.replace(\"FlightSearch.jsp\");\r\n");
      out.write("\t}\r\n");
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
