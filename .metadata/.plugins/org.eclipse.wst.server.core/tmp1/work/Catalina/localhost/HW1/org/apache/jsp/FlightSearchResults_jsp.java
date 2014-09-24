package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import flight.bizlogic.RecordFactory;

public final class FlightSearchResults_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Flight Search Results</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"sidebar\">\r\n");
      out.write("\t\t<a id=\"login\" href=\"login.jsp\">\r\n");
      out.write("\t\t");
      out.print(session.getAttribute("nUserID") != null ? "Logout" : "Login");
      out.write("\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t");
  //get the records
		RecordFactory records = new RecordFactory(0);
	  	records.generateRecords();
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main\">\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<br><br>\r\n");
      out.write("\t\t<p class=\"PageTitle\">Flight Search Results</p>\r\n");
      out.write("\t\t<p class=\"subheading\"><b>");
      out.print(records.TotalRecords() );
      out.write("</b> Results Found</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<TR>\r\n");
      out.write("\t\t\t\t<th>Flight ID</th>\r\n");
      out.write("\t\t\t\t<th>Date</th>\r\n");
      out.write("\t\t\t\t<th>Departure Time</th>\r\n");
      out.write("\t\t\t\t<th>Arrival Time</th>\r\n");
      out.write("\t\t\t\t<th>Number of Stops</th>\r\n");
      out.write("\t\t\t\t<th>Cost</th>\r\n");
      out.write("\t\t\t\t<th>Additional Details</th>\r\n");
      out.write("\t\t\t</TR>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t");
for (int i = 0; i<records.TotalRecords(); i++){
      out.write("\r\n");
      out.write("\t\t\t<tr class='");
      out.print( i % 2 == 1 ? "repeatalt" : "repeat" );
      out.write("'>\r\n");
      out.write("\t\t\t");
      out.print(records.toHTMLTableRow(i) );
      out.write("\r\n");
      out.write("\t\t\t\t<td class=\"button\">\r\n");
      out.write("\t\t\t\t\t<a href=\"ViewAndBook.jsp\"><button>View and Book</button></a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
