/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vasus
 */
@WebServlet(urlPatterns = {"/yetToDeliverImgDisplay"})
public class yetToDeliverImgDisplay extends HttpServlet {

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
        try  {
            int id= Integer.parseInt(request.getParameter("ID"));
            dbConnection dbc = new dbConnection();
            Connection cn = dbc.createConnection();
            Statement st = null;
            try {
                ResultSet rs = null;
                PreparedStatement pst = null;
                String sql = "select * from ordersretailers where id=?";
                OutputStream os;
                Blob pic;
                pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                rs = pst.executeQuery();
                if (rs.next()) 
                {
                    System.out.println("Inside rs.next");
                    pic = rs.getBlob("image");
                    byte imgData[] = pic.getBytes(1, (int) pic.length());
                    response.setContentType("image/jpeg");
                    os = response.getOutputStream();
                    os.write(imgData);
                    os.flush();
                    os.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        catch (Exception e) {
                System.out.println(e.getMessage());
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
