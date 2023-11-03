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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="./js/admin.js"></script>
    <style>
        .applications-nav-link {
                font-size: 18px; 
                padding: 5px 10px; 
                text-decoration: none; 
                border-radius: 5px;
                margin-right: 10px; 
                margin-left:10px;
                display: inline-block; 
                background-color: #fff; 
                color: #000; 
        }

        .applications-nav-link.active-link {
            background-color: #007BFF; 
            color: #fff; 
            font-weight: bold;
        }

        .active-link-2 {
            background-color: #910404; 
            color: #fff; 
            font-weight: bold;
        }

        #primary-navbar {
            color: #fff; 
            text-align: center;
            padding: 10px 0;
        }

        #primary-navbar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        #primary-navbar li {
            display: inline;
            margin-right: 20px;
        }

        #primary-navbar a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 5px;
            background-color: #021222; 
        }

        #primary-navbar a:hover {
            background-color: #0056b3; 
        }

        .table th,
        .table td {
            text-align: center;
            vertical-align: middle;
            padding: 10px;
            width: 25%
        }

    </style>
</head>

<body data-spy="scroll" data-target=".navbar-fixed-top">
    <%@ include file ="header.jsp" %>

    <div class="clear"></div>
    <div id="page-content"><br>

        <div id="primary-navbar">
            <ul>
                <li><a href="#" data-section="applications">Applications</a></li>
                <li><a href="#" data-section="policies">Policies</a></li>
                <li><a href="#" data-section="claims">Claims</a></li>
            </ul>
        </div><br>

        <div id="applications" class="section">
            <div id="applications-navbar" style="text-align: center;">
                <a href="#" id="pendingApplicationsLink" class="applications-nav-link active-link">Pending Applications</a> 
                <a href="#" id="approvedApplicationsLink" class="applications-nav-link">Approved Applications</a> 
                <a href="#" id="declinedApplicationsLink" class="applications-nav-link">Declined Applications</a>
            </div><br>

            <div id="pendingApplications" class="sub-section">
                <table id="pendingApplicationsTable" class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Application Id</th>
                            <th scope="col">Plans</th>
                            <th scope="col">Date Submitted</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody id="pendingApplicationsTblBody">
                    </tbody>
                </table>
            </div>
            
            <div id="approvedApplications" class="sub-section" style="display: none;">
                <table id="approvedApplicationsTable" class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Application Id</th>
                            <th scope="col">Plans</th>
                            <th scope="col">Date Submitted</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody id="approvedApplicationsTblBody">
                    </tbody>
                </table>
            </div>
            
            <div id="declinedApplications" class="sub-section" style="display: none;">
                <table id="declinedApplicationsTable" class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Application Id</th>
                            <th scope="col">Plans</th>
                            <th scope="col">Date Submitted</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody id="declinedApplicationsTblBody">
                    </tbody>
                </table>
            </div>
            
        </div>
        
        <div id="policies" class="section" style="display: none;">
        </div>
        
        <div id="claims" class="section" style="display: none;">
        </div>


        <div id="applicationDetailsModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Application Details</h4>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        
        </p></p>

    </div>
</p></p>

<%@ include file ="footer.jsp" %>
</body>
</html>