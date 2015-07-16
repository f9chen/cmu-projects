<%-- 
    Document   : index
    Created on : Jan 17, 2012, 8:16:30 PM
    Author     : Fan Chen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="store.*" %>

<?xml version="1.0" encoding="utf-8"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
        <link rel="stylesheet" type="text/css" href="cart.css"/>
        <script type="text/javascript" language="javascript" src="ajax.js"></script>
        <script type="text/javascript" language="javascript" src="cart.js"></script>
        
        <script type="text/javascript" language="javascript" src="json_sans_eval.js"></script>
    </head>
    <body>
        <!-- the item list in store -->
        <div class="catalog">
            <h2>Catalog</h2>
            <table class="itemListTable">
                <thead class="itemListTableHead">
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Add</th>
                    <th>Remove</th>
                </thead>
                <tbody>
                    <%
                    for (Iterator<Item> I = new Catalog().getAllItems().iterator(); I.hasNext(); ){
                        Item item = I.next();
                    %>
                    <tr>
                        <td class="itemListTableBody"><%= item.getName() %></td>
                        <td class="itemListTableBody"><%= item.getDescription() %></td>
                        <td class="itemListTableBody"><%= item.getFormattedPrice() %></td>
                        <td class="itemListTableButton"><button onclick="addToCart('<%=item.getCode()%>')">Add to Cart</button></td>
                        <td class="itemListTableButton"><button onclick="removeFromCart('<%=item.getCode()%>')">Remove</button></td>
                    </tr>
                     <% } %> 
                </tbody>
            </table>
        </div>
         <!-- the item list in cart -->
        <div class="cartContents">
            <h2>Cart Contents</h2>
            <br>
            <ul id="contents" class="cartList"></ul>
            Total cost: <span id="total">$0.00</span>
        </div>
            
    </body>
</html>
