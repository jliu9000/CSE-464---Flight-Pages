package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FlightSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Flight Search</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class='sidebar'>\r\n");
      out.write("\t\t<a id=\"Login\" href=\"");
      out.print(session.getAttribute("nUserID") != null ? "./Login" : "Logout");
      out.write("\">\r\n");
      out.write("\t\t");
      out.print(session.getAttribute("nUserID") != null ? "Logout" : "Login");
      out.write("\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<a href=\"BookingHistory.jsp\"><button>Booking History</button></a> \r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class='main'>\r\n");
      out.write("\t\t<p class=\"PageTitle\">Flight Search</p>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<form name=\"SearchFlights\" action='FlightSearchResults.jsp' method=get>\r\n");
      out.write("\t\t\t<table width=600>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<TD>Flight Source:</td><td> <input type=\"text\" name=\"sSource\"></TD>\r\n");
      out.write("\t\t\t\t\t<td>Flight Destination:</td><td>  <input type=\"text\" name=\"sDestination\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Date of Travel: </td><td> <input type=\"text\" name=\"sDate\"></td>\r\n");
      out.write("\t\t\t\t\t<td>Number of Seats: </td><td> <input type=\"text\" name=\"nSeats\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>Class:</td>\r\n");
      out.write("\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t<select name=\"class\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"first\">First Class</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"business\">Business</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"economy\">Economy</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<input type=\"submit\" value=\"Search\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
