/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dhruv
 */
public class New extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New Account</title>");            
            out.println("</head>");
            out.println("<body>");
            try{
                String n=request.getParameter("acc");
            String p=request.getParameter("pass");
            String name=request.getParameter("name");
            int bal = Integer.parseInt(request.getParameter("bal"));
            String type=request.getParameter("type");
            String cpass=request.getParameter("cpass");
                if(!p.equals(cpass))
                {   out.println("Passwords do not match. Try again ");
                   RequestDispatcher rd=request.getRequestDispatcher("newuser.html");
                   rd.include(request,response);
                }
                
                else {
             Class.forName("org.apache.derby.jdbc.ClientDriver");
             Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/project","dhruv","dhruv");
             
             PreparedStatement stmt2 = con.prepareStatement("insert into bank values(?,?,?,?,?)");
             stmt2.setString(1, n);
             stmt2.setString(2, p);
             stmt2.setString(3, name);
             stmt2.setInt(4, bal);
             stmt2.setString(5, type);
             int i = stmt2.executeUpdate();
             out.println("new account successfully created...");
             RequestDispatcher rd=request.getRequestDispatcher("newuser.html");
             rd.include(request,response);
             
                }
}
catch(Exception e){
out.println("<b>Could not create new account!!</b>");
RequestDispatcher rd=request.getRequestDispatcher("newuser.html");
rd.include(request,response);
}
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
