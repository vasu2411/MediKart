/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

/**
 *
 * @author vasus
 */
@WebServlet(urlPatterns = {"/whatCustomerWants"})
public class whatCustomerWants extends HttpServlet {

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
            out.println("<title>Servlet whatCustomerWants</title>");            
            out.println("</head>");
            out.println("<body>");
            String act = request.getParameter("b1");
            if(act.equals("order"))
            {
                //String uname = request.getParameter("uname");
                String address = request.getParameter("address");
                String locality = request.getParameter("locality");
                String city = request.getParameter("city");
                String pincode = request.getParameter("pincode");
                String state = request.getParameter("state");
                String mob = request.getParameter("mobile");
                String date = new SimpleDateFormat("dd.MM.yyyy").format(new java.util.Date());
                String time= new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
                String photo = request.getParameter("order");
                HttpSession se = request.getSession(false);
                String uname = (String)se.getAttribute("uname");
                if(uname.isEmpty() || address.isEmpty() || locality.isEmpty() || city.isEmpty() || pincode.isEmpty() || state.isEmpty()
                        || mob.isEmpty() || photo.isEmpty() || date.isEmpty() ||  time.isEmpty())
                {
                    out.println(date);
                    out.println(time);
                    out.println("One or more field was Empty. please, fill all the field properly.");
                }
                else
                {
                    dbConnection dbc = new dbConnection();
                    Connection cn = dbc.createConnection();
                    try {
                        Statement st;
                        PreparedStatement ps;
                        int count=1;
                        st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String query="select * from orders";
                        ResultSet rs;
                        rs = st.executeQuery(query);
                        while(rs.next())
                        {
                            count+=1;
                        }
                        ps = cn.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setInt(1,count);
                        ps.setString(2, uname);
                        ps.setString(3, address);
                        ps.setString(4, locality);
                        ps.setString(5, city);
                        ps.setString(6, pincode);
                        ps.setString(7, state);
                        ps.setString(8, mob);
                        ps.setString(9, date);
                        ps.setString(10, time);
                        File file = new File("E:\\"+photo);
                        FileInputStream fis = new FileInputStream(file);
                        ps.setBinaryStream(11, fis, (int) file.length());
                        ps.execute();
                        
                        count=1;
                        st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        query="select * from dupliorders";
                        rs = st.executeQuery(query);
                        while(rs.next())
                        {
                            count+=1;
                        }
                        ps = cn.prepareStatement("insert into dupliorders values(?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setInt(1,count);
                        ps.setString(2, uname);
                        ps.setString(3, address);
                        ps.setString(4, locality);
                        ps.setString(5, city);
                        ps.setString(6, pincode);
                        ps.setString(7, state);
                        ps.setString(8, mob);
                        ps.setString(9, date);
                        ps.setString(10, time);
                        file = new File("E:\\"+photo);
                        fis = new FileInputStream(file);
                        ps.setBinaryStream(11, fis, (int) file.length());
                        ps.execute();
                        ps.close();
                        fis.close();
                        st.close();
                        cn.close();
                        RequestDispatcher dd = request.getRequestDispatcher("orderSuccess.jsp");
                        dd.forward(request, response);
                    } catch (Exception ex) {
                        out.println(ex.getMessage());
                    }
                }
            }
            else if(act.equals("myorders"))
            {
                //out.println("myorders");
                RequestDispatcher dd = request.getRequestDispatcher("myOrders.jsp");
                dd.forward(request, response);
            }
            else if(act.equals("refill"))
            {
                RequestDispatcher dd = request.getRequestDispatcher("refillOrder.jsp");
                dd.forward(request, response);
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
