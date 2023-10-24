<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Auto Insurance Gig</title>
    <link rel="shortcut icon" href="images/favicon.png" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/icons.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
    <link rel="stylesheet" type="text/css" href="css/flexslider.css " />
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css">
    <!--[if lt IE 8]><!-->
    <link rel="stylesheet" href="ie7/ie7.css">
    <!--<![endif]-->
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .circle {
            width: 70px;
            height: 70px;
            background-color: #555;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
            font-size: 24px;
        }

        .liability { background-color: #ff6347; }
        .collision { background-color: #66cdaa; }
        .comprehensive { background-color: #4169e1; }
        .uninsured { background-color: #ff69b4; }
        .medical { background-color: #f0e68c; }
        .assistance { background-color: #20b2aa; }

        .coverage-card {
            border: 1px solid #ccc;
            margin-bottom: 20px;
            min-height: 290px;
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
            padding: 25px;
        }

        .coverage-card h3 {
            margin-top: 10px;
        }

        .coverage-card p {
            font-size: 14px;
        }

        .top-bar {
            z-index: 999;
        }
    </style>
</head>

<body data-spy="scroll" data-target=".navbar-fixed-top">
    <header>
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 address">
                        <i class="ti-location-pin"></i> 2109 WS 09 Oxford Rd #127 ParkVilla Hills, MI 48334
                    </div>
                    <div class="col-sm-6 social">
                        <ul>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-facebook-square"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin-square"></i></a></li>
                            <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="index">
                        Auto Insurance<span>Gig</span>
                    </a>
                    <p>Call Us Now <b>+215 (362) 4579</b></p>
                </div>
                <div class="collapse navbar-collapse navbar-main-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="home">Home</a>
                        </li>
                        <li>
                            <a href="plans">Plans</a>
                        </li>
                        <li>
                            <a href="contact-us">Contact</a>
                        </li>
                        <li>
                            <c:choose>
                                <c:when test="${not empty username}">
                                    <a href="application" class="btn-default">Buy Auto Insurance</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/login" class="btn-default">Buy Auto Insurance</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li>
                            <c:choose>
                                <c:when test="${not empty username}">
                                    <a href="login?logout">Log Out</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/login">Log In</a>
                                    <li>
                                        <a href="#">Sign Up</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <div class="clear"></div>
    <div id="page-content">
        <div class="container text-center">
            <h2>Our Coverage Plans</h2><br>
            <div class="row">
                <div class="col-md-4">
                    <div class="coverage-card">
                        <div class="circle liability">
                            <i class="fa fa-car"></i>
                        </div><br>
                        <h3>Liability Coverage</h3>
                        <p>Liability coverage pays for the medical expenses and property damage of other parties in an accident.</p>
                        <p>Starting at $100 per month</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="coverage-card">
                        <div class="circle collision">
                            <i class="fa fa-wrench"></i>
                        </div><br>
                        <h3>Collision Coverage</h3>
                        <p>Collision coverage helps pay for the repair or replacement of your vehicle after an accident.</p><br>
                        <p>Starting at $75 per month</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="coverage-card">
                        <div class="circle comprehensive">
                            <i class="fa fa-tree"></i>
                        </div><br>
                        <h3>Comprehensive Coverage</h3>
                        <p>Comprehensive coverage covers non-collision-related damage, such as theft, vandalism, and natural disasters.</p>
                        <p>Starting at $90 per month</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="coverage-card">
                        <div class="circle uninsured">
                            <i class="fa fa-user-times"></i>
                        </div><br>
                        <h3>Uninsured Coverage</h3>
                        <p>Uninsured coverage protects you if you're in an accident with an uninsured or underinsured driver.</p>
                        <p>Starting at $25 per month</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="coverage-card">
                        <div class="circle medical">
                            <i class="fa fa-medkit"></i>
                        </div><br>
                        <h3>Medical Coverage</h3>
                        <p>Medical coverage helps pay for medical expenses, including hospital bills, in the event of an accident.</p>
                        <p>Starting at $30 per month</p>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="coverage-card">
                        <div class="circle assistance">
                            <i class="fa fa-life-ring"></i>
                        </div><br>
                        <h3>Roadside Assistance</h3>
                        <p>Roadside assistance provides help in case your vehicle breaks down or you need a tow.</p><br>
                        <p>Starting at $10 per month</p>
                    </div>
                </div>
            </div>
        </div>
        
    </div>

    <footer>
        <div class="container">
            <div class="row contact-sec">
                <div class="col-md-5 col-lg-5">
                    <h2>Insurance<span>Press</span></h2>
                    <div class="row">
                        <div class="col-sm-6">
                            <p>E104 Dharti -2 , Nr Silverstar Mall Chandlodia - Ahmedabad
                                <br/>Zip - 382481</p>
                        </div>
                        <div class="col-sm-6">
                            <ul>
                                <li><a href="#"><i class="fa fa-phone"></i> +91 123 456 7890</a></li>
                                <li><a href="#"><i class="ti-email"></i> info@bootstrapmart.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <a href="#" class="btn-default">Contact Us</a>
                </div>
                <div class="col-md-5 col-lg-5 col-md-offset-2 col-lg-offset-2">
                    <h2>Agent<span>Detail</span></h2>
                    <div class="row">
                        <div class="col-sm-6">
                            <p>E104 Dharti -2 , Nr Silverstar Mall Chandlodia - Ahmedabad
                                <br/>Zip - 382481</p>
                        </div>
                        <div class="col-sm-6">
                            <ul>
                                <li><a href="#"><i class="fa fa-phone"></i> +91 123 456 7890</a></li>
                                <li><a href="#"><i class="ti-email"></i> info@bootstrapmart.com</a></li>
                            </ul>
                        </div>
                    </div>
                    <a href="#" class="btn-default">Contact Agent</a>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-lg-8">
                    <ul class="footer-nav">
                        <li><a href="index">Home</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Compnies represented</a></li>
                        <li><a href="contact-us">Contact us</a></li>
                        <li><a href="#">Services</a></li>
                    </ul>
                </div>
                <div class="col-md-2 col-lg-2 col-md-offset-2 col-lg-offset-2">
                    <ul class="footer-social">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6">
                        Copyright &copy; 2018 distributed by <a href="https://themewagon.com/">ThemeWagon</a>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 text-right">
                        <a href="#">Terms & Conditions</a>
                        <a href="#">Policy</a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</body>

</html>