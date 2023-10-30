$(document).ready(function () {
	
	$("#userInfo").show();
	$("#policyInfo").hide();
	$("#paymentInfo").hide();
	$("#applicationStatus").hide();
		
    $.ajax({
        type: "GET",
        url: "http://localhost:8282/findUserByUsername",
        success: function (data) {
            var email = data.email;
            var mobile = data.customerMobile;

            $("#emailLabel").text("Email: " + email);
            $("#mobileLabel").text("Mobile: " + mobile);
        },
        error: function () {
            console.log("Error fetching user data");
        }
    });
	
	$("#userInfoLink").click(function() {
		$("#userInfo").show();
		$("#policyInfo").hide();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#policyInfoLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").show();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#paymentInfoLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#paymentInfo").show();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#applicationStatusLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#paymentInfo").hide();
		$("#applicationStatus").show();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
		
	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/findApplicationByUsername",
	        success: function (data) {
	            var status = data.status;
	
	            if (status == "pending") {
					$("#statusLabel").text("Application Status: PENDING");
					$("#applicationActions").text("No action is necessary yet.");
				} else if (status == "approved") {
					$("#statusLabel").text("Application Status: APPROVED");
					$("#applicationActions").text("Please fill out the required information below.");
				} else {
					$("#statusLabel").text("Application Status: DENIED");
					$("#applicationActions").text("Your application has been denied.");
				}
	        },
	        error: function () {
	            console.log("Error fetching user data");
	        }
	    });
	})
});
