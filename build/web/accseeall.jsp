<%-- 
    Document   : accseeall
    Created on : Mar 16, 2021, 5:46:33 PM
    Author     : dhruv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See all</title>
    </head>
    <body>

<%

                                   
                                    int l=0;
                                         try{
                                                                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                                                                        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/project","dhruv","dhruv");
                                                            PreparedStatement stmt = con.prepareStatement("select * from bank");
                                                            
                                                            ResultSet datars =stmt.executeQuery();
                                                          //  ResultSetMetaData rsmt=datars.getMetaData();
                                                          //  l=rsmt.getColumnCount();
                                                            out.println("<table border='1' bordercolorlight='#CCCC99' bordercolordark='#999966'><tr>");
                                                            out.println("<td>");
                                                            
                                              out.println("ACNO");out.println("<td>");
                                               out.println("NAME");out.println("<td>");
                                                out.println("BALANCE");out.println("<td>");       
                                                 out.println("TYPE");
                                                  
                                                            out.println("</font></td></tr>");
                                                            while(datars.next()){
                                                            out.println("<tr>");
                                                            
                                              out.println("<td><font face='Arial, Helvetica'>");
                                              out.println(datars.getString(1));out.println("<td>");
                                              out.println(datars.getString(3));out.println("<td>");
                                              out.println(datars.getInt(4));out.println("<td>");
                                              out.println(datars.getString(5));
                                              out.println("</font></td>");
                                              
                                                                        
                                                            }
                                                            
                                         }
                                                            catch(Exception e1){
                                                                System.out.println(e1);
                                                            }     
%>
<div style="position: absolute; bottom: 10px "><a href="useradmin.jsp">Back to Home</a></div>
    </body>
</html>
