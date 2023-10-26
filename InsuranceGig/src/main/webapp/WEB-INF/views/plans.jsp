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
    <%@ include file ="header.jsp" %>

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
    <%@ include file ="footer.jsp" %>

</body>

</html>