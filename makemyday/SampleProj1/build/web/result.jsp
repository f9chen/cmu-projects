<%--
    Document   : index
    Created on : Feb 3, 2012, 8:22:31 PM
    Author     : Fan Chen
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>DS Proj1 Task4 Result Page</title>
    </head>
    <body>
        <p>Here is the rail map of city: <%= request.getAttribute("cityTag")%></p><br>
        <a href="<%= request.getAttribute("websiteURL")%>"><img <%= request.getAttribute("pictureURL")%> width="500" height="500"></a><br><br>
         <form action="UrbanRailServlet" method="GET">
            <label for="letter">Type another city.</label>
            <input type="text" name="search" value="" /><br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
