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
    <title>Insurance Gig</title>
    <link rel="shortcut icon" href="images/favicon.png" />
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/icons.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 8]><!-->
    <link rel="stylesheet" href="ie7/ie7.css">
    <!--<![endif]-->
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="./js/contact.js"></script>
</head>

<body data-spy="scroll" data-target=".navbar-fixed-top">
    <%@ include file ="header.jsp" %>

    <div class="clear"></div>
    <div id="page-content">
        <section class="breadcrumb">
            <div class="container">
                <h2>Contact Us</h2>
                <ul>
                    <li><a href="home">Home</a> ></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </div>
        </section>
        <section class="contact-us">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="form-box">
                            <h2>Get in Touch</h2>
                            <div class="form-content">
                                <input type="text" id="name" name="name" placeholder="Your Name" />
                                <input type="text" id="email" name="email" placeholder="Email" />
                                <input type="text" id="subject" name="subject" placeholder="Subject" />
                                <textarea rows="1" cols="1" id="message" name="message" placeholder="Message"></textarea>
                                <div class="text-center">
                                    <input type="submit" id="submit-button" class="btn-default" value="Submit" />
                                </div>
                            </div>
                        </div>
                        <div class="contact-info">
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="contact-address">
                                        <h3>Address</h3>
                                        <div>
                                            <i class="icon ti-home"></i>
                                            <p>E104 Dharti -2 , Nr Silverstar Mall
                                                <br/>Chandlodia - Ahmedabad
                                                <br/>Zip - 382481</p>
                                            <p class="social">
                                                <a href="#"><i class="fa fa-facebook"></i></a>
                                                <a href="#"><i class="fa fa-twitter"></i></a>
                                                <a href="#"><i class="fa fa-google-plus"></i></a>
                                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <div class="contact-dtl">
                                        <h3>Contact Details</h3>
                                        <div>
                                            <i class="icon fa fa-phone"></i>
                                            <p>+91 123 456 7890</p>
                                        </div>
                                        <div>
                                            <i class="icon ti-email"></i>
                                            <p><a href="#">info@bootstrapmart.com</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="contact-map">
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d235013.52897217585!2d72.43965449510691!3d23.02060002135479!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x395e848aba5bd449%3A0x4fcedd11614f6516!2sAhmedabad%2C+Gujarat!5e0!3m2!1sen!2sin!4v1474053074398" width="100%" height="260" frameborder="0" style="border:0" allowfullscreen></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <div class="clear"></div>
    <%@ include file ="footer.jsp" %>

    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>
