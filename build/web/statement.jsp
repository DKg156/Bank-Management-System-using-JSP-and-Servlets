<%-- 
    Document   : statement
    Created on : Mar 15, 2021, 7:35:15 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

<%

                                    String acno=(String)session.getAttribute("sess");
                                    int l=0;
                                         try{
                                                                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                                                                        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/project","dhruv","dhruv");
                                                            PreparedStatement stmt = con.prepareStatement("select * from month where acno=?");
                                                            stmt.setString(1,acno);
                                                            ResultSet datars =stmt.executeQuery();
                                                          //  ResultSetMetaData rsmt=datars.getMetaData();
                                                           // l=rsmt.getColumnCount();
                                                            out.println("<table border='1' bordercolorlight='#CCCC99' bordercolordark='#999966'><tr>");
                                                            out.println("<td><b><i>");
                                                            
                                              out.println("DATE"); out.println("<td>");
                                               out.println("BALANCE"); out.println("<td>");
                                                out.println("TRANSACTION_TYPE");  out.println("<td>");     
                                                 out.println("AMOUNT");
                                                  
                                                            out.println("</i></b></font></td></tr>");
                                                            while(datars.next()){
                                                            out.println("<tr>");
                                                            
                                              out.println("<td><font face='Arial, Helvetica'>");
                                              out.println(datars.getString(1)); out.println("<td>");
                                              out.println(datars.getInt(2)); out.println("<td>");
                                              out.println(datars.getString(4)); out.println("<td>");
                                              out.println(datars.getInt(5));
                                              out.println("</font></td>");
                                              
                                                                        
                                                            }
                                                            
                                         }
                                                            catch(Exception e1){
                                                                System.out.println(e1);
                                                            }     
%>
<div style="position: absolute; bottom: 10px "><a href="user.jsp">Back to Home</a></div>
    </body>
</html>
