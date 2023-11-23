<%-- 
    Document   : user
    Created on : Mar 14, 2021, 9:38:03 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body bgcolor="#ffcc66">
        <h1 align="left">Customer Home</h1>     
<p align="right" id="time"></p>
<%
String user=(String)session.getAttribute("user");
out.println("<center><h2>");
out.println("<font face ='Arial'COLOR=blue >");
out.println("Welcome "+user+"</h2></font>");
int bal=(Integer)session.getAttribute("bal");
out.println("<font size = 5>");
out.println("<b>Account balance: "+bal+"<br>");
out.println("</font>");
out.println("<font size = 5 face = 'Times' COLOR=green >");
String type=(String)session.getAttribute("type");
out.println(type);
String acc=(String)session.getAttribute("acc");
out.println(" Account "+acc);
out.println("</font></center><br>");
%>
<script>
var today = new Date();
document.getElementById("time").innerHTML = today;
</script>
<center>
    <form action="debit.html" method="post">
    <input type="submit" value="Withdraw from your account" style=" height:30px; width:200px" />
</form>
    <br>
<form action="credit.html" method="post">
    <input type="submit" value="Deposit to your account" style="height:30px; width:200px" />
</form>
    <br>
<form action="fundtransfer.html" method="post">
    <input type="submit" value="Fund Transfer" style="height:30px; width:200px" />
</form>
    <br>
<form action="statement.jsp" method="post">
    <input type="submit" value="Account Statement" style="height:30px; width:200px" />
</form>
<br>
<p align="bottom"><a href="logout.jsp">Logout</a></p>  
</center>
    </body>
</html>

