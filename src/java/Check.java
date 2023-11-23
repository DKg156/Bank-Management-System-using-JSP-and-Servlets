
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dhruv
 */
public class Check extends HttpServlet {

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
        PrintWriter out=response.getWriter();
        String acno=request.getParameter("user");
        String pass=request.getParameter("pass");
        

            try{

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/project","dhruv","dhruv");
            PreparedStatement stmt1 = con.prepareStatement("select * from bank where acno = ?and pass=?");
            stmt1.setString(1, acno);
            stmt1.setString(2, pass);
           ResultSet rs = stmt1.executeQuery();
           if(rs.next())
           {
               
             if(rs.getString(1).equals(acno)&&rs.getString(2).equals(pass)){
              HttpSession session=request.getSession();
              session.setAttribute("sess",acno);
              String name=rs.getString("name");
              session.setAttribute("user",name);
              int bal=rs.getInt("balance");
              session.setAttribute("bal",bal);
              session.setAttribute("acc",acno);
              String type=rs.getString("type");
              session.setAttribute("type",type);
             RequestDispatcher rd=request.getRequestDispatcher("user.jsp");
             rd.forward(request,response);
             }
               
           }
            else
            { out.println("<br>");
             out.println("<center>");
             out.println("Sorry, account not found! Try again");
             out.println("</center>");
              RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
              rd.include(request, response);
            }

            }
        catch(Exception e){
             System.out.println(e) ;
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
