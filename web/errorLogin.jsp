<%-- 
    Document   : errorLogin
    Created on : 30 Mar, 2017, 8:58:52 PM
    Author     : vasus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>oops!!</title>

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
<body>
<section class="bg-primary" id="order">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <center><h2>Welcome back to Medikart</h2><br></center>
                    <center>
                        <div class="btn-group bsize">
                            <a href="customerLogin.jsp" class="btn btn-primary active">Customer</a>
                            <a href="retailerLogin.jsp" class="btn btn-primary">Retailer</a>
                        </div></center><br>
                        <form action="whatToDo" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" id="uname" placeholder="Username" name="uname">
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="password" class="form-control" id="upwd" placeholder="Password" name="upass">
                            </div>
                            <br>
                            <div class="alert alert-danger">
                                <strong>Please enter correct username and password and also, it must be not empty.</strong> 
                            </div><br>
                            <center>
                            <div class="btn-group-lg btn-group-horizontal">
                                <button type="submit" id="pre-reading-btn" class="btn btn-default" value="login" name="b1">Login</button>
                                <button type="submit" id="passage-btn" class="btn btn-default" value="signupCustomer" name="b1">Signup</button>
                            </div><br>
                            <div class="btn-group-lg btn-group-horizontal">
                                <button type="submit" id="post-reading-btn" class="btn btn-default" value="cancel" name="b1">Cancel</button>
                            </div>
                        </form><br><br><br><br>
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