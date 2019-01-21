<%-- 
    Document   : adminPendingRetailers
    Created on : 12 Apr, 2017, 1:50:30 PM
    Author     : vasus
--%>

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

        <title>Pending retailers</title>

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
                    <a class="navbar-brand page-scroll" href="admin.jsp" style="color: black;">Medicart.com</a>
                </div>		
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="page-scroll" href="admin.jsp" style="color: black;">Home</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="adminPendingRetailers.jsp" style="color: black;">Pending retailers</a>
                        </li>
                        <li>
                            <a class="page-scroll" href="logout" style="color: black;">Logout</a>
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
            <form action="approveRetailer" method="post">
            <table class="table">
                <tr>
                    <th>
                        <center>First name</center>
                    </th>
                    <th>
                    <center>Last name</center>
                    </th>
                    <th>
                    <center>Email id</center>
                    </th>
                    <th>
                    <center>User name</center>
                    </th>
                    <th>
                    <center>Date of birth</center>
                    </th>
                    <th>
                    <center>Qualification</center>
                    </th>
                    <th>
                    <center>Address</center>
                    </th>
                    <th>
                    <center>Locality</center>
                    </th>
                    <th>
                    <center>Pincode</center>
                    </th>
                    <th>
                    <center>City</center>
                    </th>
                    <th>
                    <center>State</center>
                    </th>
                    <th>
                    <center>Country</center>
                    </th>
                    <th>
                    <center>Mobile number</center>
                    </th>
                    <th>
                    <center>Approve</center>
                    </th>
                </tr>
                <%
                    dbConnection dbc = new dbConnection();
                    Connection cn = dbc.createConnection();
                    Statement st;
                    try {
                        st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        String query = "select * from pendingretailers";
                        //out.println(query);
                        ResultSet rs;
                        rs = st.executeQuery(query);
                        //int counter = 1;
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String firstname = rs.getString("first_name");
                            String lastname = rs.getString("last_name");
                            String emailid = rs.getString("email_id");
                            String username = rs.getString("user_name");
                            String dob = rs.getString("dob");
                            String qualification = rs.getString("qualification");
                            String address = rs.getString("address");
                            String locality = rs.getString("locality");
                            String pincode = rs.getString("pincode");
                            String city = rs.getString("city");
                            String state = rs.getString("state");
                            String country = rs.getString("country");
                            String mob = rs.getString("mob");
                %>
                <tr>
                    <td>
                        <center><% out.println(firstname); %>
                    </td>
                    <td>
                        <center><% out.println(lastname); %>    
                    </td>
                    <td>
                        <center><% out.println(emailid); %>
                    </td>
                    <td>
                        <center><% out.println(username); %>
                    </td>
                    <td>
                        <center><% out.println(dob); %>
                    </td>
                    <td>
                        <center><% out.println(qualification); %>
                    </td>
                    <td>
                        <center><% out.println(address); %>
                    </td>
                    <td>
                        <center><% out.println(locality); %>
                    </td>
                    <td>
                        <center><% out.println(pincode); %>
                    </td>
                    <td>
                        <center><% out.println(city); %>
                    </td>
                    <td>
                        <center><% out.println(state); %>
                    </td>
                    <td>
                        <center><% out.println(country); %>
                    </td>
                    <td>
                        <center><% out.println(mob); %>
                    </td>
                    <td>
                        <center><button type="submit" value="<%= id %>" name="b1">Approve</button>
                    </td>
                </tr>
                <%
                    }
                        st.close();
                        cn.close();
                    }
                    catch(Exception e)
                    {
                        out.println(e.getMessage().toString());
                    }
                %>
            </table>
            </form>
        </div>
    </center>
</form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
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