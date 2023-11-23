<%-- 
    Document   : fundtransfer
    Created on : Mar 15, 2021, 9:59:16 PM
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
int am=Integer.parseInt(amount);
int bal=0; 
int balnew= 0;
String acnt=request.getParameter("ac");
int acnew=Integer.parseInt(acnt);
String acnt1 = (String)session.getAttribute("acc");
int acold=Integer.parseInt(acnt1);

String typenew="Credit";
String typeold="Debit";
Calendar calendar = new GregorianCalendar();
            String dor =String.valueOf(calendar.get(Calendar.DATE))+"/"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+String.valueOf(calendar.get(Calendar.YEAR));
try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");  
             java.sql.Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/project","dhruv","dhruv"); 
              PreparedStatement newst=con.prepareStatement("select balance from bank where acno = ?");  
                newst.setString(1,acnt);  
                ResultSet newrs=newst.executeQuery();
                if(newrs.next())
                {  balnew = newrs.getInt(1); }
                else throw new SQLException();
             
             if(acnew==acold)
                  {   out.println("Sorry, cannot transfer to self. Enter a different account."); 
                      throw new SQLException();  
                  }
             PreparedStatement stmtp=con.prepareStatement("select balance from bank where acno = ?");  
              stmtp.setString(1,acnt1);  
              ResultSet rs=stmtp.executeQuery();
                if(rs.next())
                {  bal = rs.getInt(1); }
                else throw new SQLException();
                  bal = bal - am ;
                  if(bal<0) {out.println("Sorry, insufficient funds..");}
                  else{
                  PreparedStatement stmtp2=con.prepareStatement("update bank set balance = ? where acno = ?");
                  stmtp2.setInt(1,bal);  
                  stmtp2.setString(2,acnt1);  
                  int i=stmtp2.executeUpdate();
                  
                
                 balnew = balnew + am ;
                 
                 PreparedStatement stmtp3=con.prepareStatement("update bank set balance = ? where acno = ?");
                  stmtp3.setInt(1,balnew);  
                  stmtp3.setString(2,acnt);  
                  int k = stmtp3.executeUpdate();
                  
                  PreparedStatement stmtp4=con.prepareStatement("select * from bank where acno = ?");  
                   stmtp4.setString(1,acnt);  
                  ResultSet rs2=stmtp4.executeQuery();
                  while(rs2.next())
                  { out.println("Successfully transferred to :<br>");
                   out.println("Acc. no: "+rs2.getString("acno")+"\n"+"Name: "+rs2.getString("name")+"\n"+"Acc Type: "+rs2.getString("type")+"<br>"); }
                   out.println("Your account is debited by "+am ); 
                   
                   session.setAttribute("bal",bal);
                   
                    PreparedStatement pstmt1 = con.prepareStatement("insert into month values(?,?,?,?,?)");
                        pstmt1.setString(1,dor);
                        pstmt1.setInt(2,bal);
                        pstmt1.setString(3,acnt1);
                        pstmt1.setString(4,typeold);
                        pstmt1.setInt(5,am);
                      int i1 = pstmt1.executeUpdate();
                      
                      PreparedStatement pst = con.prepareStatement("insert into month values(?,?,?,?,?)");
                        pst.setString(1,dor);
                        pst.setInt(2,balnew);
                        pst.setString(3,acnt);
                        pst.setString(4,typenew);
                        pst.setInt(5,am);
                      int m = pst.executeUpdate();
                   con.close(); }
                   }catch(Exception ex){ 
                      out.println("Sorry, an exception occured.."); 
                      System.out.println(ex); }

%>
<br><br>
<a href="user.jsp">Back to Home</a>
  </body>

</html>
