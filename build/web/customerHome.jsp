<%-- 
    Document   : customerHome
    Created on : 30 Mar, 2017, 9:03:23 PM
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

    <title>Home</title>

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
                <a class="navbar-brand page-scroll" href="#page-top">Medicart.com</a>
            </div>		
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#home">Home</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#order">Order</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#refill">Refill</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#myorders">my orders</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contactus">Contact US</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
	
    <header id="home">
        <div class="header-content">
            <div class="header-content-inner">
                <h1 id="homeHeading">Welcome to medikart.com!!!</h1>
                <hr>
                <p>Get your required medicines at your Doorstep.</p>
            </div>
        </div>
    </header>
	
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">At Your Service</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-plus-circle text-primary sr-icons"></i>
                        <h3>Order medicines</h3>
                        <p class="text-muted">Order medicines by uploading the prescription.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-reorder text-primary sr-icons"></i>
                        <h3>Medicine refills</h3>
                        <p class="text-muted">Refill medicines periodically.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-briefcase text-primary sr-icons"></i>
                        <h3>My orders</h3>
                        <p class="text-muted">Check your orders.</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="fa fa-4x fa-phone text-primary sr-icons"></i>
                        <h3>24*365 Services</h3>
                        <p class="text-muted">We are always ready to help you.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <form action="whatCustomerWants" method="post">
        <section class="bg-primary" id="order">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 text-center">
                        <h2 class="section-heading">ORDER</h2>
                        <hr class="light">
                        
                        <!--<input type="text" class="form-control" id="uname" placeholder="User name" name="uname"><br>-->
                        <input type="text" class="form-control" id="address" placeholder="Address" name="address"><br>
                        <input type="text" class="form-control" id="locality" placeholder="Locality" name="locality"><br>
                        <input type="text" class="form-control" id="city" placeholder="City" name="city"><br>
                        <input type="text" class="form-control" id="pincode" placeholder="Pincode" name="pincode"><br>
                        <input type="text" class="form-control" id="state" placeholder="State" name="state"><br>
                        <input type="text" class="form-control" id="mobile" placeholder="Contact number" name="mobile"><br>
                        <p class="text-faded">Upload prescription to order medicines.</p>
                        <div class="modal-body"> 
                            <center><input type="file" name="order" value="photo">                  
                        </div>
                        <div class="modal-center">
                            <button type="submit" id="pre-reading-btn" class="btn btn-default btn-xl sr-button" value="order" name="b1">Order</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>

       <section id="refill">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h2 class="section-heading">Refill medicines</h2>
                        <hr class="dark">
                        <div class="modal-center">
                            <button type="submit" id="pre-reading-btn" class="btn btn-danger btn-xl sr-button" value="refill" name="b1">Refill</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="bg-primary" id="myorders">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2 text-center">
                        <h2 class="section-heading">My Orders</h2>
                        <hr class="light">
                        <p class="text-faded">Check all orders till Today.</p>
                        <div class="modal-center">
                            <button type="submit" id="pre-reading-btn" class="btn btn-default btn-xl sr-button" value="myorders" name="b1">My orders</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>
    
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