<%--
    Document   : index
    Created on : Feb 3, 2012, 8:22:31 PM
    Author     : Fan Chen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DS Proj1 Task4 Prompt Page</title>
    </head>
    <body>
        <p>Give me a city name, and I'll give you the metro map of it (hopefully).</p>
        <form action="UrbanRailServlet" method="GET">
            <p>Type the city name:</p>
            <p><input type="text" name="search" value="" /></p>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
