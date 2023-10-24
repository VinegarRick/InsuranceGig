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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="./js/application.js"></script>
    <style>
        .short-input {
            max-width: 200px;
        }

        .short-input[type="text"] {
            border: 1px solid #ccc;
            padding: 5px; 
        }

        .insurance-form {
            margin: 20px auto; 
            max-width: 400px; 
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
                    <a class="navbar-brand" href="home">
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
            <form id="application-form" method="post" class="insurance-form">
                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" id="firstName" name="firstName" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="lastName">Last Name:</label>
                        <input type="text" id="lastName" name="lastName" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="mobile">Mobile:</label>
                        <input type="tel" id="mobile" name="mobile" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="city">City:</label>
                        <input type="text" id="city" name="city" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="county">County:</label>
                        <input type="text" id="county" name="county" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="zipcode">Zipcode:</label>
                        <input type="text" id="zipcode" name="zipcode" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="dob">Date of Birth:</label>
                        <input type="date" id="dob" name="dob" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="gender">Gender:</label>
                        <select id="gender" name="gender" class="form-control short-input" required>
                            <option value="" disabled selected>Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="licenseNo">Driver's License Number:</label>
                        <input type="text" id="licenseNo" name="licenseNo" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="ssn">Social Security Number:</label>
                        <input type="text" id="ssn" name="ssn" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="vin">VIN:</label>
                        <input type="text" id="vin" name="vin" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="carYear">Model Year:</label>
                        <input type="number" id="carYear" name="carYear" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="carMake">Make of Car:</label>
                        <input type="text" id="carMake" name="carMake" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="carModel">Model of Car:</label>
                        <input type="text" id="carModel" name="carModel" class="form-control short-input" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="carMileage">Mileage:</label>
                        <input type="number" id="carMileage" name="carMileage" class="form-control short-input" required>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-6 form-group">
                        <label for="coveragePlan">Coverage Plans:</label>
                        <!--<select id="coveragePlan" name="coveragePlan" class="form-control short-input" required>
                            <option value="" disabled selected>Coverage</option>
                            <option value="liability">Liability</option>
                            <option value="collision">Collision</option>
                            <option value="comprehensive">Comprehensive</option>
                            <option value="uninsured">Uninsured</option>
                            <option value="medical">Medical</option>
                            <option value="assistance">Roadside Assistance</option>
                        </select>-->

                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="coveragePlan" id="liability" value="liability"> Liability
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="coveragePlan" id="collision" value="collision"> Collision
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="coveragePlan" id="comprehensive" value="comprehensive"> Comprehensive
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="coveragePlan" id="uninsured" value="uninsured"> Uninsured
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="coveragePlan" id="medical" value="medical"> Medical
                            </label>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="coveragePlan" id="assistance" value="assistance"> Roadside Assistance
                            </label>
                        </div>
                    </div>
                </div>

                <input type="submit" value="Submit" id="application-submit-button" class="btn btn-primary">
            </form>
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
                        <li><a href="home">Home</a></li>
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