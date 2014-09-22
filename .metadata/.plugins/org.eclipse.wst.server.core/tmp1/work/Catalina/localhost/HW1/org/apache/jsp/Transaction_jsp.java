package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.*;

public final class Transaction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/FlightStyles.css\">\r\n");
      out.write("<title>Transaction</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<a id=\"login\" href=\"login.jsp\">\r\n");
      out.print(session.getAttribute("nUserID") != null ? "Logout" : "Login");
      out.write("\r\n");
      out.write("</a>\r\n");
      out.write("\r\n");

	RecordFactory records = new RecordFactory(1);
	FlightRecord r = records.TestRecord();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<p class='PageTitle'>Transactions</p>\r\n");
      out.write("<p class='subheading'>Flight Information:</p>\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Flight Number: </td><td>");
      out.print(r.getID() );
      out.write("</td>\r\n");
      out.write("\t\t<td>Flight Date: </td><td>");
      out.print(r.getDateOfTravel() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Departure Time:</td><td>");
      out.print(r.getDepartureTime() );
      out.write("</td>\r\n");
      out.write("\t\t<td>Arrival Time:</td><td>");
      out.print(r.getArrivalTime() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>Number of Stops:</td><td>");
      out.print(r.getNumberOfStops() );
      out.write("</td>\r\n");
      out.write("\t\t<td></td><td></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<br>\r\n");
      out.write("<p>Cost: ");
      out.print(r.getCost() );
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("<p class='subheading'>Payment Information:</p>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\t<form action='TransactionConfirmation.jsp' method=post>\r\n");
      out.write("\t\tAccount Holder's Name: <input type=\"text\" name=\"sAcctName\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tRouting Number: <input type=\"text\" name=\"nRoutingNumber\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\tAccount Number: <input type=\"text\" name=\"nAccountNumber\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"Confirm\"></input>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<a href=\"FlightSearch.jsp\"><button>Cancel</button></a>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
