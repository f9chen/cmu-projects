<!-- @author fanc -->
<!-- your-course.html -->
<% String email=(String) request.getAttribute("email"); 
%>
<html>
    <head>
        <title>your-courses</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
            .sidebar-nav {
                padding: 9px 0;
            }
        </style>
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="Welcome">Instacram</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li><a href="YourCourses">Your courses</a></li>
                            <li><a href="BrowseCourses">Browse courses</a></li>
                            <li><a href="CreateCourse">Create a course</a></li>
                            <li><a href="SearchNote">Search Note</a></li>
                            <li><a href="Logoff">Log off!</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="container-fluid">
                <div class="row-fluid">
                    <% String message=(String) request.getAttribute("message"); 
          if (message==null) message="";%>
                    <%=message%>
                    <p> Hello!<%=email%>!</p>
                    <div class="hero-unit">
                        <div class="row">
                            <div class="span4">

                                <h3>Your courses!</h3>
                                <hr>
                                <p>All</p>
                                <p>


                                    <% String courseList=(String) request.getAttribute("courseList"); 

                                      if (courseList == null) {
                                      courseList = "";
                                      }%>
                                    <%=courseList%>
                                </p>
                            </div><!--/span-->        
                            <div class="span7">
                                <form action="CreateNote" method=GET>
                                    <p>Enter a course note for
                                        <% String courseListSelect = (String) request.getAttribute("courseListSelect");
                    if(courseListSelect == null) courseListSelect="";%>
                                        <%= courseListSelect%>

                                        <input class="span11" name="noteContent" type='text'><br>
                                        <input name="email" type="hidden" value=<%=email%> />
                                    <p> <input type="submit" class="btn" value="Post Note &raquo;"</input></p>
                                </form>
                                <hr>
                                <h4>All course notes</h4>
                                <p>
                                    <% String notes = (String)request.getAttribute("notes");
                        if(notes==null) notes=""; %>
                                    <%=notes%>
                                </p>

                            </div><!--/span-->
                        </div><!--/row--> 
                    </div><!--/row-->
                </div><!--/row--> 
            </div><!--/row-->
            <footer> <p>
                    &copy; 2012 - <b>Fan Chen</b>, Carnegie Mellon University
                </p></footer>
        </div><!--/.fluid-container-->
    </body>
</html>
