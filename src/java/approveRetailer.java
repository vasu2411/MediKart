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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vasus
 */
@WebServlet(urlPatterns = {"/approveRetailer"})
public class approveRetailer extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("b1"));
        System.out.println("id="+id);
        dbConnection dbc = new dbConnection();
        Connection cn = dbc.createConnection();
            Statement st = null;
            try {
                st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select * from pendingretailers where id="+id;
                ResultSet rs = st.executeQuery(query);
                String firstname = null, lastname = null, emailid = null, username = null, password = null, dob = null, 
                        qualification = null, address = null, locality = null, pincode = null, city = null, state = null, 
                        country = null, mob = null;
                while(rs.next())
                {
                    System.out.println("iddb="+rs.getInt("id"));
                    firstname = rs.getString("first_name");
                    lastname = rs.getString("last_name");
                    emailid = rs.getString("email_id");
                    username = rs.getString("user_name");
                    password = rs.getString("password");
                    dob = rs.getString("dob");
                    qualification = rs.getString("qualification");
                    address = rs.getString("address");
                    locality = rs.getString("locality");
                    pincode = rs.getString("pincode");
                    city = rs.getString("city");
                    state = rs.getString("state");
                    country = rs.getString("country");
                    mob = rs.getString("mob");
                    System.out.println(firstname + "<br>" + lastname + "<br>" + emailid + "<br>" + username + "<br>" + dob + "<br>" + qualification + "<br>"
                            + address + "<br>" + locality + "<br>" + pincode + "<br>" + city + "<br>" + state + "<br>" + country + "<br>" + mob);
                }
                String querys = "select * from registeredretailers";
                rs = st.executeQuery(querys);
                int count = 1;
                while (rs.next()) {
                    count += 1;
                }
                System.out.println("count"+count);
                PreparedStatement stmt = cn.prepareStatement("insert into registeredretailers values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setInt(1, count);
                stmt.setString(2, firstname);
                stmt.setString(3, lastname);
                stmt.setString(4, emailid);
                stmt.setString(5, username);
                stmt.setString(6, password);
                stmt.setString(7, dob);
                stmt.setString(8, qualification);
                stmt.setString(9, address);
                stmt.setString(10, locality);
                stmt.setString(11, pincode);
                stmt.setString(12, city);
                stmt.setString(13, state);
                stmt.setString(14, country);
                stmt.setString(15, mob);
                stmt.executeUpdate();
                String queryss = "delete from pendingretailers where id="+id;
                st.executeUpdate(queryss);
                st.close();
                stmt.close();
                cn.close();
                RequestDispatcher dd = request.getRequestDispatcher("adminPendingRetailers.jsp");
                dd.forward(request, response);
            } catch (Exception ex) {
                System.out.println("exception="+ex.getMessage());
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
