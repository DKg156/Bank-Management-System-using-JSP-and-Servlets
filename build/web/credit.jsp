<%-- 
    Document   : credit
    Created on : Mar 15, 2021, 4:52:40 PM
    Author     : dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
   
<%
String amount=request.getParameter("amnt");
int iamount=Integer.parseInt(amount);
int bal=0;
String acnt = (String)session.getAttribute("acc");

String type="Credit";
Calendar calendar = new GregorianCalendar();
            String dor =String.valueOf(calendar.get(Calendar.DATE))+"/"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+String.valueOf(calendar.get(Calendar.YEAR));
try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");  
             java.sql.Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/project","dhruv","dhruv"); 
              PreparedStatement stmtp=con.prepareStatement("select balance from bank where acno = ?");  
              stmtp.setString(1,acnt);  
              ResultSet rs=stmtp.executeQuery();
                if(rs.next())
                {  bal = rs.getInt(1); }
                else throw new SQLException();
                int dep = Integer.parseInt(amount);
                bal = bal + dep ;
                  PreparedStatement stmtp2=con.prepareStatement("update bank set balance = ? where acno = ?");
                  stmtp2.setInt(1,bal);  
                  stmtp2.setString(2,acnt);  
                  int i=stmtp2.executeUpdate();
                 
                  //PreparedStatement stmtp3=con.prepareStatement("select * from bank where acno = ?");  
                   //stmtp3.setString(1,acnt);  
                 // ResultSet rs2=stmtp3.executeQuery();
                 // while(rs2.next())
                 // {  out.println("Acc. no: "+rs2.getString("acno")+"\n"+"Name: "+rs2.getString("name")+"\n"+"Acc Type: "+rs2.getString("type")+"\n"+"Balance: "+rs2.getInt("balance")); }
                   out.println("Your account is credited with "+dep ); 
                   session.setAttribute("bal",bal);
                    PreparedStatement pstmt1 = con.prepareStatement("insert into month values(?,?,?,?,?)");
                        pstmt1.setString(1,dor);
                        pstmt1.setInt(2,bal);
                        pstmt1.setString(3,acnt);
                        pstmt1.setString(4,type);
                        pstmt1.setInt(5,iamount);
            int i1 = pstmt1.executeUpdate();
                   con.close();
                   }catch(Exception ex){ 
                      out.println("Sorry, an exception occured.."); 
                      System.out.println(ex); }

%>
<br><br>
<a href="user.jsp">Back to Home</a>
  </body>

</html>
