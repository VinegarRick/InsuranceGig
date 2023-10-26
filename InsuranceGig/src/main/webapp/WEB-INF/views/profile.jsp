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
    <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">-->
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
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="./js/profile.js"></script>
    <style>
        .form-select div {
            margin-top: 1px; 
            margin-left: 10px;
            border: 1px solid #f3f3f3;
        }

        .form-select > div > label {
            /*color: #888;*/
            color: #989898;
            opacity: 0.6; 
        }
    </style>
</head>

<body data-spy="scroll" data-target=".navbar-fixed-top">
    <%@ include file ="header.jsp" %>

    <div class="clear"></div>
    <div id="page-content">
        <div class="row">
            <div class="col-md-3">
                <!-- Table of Contents Bar -->
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#userInfo" data-toggle="tab">User Info</a></li>
                    <li><a href="#policyInfo" data-toggle="tab">Policy Info</a></li>
                    <li><a href="#paymentInfo" data-toggle="tab">Payment Info</a></li>
                    <li><a href="#appStatus" data-toggle="tab">Application Status</a></li>
                </ul>
            </div>
            <div class="col-md-9">
                <!-- Content Sections -->
                <div class="tab-content">
                    <!-- User Info Section -->
                    <div class="tab-pane fade in active" id="userInfo">
                        <h1>User Info</h1>
                        <span>Dummy user information goes here</span>
                    </div>

                    <!-- Policy Info Section -->
                    <div class="tab-pane fade" id="policyInfo">
                        <h1>Policy Info</h1>
                        <span>Dummy policy information goes here</span>
                    </div>

                    <!-- Payment Info Section -->
                    <div class="tab-pane fade" id="paymentInfo">
                        <h1>Payment Info</h1>
                        <span>Dummy payment information goes here</span>
                    </div>

                    <!-- Application Status Section -->
                    <div class="tab-pane fade" id="appStatus">
                        <h1>Application Status</h1>
                        <span>Dummy application status information goes here</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file ="footer.jsp" %>
</body>
</html>