package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class search_002dnote_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!-- @author fanc -->\r\n");
      out.write("<!-- your-course.html -->\r\n");
 String email=(String) request.getAttribute("email"); 

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>your-courses</title>\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("      body {\r\n");
      out.write("      padding-top: 60px;\r\n");
      out.write("      padding-bottom: 40px;\r\n");
      out.write("      }\r\n");
      out.write("      .sidebar-nav {\r\n");
      out.write("      padding: 9px 0;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <div class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("      <div class=\"navbar-inner\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <a class=\"btn btn-navbar\" data-toggle=\"collapse\" data-target=\".nav-collapse\">\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <a class=\"brand\" href=\"Welcome\">Instacram</a>\r\n");
      out.write("          <div class=\"nav-collapse collapse\">\r\n");
      out.write("            <ul class=\"nav\">\r\n");
      out.write("              <li><a href=\"YourCourses\">Your courses</a></li>\r\n");
      out.write("              <li><a href=\"BrowseCourses\">Browse courses</a></li>\r\n");
      out.write("              <li><a href=\"CreateCourse\">Create a course</a></li>\r\n");
      out.write("              <li><a href=\"Logoff\">Log off!</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row-fluid\">\r\n");
      out.write("          ");
 String message=(String) request.getAttribute("message"); 
          if (message==null) message="";
      out.write("\r\n");
      out.write("          ");
      out.print(message);
      out.write("\r\n");
      out.write("          <p> Hello!");
      out.print(email);
      out.write("!</p>\r\n");
      out.write("          <div class=\"hero-unit\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("              <div class=\"span4\">\r\n");
      out.write("\r\n");
      out.write("                <h3>Search for notes!</h3>\r\n");
      out.write("                <hr>\r\n");
      out.write("                <form action=\"SearchNote\" method=GET>\r\n");
      out.write("                <p>\r\n");
      out.write("                    search notes in\r\n");
      out.write("                 <select class=\"dropdown\" name=\"queryType\">\r\n");
      out.write("                     <option>courses you are enrolled</option>\r\n");
      out.write("                     <option>all courses</option>\r\n");
      out.write("                 </select>\r\n");
      out.write("                <input class=\"span11\" name=\"queryString\" type='text'><br>\r\n");
      out.write("                <input name=\"email\" type=\"hidden\" value=");
      out.print(email);
      out.write(" />\r\n");
      out.write("              <p> <input type=\"submit\" class=\"btn\" value=\"Search! &raquo;\"</input></p>\r\n");
      out.write("                   </form>\r\n");
      out.write("              </div><!--/span-->        \r\n");
      out.write("              <div class=\"span7\">\r\n");
      out.write("                 <p>\r\n");
      out.write("                ");
 String notes = (String)request.getAttribute("notes");
                        if(notes==null) notes=""; 
      out.write("\r\n");
      out.write("                        ");
      out.print(notes);
      out.write("\r\n");
      out.write("                 </p>\r\n");
      out.write("                \r\n");
      out.write("              </div><!--/span-->\r\n");
      out.write("            </div><!--/row--> \r\n");
      out.write("          </div><!--/row-->\r\n");
      out.write("        </div><!--/row--> \r\n");
      out.write("      </div><!--/row-->\r\n");
      out.write("      <footer> <p>\r\n");
      out.write("      &copy; 2012 - <b>Fan Chen</b>, Carnegie Mellon University\r\n");
      out.write("      </p></footer>\r\n");
      out.write("    </div><!--/.fluid-container-->\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
