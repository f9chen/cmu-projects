<!-- @author fanc -->
<!-- browse-courses.jsp -->
<% String email=(String) request.getAttribute("email"); 
%>

<html>
    <head>
        <title>browse-courses</title>
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
                    <a class="btn btn-navbar" data-toggle="collapse"
                       data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span>
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
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">
            <div class="container-fluid">
                <div class="row-fluid">
                    <% String message=(String) request.getAttribute("message"); 
          if (message==null) message="";%>
                    <%=message%>
                    <p>Hello!<%=email%>!</p>
                    <div class="hero-unit">
                        <div class="row">
                            <div class="span4">
                                <h3>All courses</h3>
                                <hr>
                                <p>
                                    <% String courseList=(String) request.getAttribute("courseList"); 
                                    if (courseList == null) {
                                    courseList = "";}%>
                                    <%=courseList%>
                                </p>
                            </div>
                            <!--/span-->
                            <div class="span7">
                                <p>
                                    <% String courseSelected = (String) request.getAttribute("courseSelected");
                                    String courseCreatedBy = (String) request.getAttribute("courseCreatedBy");
                                    if (courseSelected != null) {%>
                                    <%=courseSelected%>
                                    , created by <a href="#"> 
                                        <%=courseCreatedBy%></a>
                                </p>
                                <p>
                                <form action="JoinCourse" method="GET">
                                    <input type="hidden" name="courseSelected" value=<%=courseSelected%> />
                                    <input type="hidden" name="email" value=<%=email%> />
                                    <input type="submit" class="btn" value="Join <%=courseSelected%> &raquo;">
                                </form>
                                </p>
                                <%}%>
                                <hr>
                                <% String notes = (String) request.getAttribute("notes");
                if(notes == null) notes="";%>
                                <%=notes%>
                            </div>
                            <!--/span-->
                        </div>
                        <!--/row-->
                    </div>
                    <!--/row-->
                </div>
                <!--/row-->
            </div>
            <!--/row-->
            <footer>
                <p>
                    &copy; 2012 - <b>Fan Chen</b>, Carnegie Mellon University
                </p>
            </footer>
        </div>
        <!--/.fluid-container-->
    </body>


</html>
