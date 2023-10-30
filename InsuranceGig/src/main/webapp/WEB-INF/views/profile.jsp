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
    <script>
        var username = "${username}";
    </script>
    <style>
        .profile-nav-link {
                font-size: 18px; 
                padding: 5px 10px; 
                text-decoration: none; 
                border-radius: 5px;
                margin-right: 10px; 
                margin-left:10px;
        }

        .active-link {
            background-color: #007BFF !important;
            color: #fff !important; 
            font-weight: bold !important;
        }

        
        .profile-navbar, .page-content label {
            display: flex;
            justify-content: center;
        }
    </style>
</head>

<body data-spy="scroll" data-target=".navbar-fixed-top">
    <%@ include file ="header.jsp" %>

    <div class="clear"></div>
    <div id="page-content"><br>
        <div id="profile-navbar" class="profile-navbar">
            <a href="#" id="userInfoLink" class="profile-nav-link active-link">User Info</a> 
            <a href="#" id="policyInfoLink" class="profile-nav-link">Policy Info</a> 
            <a href="#" id="paymentInfoLink" class="profile-nav-link">Payment Info</a>
            <a href="#" id="applicationStatusLink" class="profile-nav-link">Application Status</a>
        </div><br><br>

        <div id="userInfo" class="text-center">
            <label id="usernameLabel">Username: ${username}</label><br>
            <label id="emailLabel">Email: </label><br>
            <label id="mobileLabel">Mobile: </label><br>
        </div>
    
        <div id="policyInfo" class="text-center">
            test 2
        </div>
    
        <div id="paymentInfo" class="text-center">
            test 3
        </div>
    
        <div id="applicationStatus" class="text-center">
            <label id="statusLabel">Status: </label><br>
            <label id="applicationActions">Actions:</label>
        </div>

    </div>
    </p></p>

    <%@ include file ="footer.jsp" %>
</body>
</html>