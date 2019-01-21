<%-- 
    Document   : myOrders
    Created on : 11 Apr, 2017, 9:51:41 PM
    Author     : vasus
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="javax.swing.ImageIcon"%>
<%@page import="javax.websocket.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="sun.misc.BASE64Decoder"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>My orders</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

        <!-- Plugin CSS -->
        <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/creative.min.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body id="page-top">
        <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand page-scroll" href="#page-top" style="color: black;">Medicart.com</a>
                </div>		
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="page-scroll" href="customerHome.jsp"  style="color: black;">Home</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="logout"  style="color: black;">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <br>
        <br>
        <br>
    <center>
        <div class="container">
            <table class="table">
                <tr>
                    <th>
                <center>Serial number</center>
                    </th>
                    <th>
                    <center>Date</center>
                    </th>
                    <th>
                    <center>Prescription</center>
                    </th>
                </tr>
                <%
                     ImageIcon image;
                    dbConnection dbc = new dbConnection();
                    Connection cn = dbc.createConnection();
                    Statement st = null;
                    try {
                        st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        HttpSession se = request.getSession(false);
                        String uname = (String) se.getAttribute("uname");
                        //out.println(uname);
                        String query = "select * from orders where uname='" + uname + "'";
                        //out.println(query);
                        ResultSet rs;
                        rs = st.executeQuery(query);
                        int counter = 1;
                        while (rs.next()) {
                            String date = rs.getDate("date").toString();
                            int picId = rs.getInt("id");
                %>
                <tr>
                    <td>
                        <center>
                        <%                            
                            out.println(counter++);
                        %>
                        </center>
                    </td>
                    <td>
                        <center>
                        <%
                            out.println(date);
                        %>
                        </center>
                    </td>
                    <td>
                        <center>
                        <img alt="prescription" width="500" height="200" src="imgDisplay?ID=<%= picId %>"> 
                        </center>
                    </td>
                </tr>

                <%      }
                    } 
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    st.close();
                    cn.close();
                %>
            </table>
        </div>
    </center>
    <section id="contactus">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Contact us</h2>
                    <hr class="dark">
                    <p ><b>Vasu shah <br>
                            +91-94295 47654<br>
                            vasushah76@gmail.com</b><br>
                    </p>
                </div>
            </div>
        </div>
    </section>

    <section class="bg-primary">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h6>&copy; medicart.com 2016-17<br></h6>
                </div>
            </div>
        </div>
    </section>

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/creative.min.js"></script>

</body>

</html>