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
                                <li>
                                    <a href="/profile">Profile</a>
                                </li>
                                <li>
                                    <a href="login?logout">Log Out</a>
                                </li>
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