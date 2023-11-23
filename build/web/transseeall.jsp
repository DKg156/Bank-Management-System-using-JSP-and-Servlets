<%-- 
    Document   : transseeall
    Created on : Mar 16, 2021, 6:07:32 PM
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
                                                            PreparedStatement stmt = con.prepareStatement("select * from month");
                                                            
                                                            ResultSet datars =stmt.executeQuery();
                                                          //  ResultSetMetaData rsmt=datars.getMetaData();
                                                          //  l=rsmt.getColumnCount();
                                                            out.println("<table border='1' bordercolorlight='#CCCC99' bordercolordark='#999966'><tr>");
                                                            out.println("<td>");
                                                            
                                              out.println("DATE");out.println("<td>");
                                               out.println("ACNO");out.println("<td>");
                                                out.println("BALANCE");out.println("<td>");       
                                                 out.println("TRANSACTION_TYPE");out.println("<td>");   
                                                  out.println("AMOUNT");
                                                            out.println("</font></td></tr>");
                                                            while(datars.next()){
                                                            out.println("<tr>");
                                                            
                                              out.println("<td><font face='Arial, Helvetica'>");
                                              out.println(datars.getString(1));out.println("<td>");
                                              out.println(datars.getString(3));out.println("<td>");
                                              out.println(datars.getInt(2));out.println("<td>");
                                              out.println(datars.getString(4));out.println("<td>");
                                              out.println(datars.getInt(5));
                                              out.println("</font></td>");
                                              
                                                                        
                                                            }
                                                            
                                         }
                                                            catch(Exception e1){
                                                                System.out.println(e1);
                                                            }     
%>
    </body>
</html>
