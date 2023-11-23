<%-- 
    Document   : useradmin
    Created on : Mar 16, 2021, 2:10:48 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
    </head>
    <body bgcolor="#ccffcc">
        <h1 align="left">Admin Home</h1>     
<p align="right" id="time"></p>
<%
String user=(String)session.getAttribute("sess");
out.println("<center><h2>");
out.println("<font face ='Arial'COLOR=red >");
out.println("Welcome "+user+" (admin)</h2></font>");
out.println("<h3>Manage accounts</h3>");
out.println("</center><br>");
%>
<script>
var today = new Date();
document.getElementById("time").innerHTML = today;
</script>
<center>
    <form action="accseeall.jsp" method="post">
    <input type="submit" value="See all accounts" style=" height:30px; width:200px" />
</form>
    <br>
<form action="transseeall.jsp" method="post">
    <input type="submit" value="See all transactions" style="height:30px; width:200px" />
</form>
    <br>
    <form action="edit.html" method="post">
    <input type="submit" value="Edit account details" style=" height:30px; width:200px" />
</form>
    <br>
<form action="delete.html" method="post">
    <input type="submit" value="Delete an account" style="height:30px; width:200px" />
</form>
    <br>
<p align="bottom"><a href="logout.jsp">Logout</a></p>  
</center>
    </body>
</html>

