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

        #driverLicenseForm,
        #schedulePaymentForm {
            text-align: center;
        }

        #driverLicenseForm label {
            /*text-align: right;*/
            display: inline-block;
            width: 220px; 
            /*padding-right: 10px;*/
        }

        #schedulePaymentForm label {
            display: inline-block;
            width: 130px; 
        }

        #driverLicenseForm input[type="text"],
        #driverLicenseForm input[type="file"],
        #driverLicenseForm select {
            max-width: 190px;
            text-align: left; 
            display: inline-block;
            padding-left: 5px;
        }

        #schedulePaymentForm select {
            max-width: 190px;
            text-align: left; 
            display: inline-block;
            padding-left: 0px;
        }

        #statusText {
            font-size: 24px;
        }

        #statusLabel.pending {
            font-size: 24px;
            color: yellow; 
        }

        #statusLabel.approved {
            font-size: 24px;
            color: green; 
        }

        #statusLabel.denied {
            font-size: 24px;
            color: red; 
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
            <a href="#" id="fileClaimLink" class="profile-nav-link">File Claim</a> 
            <a href="#" id="schedulePaymentLink" class="profile-nav-link">Schedule Payment</a> 
            <a href="#" id="applicationStatusLink" class="profile-nav-link">Application Status</a>
        </div><br><br>

        <div id="userInfo" class="text-center">
            <label id="usernameLabel">Username: ${username}</label><br>
            <label id="emailLabel">Email: </label><br>
            <label id="mobileLabel">Mobile: </label><br><br>
            <input type="submit" value="Edit User Info">
            <!--<div class="form-group">
                <label for="usernameLabel">Username:</label>
                <input id="usernameLabel" type="text" readonly>
            </div>
            <div class="form-group">
                <label for="emailLabel">Email:</label>
                <input id="emailLabel" type="text" readonly>
            </div>
            <div class="form-group">
                <label for="mobileLabel">Mobile:</label>
                <input id="mobileLabel" type="text" readonly>
            </div>-->
        </div>
    
        <div id="policyInfo" class="text-center">
            test
        </div>

        <div id="fileClaim" class="text-center">
            test
        </div>

        <div id="schedulePayment" class="text-center">
            <h3><b>Make a Payment</b></h3><br>
            <div id="noPaymentInfoNotice" style="display: none;">
                <h3 style="color: red;">You have no payment info on record.</h3>
            </div>

            <div id="schedulePaymentForm" class="text-center" style="display: none;">
                <form id="schedulePaymentDetailsForm">
                    <label for="paymentAmountLabel">Payment Amount:</label>
                    <input type="number" id="paymentAmount"><br><br>
                    <label for="paymentOption">Payment Option:</label>
                    <select id="paymentOption" name="paymentOption">
                        <option value="" disable selected hidden>Select Payment Option</option>
                        <option value="creditCard">Credit Card</option>
                        <option value="bankAccount">Bank Account</option>
                    </select><br><br>
                    <label for="paymentDateLabel">Send On:</label><br>
                    <input type="date" id="paymentDate" name="paymentDate"><br><br>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    
        <div id="paymentInfo" class="text-center">
            <h3>Credit Card Info:</h3><br>
            <label id="cardNumberLabel">Credit Card on File: </label><br>
            <div id="cardInfo" class="text-center" style="display: none;">
                <label id="cardHolderLabel">Name on Card: </label><br>
                <label id="cardExpirationLabel">Card Expiration Date: </label><br><br>
                <input type="submit" value="Add New Card"><br><br><br>
            </div>
            <h3>Bank Account Info:</h3><br>
            <label id="accountNumberLabel">Bank Account No. on File: </label><br>
            <div id="bankAccountInfo" class="text-center" style="display: none;">
                <label id="accountHolderLabel">Name on Account: </label><br>
                <label id="accountTypeLabel">Account Type: </label><br><br>
                <input type="submit" value="Add New Account">
            </div>
        </div>
    
        <div id="applicationStatus" class="text-center">
            <span id="statusText"><b>Status:</b></span>
            <label id="statusLabel"></label><br><br>
            <label id="applicationActions">Actions:</label><br><br>

            <div id="driverLicenseForm" class="text-center" style="display: none;">
                <form id="driverLicenseDetailsForm" enctype="multipart/form-data">
                    <h3><u>Driver's License Information</u></h3><br>
                    <label for="licenseNumber">Driver's License Number:</label><br>
                    <input type="text" id="licenseNumber" name="licenseNumber">
                    <br>
                    <label for="expirationDate">Expiration Date:</label><br>
                    <input type="date" id="expirationDate" name="expirationDate">
                    <br><br>
                    <label for="uploadLicense">Upload Driver's License:</label><br>
                    <input type="file" id="uploadLicense" name="uploadLicense">
                    <br><br>
                    <h3><u>Payment Information</u></h3><br>
                    <h4>Card Info</h4>
                    <label for="nameOnCard">Name on Card:</label><br>
                    <input type="text" id="nameOnCard" name="nameOnCard">
                    <br>
                    <label for="cardNumber">Card Number:</label><br>
                    <input type="text" id="cardNumber" name="cardNumber">
                    <br>
                    <label for="cardExpirationDate">Card Expiration Date:</label><br>
                    <input type="date" id="cardExpirationDate" name="cardExpirationDate">
                    <br><br>
                    <label for="cvv">Card Verfication Value:</label><br>
                    <input type="text" id="cvv" name="cvv">
                    <!--ADD BILLING ADDRESS-->
                    <br>
                    <h4>Bank Account Info</h4>
                    <label for="nameOnAccount">Name on Account:</label><br>
                    <input type="text" id="nameOnAccount" name="nameOnAccount">
                    <br>
                    <label for="accountType">Account Type:</label><br>
                    <select id="accountType" name="accountType">
                        <option value="" disable selected hidden>Choose Account Type</option>
                        <option value="Checking Account">Checking Account</option>
                        <option value="Savings Account">Savings Account</option>
                    </select>
                    <br><br>
                    <label for="routingNumber">Routing Number:</label><br>
                    <input type="text" id="routingNumber" name="routingNumber">
                    <br>
                    <label for="accountNumber">Account Number:</label><br>
                    <input type="text" id="accountNumber" name="accountNumber">
                    <br>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </div>
            
        </div>

    </div>
    </p></p>

    <%@ include file ="footer.jsp" %>
</body>
</html>