<%-- 
    Document   : successDelivered
    Created on : 16 Apr, 2017, 10:20:02 PM
    Author     : vasus
--%>

<%@page import="javax.swing.ImageIcon"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Orders yet to deliver</title>

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
                            <a class="page-scroll" href="retailerHome.jsp"  style="color: black;">Home</a>
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
        <div class="col-lg-8 col-lg-offset-2 text-center">
        <div class="alert alert-success ">
                            <strong>Successfully added to delivered orders. Check delivered Orders.</strong> 
                        </div>
        </div>
        <div class="container">
            <form action="deliverOrder" method="post">
                <table class="table table-hover">
                <tr>
                    <th><center>
                        Username
                    </th>
                    <th><center>
                        Address
                    </th>
                    <th><center>
                        Locality
                    </th>
                    <th><center>
                        City
                    </th>
                    <th><center>
                        Pincode
                    </th>
                    <th><center>
                        State
                    </th>
                    <th><center>
                        Mobile number
                    </th>
                    <th><center>
                        Date of order
                    </th>

                    <th><center>
                        Prescription
                    </th>
                    <th>
                        <center>
                            Delivered
                    </th>
                </tr>
                <%
                    HttpSession se = request.getSession(false);
                    String runame = (String) se.getAttribute("uname");
                    System.out.println("uname=" + runame);
                    dbConnection dbc = new dbConnection();
                    Connection cn = dbc.createConnection();
                    Statement st = null;
                    try
                    {
                        ImageIcon image;
                        st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String sta = "yet to deliver";
                        String query = "select * from ordersretailers where retailer_uname='"+runame+"' and status='"+sta+"'";
                        ResultSet rs;
                        rs = st.executeQuery(query);
                        int id;
                        String cuname=null,address=null,locality=null,city=null,pincode=null,state=null,mobile=null,date=null;
                        //Blob image1;
                        while(rs.next())
                        {
                            id=rs.getInt("id");
                            cuname=rs.getString("customer_uname");
                            address=rs.getString("address");
                            locality=rs.getString("locality");
                            city = rs.getString("city");
                            pincode = rs.getString("pincode");
                            state = rs.getString("state");
                            mobile = rs.getString("mobile");
                            date = rs.getString("date");
                            //image = rs.getBlob()  
                         %>
                <tr>
                    <td>
                        <center>
                        <%                            
                            out.println(cuname);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(address);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(locality);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(city);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(pincode);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(state);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(mobile);
                        %>
                    </td>
                    <td>
                        <center>
                        <%                            
                            out.println(date);
                        %>
                    </td>
                     
                    <td>
                        <center>
                            <img alt="prescription" width="320" height="200" src="yetToDeliverImgDisplay?ID=<%= id %>"> 
                    </td>
                    <td>
                        <center><button type="submit" value="<%= id %>" name="b1">Delivered</button>
                    </td>
                </tr>
                <%
                    }
                    st.close();
                    cn.close();
                }
                catch(Exception e)
                {
                    System.out.println("Exception="+e.getMessage());
                }
                %>         
            </table>
            </form>
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