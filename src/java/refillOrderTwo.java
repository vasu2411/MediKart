/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
@WebServlet(urlPatterns = {"/refillOrderTwo"})
public class refillOrderTwo extends HttpServlet {

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
        try {
            int id = Integer.parseInt(request.getParameter("b1"));
            System.out.println("id in 2=" + id);
            dbConnection dbc = new dbConnection();
            Connection cn = dbc.createConnection();
            Statement st = null;
                st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select * from orders where id=" + id;
                ResultSet rs = st.executeQuery(query);
                String uname = null, address = null, locality = null, city = null, pincode = null, state = null, mobile = null;
                String date = new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());
                String time = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
                Blob image = null;
                //Blob image1 = null;
                while (rs.next()) {
                    uname = rs.getString("uname");
                    address = rs.getString("address");
                    locality = rs.getString("locality");
                    city = rs.getString("city");
                    pincode = rs.getString("pincode");
                    state = rs.getString("state");
                    mobile = rs.getString("mobile");
                    image = rs.getBlob("image");
                }
                
                int count = 1;
                st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                query = "select * from dupliorders";
                rs = st.executeQuery(query);
                while (rs.next()) {
                    count += 1;
                }
                PreparedStatement ps;
                ps = cn.prepareStatement("insert into dupliorders values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setInt(1, count);
                ps.setString(2, uname);
                ps.setString(3, address);
                ps.setString(4, locality);
                ps.setString(5, city);
                ps.setString(6, pincode);
                ps.setString(7, state);
                ps.setString(8, mobile);
                ps.setString(9, date);
                ps.setString(10, time);
                ps.setBlob(11, image);
                ps.execute();
                ps.close();
                st.close();
                cn.close();
                RequestDispatcher dd = request.getRequestDispatcher("successRefillOrder.jsp");
                dd.forward(request, response);
        }
        catch(Exception e)
        {
            System.out.println("exception = "+e.getMessage());
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
