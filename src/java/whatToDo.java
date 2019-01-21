/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author vasus
 */
@WebServlet(urlPatterns = {"/whatToDo"})
public class whatToDo extends HttpServlet {

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
            out.println("<title>Servlet whatToDo</title>");            
            out.println("</head>");
            out.println("<body>");
            String uname = request.getParameter("uname");
            String upass = request.getParameter("upass");
            String act = request.getParameter("b1");
            if(act.equals("signupCustomer"))
            {
                RequestDispatcher dd = request.getRequestDispatcher("registerCustomer.jsp");
                dd.forward(request, response);
                //response.sendRedirect("registerCustomer.jsp");
            }
            else if(act.equals("signupRetailer"))
            {
                RequestDispatcher dd = request.getRequestDispatcher("registerRetailer.jsp");
                dd.forward(request, response);
                //response.sendRedirect("registerRetailer.jsp");
            }
            else if (act.equals("cancel")) {
                RequestDispatcher dd = request.getRequestDispatcher("index.html");
                dd.forward(request, response);
                //response.sendRedirect("index.html");
            }
            else if(uname.isEmpty() || upass.isEmpty())
            {
                RequestDispatcher dd = request.getRequestDispatcher("errorLogin.jsp");
                dd.forward(request, response);
                //response.sendRedirect("errorLogin.jsp");
            }
            else if(act.equals("loginRetailer"))
            {
                if(request.getParameter("uname").equals("admin") && request.getParameter("upass").equals("admin@Medikart.com"))
                {
                    RequestDispatcher dd = request.getRequestDispatcher("admin.jsp");
                    dd.forward(request, response);
                    //response.sendRedirect("admin.jsp");
                }
                else
                {
                    int flag=0;
                    //uname String username=request.getParameter("uname");
                    //upass String enterpass = request.getParameter("upass");
                    dbConnection dbc = new dbConnection();
                    Connection cn = dbc.createConnection();
                    Statement st = null;
                    try {
                        st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    String query="select * from registeredretailers";
                    ResultSet rs;
                    try {
                            rs = st.executeQuery(query);
                            while(rs.next())
                            {
                                String un = rs.getString("user_name");
                                String up = rs.getString("password");
                                String decryptedup = decrypt(up);
                                if(un.equals(uname) && decryptedup.equals(upass))
                                {
                                    HttpSession session = request.getSession();
                                    session.setAttribute("uname", un);
                                    RequestDispatcher dd = request.getRequestDispatcher("retailerHome.jsp");
                                    dd.forward(request, response);
                                    //response.sendRedirect("customerHome.jsp");
                                    flag=1;
                                }
                            }
                            if(flag==0)
                            {
                                RequestDispatcher dd = request.getRequestDispatcher("errorRetailerLogin.jsp");
                                dd.forward(request, response);
                                //response.sendRedirect("errorLogin.jsp");
                            }
                            st.close();
                            cn.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(whatToDo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            }
            else
            {
                if(request.getParameter("uname").equals("admin") && request.getParameter("upass").equals("admin@Medikart.com"))
                {
                    RequestDispatcher dd = request.getRequestDispatcher("admin.jsp");
                    dd.forward(request, response);
                    //response.sendRedirect("admin.jsp");
                }   
                else
                {
                    int flag=0;
                    //uname String username=request.getParameter("uname");
                    //upass String enterpass = request.getParameter("upass");
                    dbConnection dbc = new dbConnection();
                    Connection cn = dbc.createConnection();
                    Statement st = null;
                    try {
                        st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    } catch (SQLException ex) {
                        Logger.getLogger(whatToDo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String query="select * from customers";
                    ResultSet rs;
                    try {
                            rs = st.executeQuery(query);
                            while(rs.next())
                            {
                                String un = rs.getString("user_name");
                                String up = rs.getString("password");
                                String decryptedup = decrypt(up);
                                if(un.equals(uname) && decryptedup.equals(upass))
                                {
                                    HttpSession session = request.getSession();
                                    session.setAttribute("uname", un);
                                    RequestDispatcher dd = request.getRequestDispatcher("customerHome.jsp");
                                    dd.forward(request, response);
                                    //response.sendRedirect("customerHome.jsp");
                                    flag=1;
                                }
                            }
                            if(flag==0)
                            {
                                RequestDispatcher dd = request.getRequestDispatcher("errorLogin.jsp");
                                dd.forward(request, response);
                                //response.sendRedirect("errorLogin.jsp");
                            }
                            st.close();
                            cn.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(whatToDo.class.getName()).log(Level.SEVERE, null, ex);
                        }
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

    private String decrypt(String up) 
    {
        char[] plain = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A',
            'B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] cipher = {'q','r','s','w','x','t','v','p','o','z','u','n','y','d','e','h','j','k','m','l','i','c','g','f','b','a','Q',
            'R','S','W','X','T','V','P','O','Z','U','N','Y','D','E','H','J','K','M','L','I','C','G','F','B','A'};
        String decrypted = "";
        for(int i=0;i<up.length();i++)
        {
            int flag=0;
            for(int j=0;j<52;j++)
            {
                if(cipher[j]==up.charAt(i))
                {
                    decrypted+=plain[j];
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                decrypted+=up.charAt(i);
            }
        }
        return(decrypted);
    }
}