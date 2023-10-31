$(document).ready(function () {
	
	$("#userInfo").show();
	$("#policyInfo").hide();
	$("#fileClaim").hide();
	$("#schedulePayment").hide();
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
            
            /*$("#usernameLabel").val(username);
            $("#emailLabel").val(email);
            $("#mobileLabel").val(mobile);*/
            
        },
        error: function () {
            console.log("Error fetching user data");
        }
    });
	
	$("#userInfoLink").click(function() {
		$("#userInfo").show();
		$("#policyInfo").hide();
		$("#fileClaim").hide();
		$("#schedulePayment").hide();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#policyInfoLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").show();
		$("#fileClaim").hide();
		$("#schedulePayment").hide();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#fileClaimLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#fileClaim").show();
		$("#schedulePayment").hide();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#schedulePaymentLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#fileClaim").hide();
		$("#schedulePayment").show();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#paymentInfoLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#fileClaim").hide();
		$("#schedulePayment").hide();
		$("#paymentInfo").show();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
	})
	
	$("#applicationStatusLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#fileClaim").hide();
		$("#schedulePayment").hide();
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
					//$("#statusLabel").text("Application Status: PENDING");
					$("#statusLabel").text("PENDING")
					$("#statusLabel").addClass("pending");
					$("#applicationActions").text("No action is necessary yet.");
				} else if (status == "approved") {
					$("#statusLabel").text("APPROVED");
					$("#applicationActions").text("Please fill out the required information below.");
					$("#statusLabel").addClass("approved");
					$("#driverLicenseForm").show();
				} else {
					$("#statusLabel").text("DENIED");
					$("#applicationActions").text("Your application has been denied.");
					$("#statusLabel").addClass("denied");
				}
				
	        },
	        error: function () {
	            console.log("Error fetching user data");
	        }
	    });
	})
	
    $("#driverLicenseDetailsForm").submit(function (event) {
        event.preventDefault();

        var licenseNumber = $("#licenseNumber").val();
        var expirationDate = $("#expirationDate").val();
        var nameOnCard = $("#nameOnCard").val();
        var cardNumber = $("#cardNumber").val();
        var cardExpirationDate = $("#cardExpirationDate").val();
        var cvv = $("#cvv").val();
        var nameOnAccount = $("#nameOnAccount").val();
        var accountType = $("#accountType").val();
        var routingNumber = $("#routingNumber").val();
        var accountNumber = $("#accountNumber").val();

		var uploadedFile = document.getElementById("uploadLicense").files[0];
		
		if (!uploadedFile) {
			alert("No driver's license has been uploaded");
			return;
		}
		
		var driverLicenseData = new FormData();
		driverLicenseData.append('driversLicense', uploadedFile);
	    driverLicenseData.append('licenseNumber', licenseNumber);
	    driverLicenseData.append('expirationDate', expirationDate);
	    driverLicenseData.append('username', username);
		
		/*var driverLicenseData = {
			driversLicense : uploadedFile, 
			licenseNumber : licenseNumber, 
			expirationDate : expirationDate
		}*/
		
		var paymentData = {
			nameOnCard : nameOnCard, 
			cardNo : cardNumber, 
			expirationDate : cardExpirationDate, 
			cvv : cvv, 
			nameOnAccount : nameOnAccount, 
			accountType : accountType, 
			routingNo : routingNumber, 
			accountNo : accountNumber,
			username : username
		}
		
        $.ajax({
            type: "POST",
            url: "http://localhost:8282/savePaymentInfo",
            data: JSON.stringify(paymentData),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                console.log('Success: ', response);
                
		        $.ajax({
		            type: "POST",
		            url: "http://localhost:8282/saveDriversLicense",
		            data: driverLicenseData,
		            contentType: false,
		            processData: false,
		            success: function (driverLicenseresponse) {
		                console.log('Success: ', driverLicenseResponse);
		                
		                alert("Driver's license and payment info submitted!");
						$("#driverLicenseDetailsForm input, #driverLicenseDetailsForm select").val("");
						$("#driverLicenseDetailsForm input[type='file']").val(null);

		            },
		            error: function (driverLicenseError) {
		                console.error('Error: ', driverLicenseError);
		            }
		        });
            },
            error: function (error) {
                console.error('Error: ', error);
            }
        });
    });
});
