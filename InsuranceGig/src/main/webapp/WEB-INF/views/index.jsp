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
    <script src="./js/index.js"></script>
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
        <section class="flexslider">
            <ul class="slides">
                <li>
                    <img src="images/slider-img.jpg" />
                    <div class="slide-info">
                        <div class="slide-con">
                            <b>Get Protected</b>
                            <h3>Automobile Insurance</h3>
                            <p>Californians save an average of $905 with Auto Insurance Gig</p>
                            <a href="#" class="ti-arrow-right"></a>
                        </div>
                    </div>
                </li>
                <li>
                    <img src="images/slider-img1.jpg" />
                    <div class="slide-info">
                        <div class="slide-con">
                            <b>Claims</b>
                            <h3>24/7 Claims</h3>
                            <p>You can file a claim 24 hours a day, seven days a week with Auto Insurance Gig.</p>
                            <a href="#" class="ti-arrow-right"></a>
                        </div>
                    </div>
                </li>
                <li>
                    <img src="images/slider-img2.jpg" />
                    <div class="slide-info">
                        <div class="slide-con">
                            <b>Repairs</b>
                            <h3>Guaranteed Repairs</h3>
                            <p>We guarantee any repairs completed by a Auto Insurance Gig authorized repair shop for as long as you own the car!.</p>
                            <a href="#" class="ti-arrow-right"></a>
                        </div>
                    </div>
                </li>
                <li>
                    <img src="images/slider-img3.jpg" />
                    <div class="slide-info">
                        <div class="slide-con">
                            <b>Assistance</b>
                            <h3>24/7 Roadside Assistance</h3>
                            <p>You can add optional coverage that will dispatch a roadside service professional to help get you back on the road.</p>
                            <a href="#" class="ti-arrow-right"></a>
                        </div>
                    </div>
                </li>
            </ul>
        </section>
        <div class="container">
            <div class="row">
                <section class="col-sm-7 col-md-8 col-lg-8">
                    <div class="intro">
                        <h2>Welcome to Auto Insurance Gig</h2>
                        <p>When it comes to choosing an insurance company, Auto Insurance Gig knows you want the lowest price possible. But you also want the appropriate amount of coverage to protect your family and property. Why should you have to sacrifice one for the other? We believe in offering the best of both worlds. Low rates come with excellent coverage, and our local agents are there to create your ideal insurance policy. That's what sets us apart from our competitors. And, that's what makes us the obvious choice when it comes to insurance.</p>
                        <ul class="row">
                            <li class="col-sm-4">
                                <i class="fa fa-life-ring"></i>
                                <h3>Service and Support </h3>
                                <p>Protecting our customers and their property is a responsibility we take very seriously, and we're committed to providing the best service and protection for everyone we insure.</p>
                            </li>
                            <li class="col-sm-4">
                                <i class="ti-marker-alt"></i>
                                <h3>Easy Claim system</h3>
                                <p>You can file a claim 24 hours a day, seven days a week. Just call our claims hotline at (800) 888-8888 to get back on the road fast.</p>
                            </li>
                            <li class="col-sm-4">
                                <i class="ti-email"></i>
                                <h3>Get Started with us</h3>
                                <p>Shopping for car insurance is simple because we make it easy to understand with coverages to meet everyone's needs at affordable rates.</p>
                            </li>
                        </ul>
                    </div>
                </section>
                <section class="col-sm-5 col-md-4 col-lg-4">
                    <div class="get-quote-form">
                        <h2>Get a free quote form</h2>
                        <form id="get-quote">
                            <div>
                                <input type="text" id="name" name="name" placeholder="Your Name" />
                            </div>
                            <div>
                                <input type="text" id="email" name="email" placeholder="Email" />
                            </div>
                            <div>
                                <input type="text" id="ph-no" name="ph-no" placeholder="Phone No" />
                            </div><br>
                            <div>
                                <span>Estimated Vehicle Valuation:</span><br><br>
                                <input type="number" id="valuation" name="valuation" placeholder="0" />
                            </div><br>                            
                            <span>Select Coverage Plans:</span>
                            <div class="form-select">
                                <div>
                                    <input type="checkbox" name="plans" id="liability" value="Liability">
                                    <label for="liability">Liability</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="plans" id="collision" value="Collision">
                                    <label for="collision">Collision</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="plans" id="comprehensive" value="Comprehensive">
                                    <label for="comprehensive">Comprehensive</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="plans" id="uninsured" value="Uninsured">
                                    <label for="uninsured">Uninsured</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="plans" id="medical" value="Medical">
                                    <label for="medical">Medical</label>
                                </div>
                                <div>
                                    <input type="checkbox" name="plans" id="roadside-assistance" value="Roadside Assistance">
                                    <label for="roadside-assistance">Roadside Assistance</label>
                                </div>
                            </div>
                            <div>
                                <textarea rows="1" cols="1" id="message" placeholder="Message"></textarea>
                            </div>
                            <div class="text-center">
                                <input type="submit" id="quote-submit-button" class="btn-default" value="Get Free Quote" />
                            </div>
                        </form>
                    </div>
                </section>
                
            </div>
        </div>

        <section class="services">
            <h2 class="text-center">Our Best Services</h2>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3 services-dtl">
                        <span class="fa fa-life-bouy"></span>
                        <h3>24x7 Support</h3>
                        <p>Our dedicated support team is available around the clock</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="ti-pencil"></span>
                        <h3>Easy Claim System</h3>
                        <p>Our hassle-free claims process makes it easy for you</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="ti-email"></span>
                        <h3>Get Started With us</h3>
                        <p>Begin your journey with us to discover a new world of insurance</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="fa fa-money"></span>
                        <h3>Easy Installments</h3>
                        <p>Choose flexible payment options with our easy installment plans for your insurance premiums</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="ti-wallet"></span>
                        <h3>Cost-Efficient Plans</h3>
                        <p>Discover our cost-efficient insurance plans that provide maximum coverage at affordable rates</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="fa fa-laptop"></span>
                        <h3>Online Account</h3>
                        <p>Access your insurance account online for convenient management and updates</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="ti-lock"></span>
                        <h3>Strongly Secure</h3>
                        <p>Your security is our top priority, and we maintain strong measures to protect your information</p>
                    </div>
                    <div class="col-sm-3 services-dtl">
                        <span class="ti-book"></span>
                        <h3>Understandable Terms</h3>
                        <p>We provide clear and understandable terms, so you know exactly what you're getting</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="testimonials">
            <div class="container">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <h2 class="text-center">Know what people says</h2>
                        <div class="testimonial-tab">
                            <div class="testimonials-tab-list">
                                <ul>
                                    <li>
                                        <a href="javascript:void(0);" data-tab="tab1"><img src="images/people-01.jpg" alt="Client" /></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);" data-tab="tab2"><img src="images/people-02.jpg" alt="Client" /></a>
                                    </li>
                                    <li class="active">
                                        <a href="javascript:void(0);" data-tab="tab3"><img src="images/people-03.jpg" alt="Client" /></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);" data-tab="tab4"><img src="images/people-04.jpg" alt="Client" /></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0);" data-tab="tab5"><img src="images/people-05.jpg" alt="Client" /></a>
                                    </li>
                                </ul>
                            </div>
                            <div class="testimonials-tab-content">
                                <div class="clearfix testimonial-con" id="testimonial-tab1">
                                    <h3>John<br /><span>Developer</span></h3>
                                    <i class="fa fa-quote-left left-quote"></i>
                                    <p class="col-sm-offset-1 col-sm-10">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ante purus, aliquet ut urna id, blandit lobortis nisl. Phasellus varius velit sed placerat euismod. Duis nisi massa, pretium at luctus.</p>
                                    <i class="fa fa-quote-right right-quote"></i>
                                </div>
                                <div class="clearfix testimonial-con" id="testimonial-tab2">
                                    <h3>Roger<br /><span>Baseball Player</span></h3>
                                    <i class="fa fa-quote-left left-quote"></i>
                                    <p class="col-sm-offset-1 col-sm-10">Cras vitae justo eu tellus maximus rutrum. Vestibulum nibh nibh, varius nec vehicula sed, finibus in tortor. Aliquam dictum, ligula vel euismod eleifend, libero est elementum</p>
                                    <i class="fa fa-quote-right right-quote"></i>
                                </div>
                                <div class="clearfix testimonial-con" id="testimonial-tab3">
                                    <h3>Victoria<br /><span>CEO</span></h3>
                                    <i class="fa fa-quote-left left-quote"></i>
                                    <p class="col-sm-offset-1 col-sm-10">Cruising through the road of life, we steer towards a future where your safety and dreams intersect. At our auto insurance company, we're dedicated to empowering your journey, ensuring that every mile traveled is a step closer to your aspirations. Together, let's embrace the road ahead with the confidence that your path is secure in our hands.</p>
                                    <i class="fa fa-quote-right right-quote"></i>
                                </div>
                                <div class="clearfix testimonial-con" id="testimonial-tab4">
                                    <h3>Liang<br /><span>Photographer</span></h3>
                                    <i class="fa fa-quote-left left-quote"></i>
                                    <p class="col-sm-offset-1 col-sm-10">Pellentesque feugiat suscipit quam, quis dignissim massa. Suspendisse potenti. Donec porta tempus ipsum id rhoncus. Aliquam hendrerit leo erat, non accumsan massa venenatis vitae.</p>
                                    <i class="fa fa-quote-right right-quote"></i>
                                </div>
                                <div class="clearfix testimonial-con" id="testimonial-tab5">
                                    <h3>Adam<br /><span>Student</span></h3>
                                    <i class="fa fa-quote-left left-quote"></i>
                                    <p class="col-sm-offset-1 col-sm-10">Vivamus faucibus magna vitae purus blandit, rutrum aliquam turpis bibendum. Ut sit amet sapien dolor. Integer eget orci id leo consectetur iaculis ut vitae neque.</p>
                                    <i class="fa fa-quote-right right-quote"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
 
        <section class="partners">
            <div class="container">
                <div class="row">
                    <div class="parner-slider-mn">
                        <div class="col-sm-3">
                            <h2>
                                <b>Insurance</b> Partners
                            </h2>
                        </div>
                        <div class="col-sm-9">
                            <div class="partner-slider owl-carousel">
                                <div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-01.jpg" alt="Partner" /></p>
                                    </div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-04.jpg" alt="Partner" /></p>
                                    </div>
                                </div>
                                <div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-02.jpg" alt="Partner" /></p>
                                    </div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-05.jpg" alt="Partner" /></p>
                                    </div>
                                </div>
                                <div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-03.jpg" alt="Partner" /></p>
                                    </div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-06.jpg" alt="Partner" /></p>
                                    </div>
                                </div>
                                <div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-04.jpg" alt="Partner" /></p>
                                    </div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-01.jpg" alt="Partner" /></p>
                                    </div>
                                </div>
                                <div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-05.jpg" alt="Partner" /></p>
                                    </div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-02.jpg" alt="Partner" /></p>
                                    </div>
                                </div>
                                <div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-06.jpg" alt="Partner" /></p>
                                    </div>
                                    <div class="partner-logo">
                                        <p><img src="images/partner-logo-03.jpg" alt="Partner" /></p>
                                    </div>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <div class="clear"></div>
    <%@ include file ="footer.jsp" %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-hover-dropdown/2.2.1/bootstrap-hover-dropdown.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
    <script src="js/jquery.flexslider-min.js"></script>
    <script src="js/easyResponsiveTabs.js"></script>
    <script src="js/owl.carousel.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>
