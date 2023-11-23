<%-- 
    Document   : edit
    Created on : Mar 16, 2021, 6:32:59 PM
    Author     : dhruv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
   
<%
String acc=request.getParameter("ac");
int res=Integer.parseInt(request.getParameter("update"));


if(res==1)
{ out.println("<form action='NewName' method = 'post'>");
out.println("Enter the Account no"+"<input type='text' name='ac'>");
out.println("Enter name");
out.println("<input type='text' name='name'>");
out.println("<input type='submit' value='Update'>"+ "</form>");
}
else if(res==2)
{ out.println("<form action='NewPass' method = 'post'>");
out.println("Enter the Account no"+"<input type='text' name='ac'>");
out.println("Enter password");
out.println("<input type='text' name='pass'>");
out.println("<input type='submit' value='Update'>"+ "</form>");
}
else 
{out.println("<form action='NewType' method = 'post'>");
out.println("Enter the Account no"+"<input type='text' name='ac'>");
out.println("Choose type");
out.println("<input type='radio' name='type' value='Savings'/>"+"Savings"+"<input type='radio' name='type' value='Current'/>"+"Current");
out.println("<input type='submit' value='Update'>"+ "</form>");
}

%>


  </body>

</html>

