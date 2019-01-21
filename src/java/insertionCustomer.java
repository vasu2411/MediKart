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
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/insertionCustomer"})
public class insertionCustomer extends HttpServlet {

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
            out.println("<title>Servlet insertionCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
            String fname=request.getParameter("fname").toLowerCase();
            String lname=request.getParameter("lname").toLowerCase();
            String email=request.getParameter("email");
            String uname=request.getParameter("uname");
            String password=request.getParameter("upass");
            String encryptedPassword = encrypt(password);
            String confpassword=request.getParameter("ucpass");
            String date=request.getParameter("dob");
            String mobileno=request.getParameter("mob");
            String what = request.getParameter("b1");
            if(what.equals("cancel"))
            {
                RequestDispatcher dd = request.getRequestDispatcher("index.html");
                dd.forward(request, response);
            }
            else
            {
                if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || uname.isEmpty() || password.isEmpty() || confpassword.isEmpty()
                        || date.isEmpty() || mobileno.isEmpty())
                {
                    String message = "One or more field was Empty. please, fill all the field properly.";
                    request.getSession().setAttribute("message", message);
                    RequestDispatcher dd = request.getRequestDispatcher("errorRegisterCustomer.jsp");
                    dd.forward(request, response);
                }
                int flagEmail=0,flagUserName=0,flagMobile=0;
                dbConnection dbc = new dbConnection();
                Connection cn = dbc.createConnection();
                Statement st = null;       
                try {
                    st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                } catch (Exception ex) {
                    Logger.getLogger(insertionCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }                     
                String query="select * from customers";
                ResultSet rs;
                try {
                        rs = st.executeQuery(query);
                        while(rs.next())
                        {
                            String em = rs.getString("emai_id");
                            String un = rs.getString("user_name");
                            String mn = rs.getString("mob");
                            if(em.equals(email))
                            {
                                flagEmail=1;
                            }
                            if(un.equals(uname))
                            {
                                flagUserName=1;
                            }
                            if(mn.equals(mobileno))
                            {
                                flagMobile=1;
                            }
                        }
                        st.close();
                        cn.close();
                    } catch (Exception ex) {
                        Logger.getLogger(insertionCustomer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                if(password.equals(confpassword) && flagEmail==0 && flagUserName==0 && flagMobile==0)
                {
                    try
                    {  
                        cn = dbc.createConnection();
                        PreparedStatement stmt=cn.prepareStatement("insert into customers values(?,?,?,?,?,?,?)");  
                        stmt.setString(1,fname);  
                        stmt.setString(2,lname);
                        stmt.setString(3,email);
                        stmt.setString(4,uname);
                        stmt.setString(5,encryptedPassword);
                        stmt.setString(6,date);
                        stmt.setString(7,mobileno);
                        stmt.executeUpdate();  
                        cn.close(); 
                        out.println("<h1>Registered Successfully!!</h1>");
                    }
                    catch(Exception e)
                    { 
                        System.out.println(e);
                    }
                }
                else if(flagEmail==1)
                {
                    String message = "Email-id is already registered.";
                    request.getSession().setAttribute("message", message);
                    RequestDispatcher dd = request.getRequestDispatcher("errorRegisterCustomer.jsp");
                    dd.forward(request, response);
                }
                else if(flagUserName==1)
                {
                    String message = "Username is not available.";
                    request.getSession().setAttribute("message", message);
                    RequestDispatcher dd = request.getRequestDispatcher("errorRegisterCustomer.jsp");
                    dd.forward(request, response);
                }
                else if(flagMobile==1)
                {
                    String message = "Mobile number is already registered.";
                    request.getSession().setAttribute("message", message);
                    RequestDispatcher dd = request.getRequestDispatcher("errorRegisterCustomer.jsp");
                    dd.forward(request, response);
                }
                else
                {
                    out.println("Error");
                }
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

    private String encrypt(String password) 
    {
        char[] plain = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A',
            'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] cipher = {'q','r','s','w','x','t','v','p','o','z','u','n','y','d','e','h','j','k','m','l','i','c','g','f','b','a','Q',
            'R','S','W','X','T','V','P','O','Z','U','N','Y','D','E','H','J','K','M','L','I','C','G','F','B','A'};
        String encrypted="";
        for(int i=0;i<password.length();i++)
        {
            int flag=0;
            for(int j=0;j<52;j++)
            {
                if(plain[j]==password.charAt(i))
                {
                    encrypted+=cipher[j];
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                encrypted+=password.charAt(i);
            }
        }
        return(encrypted);
    }
}