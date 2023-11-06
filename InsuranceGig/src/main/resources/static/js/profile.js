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
		
	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/getPolicy",
	        success: function (data) {
	            if (data != null) {
					var startDate = data.startDate;
					if (startDate == null) startDate = "N/A";
					var endDate = data.endDate;
					if (endDate == null) endDate = "N/A";
	                $("#applicationStatusLabel").html("<strong>Status:</strong> " + data.status.toUpperCase());
	                $("#startDateLabel").html("<strong>Start Date:</strong> " + startDate);
	                $("#endDateLabel").html("<strong>End Date:</strong> " + endDate);
	
	                var plansList = data.plans;
	                var plansHtml = "<ul>";
	                for (var i = 0; i < plansList.length; i++) {
	                    plansHtml += "<li>" + plansList[i].name + "</li>";
	                }
	                plansHtml += "</ul>";
	                $("#plansList").html("<strong>Coverage Plans:</strong>" + plansHtml);
	                var roundedTotalPremium = data.totalPremium.toFixed(0);
	                $("#totalPremiumLabel").html("<strong>Total Premium:</strong> $" + roundedTotalPremium);
	            } else {
	                $("#applicationStatusLabel").text("No policy found for this user.");
	                $("#startDateLabel").text("N/A");
	                $("#endDateLabel").text("N/A");
	                $("#totalPremiumLabel").text("N/A");
	                $("#plansList").html("N/A");
	            }
	        },
	        error: function () {
	            console.log("Error fetching policy data");
	        }
	    });
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
	
	$("#fileClaimForm").submit(function (event) {
	    event.preventDefault();
	
	    var accidentDate = $("#accidentDate").val();
	    var accidentLocation = $("#accidentLocation").val();
	    var repairPrice = $("#repairPrice").val();
	    var description = $("#description").val();
	    var claimImages = $("#claimImages")[0].files;
	
	    if (accidentDate === "" || accidentLocation === "" || repairPrice === "" || description === "" || claimImages.length === 0) {
	        alert("Please fill out all required fields and upload at least one image.");
	        return;
	    }
	
	    var formData = new FormData();
	    formData.append("accidentDate", accidentDate);
	    formData.append("accidentLocation", accidentLocation);
	    formData.append("repairPrice", repairPrice);
	    formData.append("description", description);
	    formData.append("username", username);
	
	    for (var i = 0; i < claimImages.length; i++) {
	        formData.append("claimImages", claimImages[i]);
	    }
	
	    $.ajax({
	        type: "POST",
	        url: "http://localhost:8282/fileClaim",
	        data: formData,
	        contentType: false,
	        processData: false,
	        success: function (response) {
	            console.log('Success: ', response);
	            alert("Claim submitted!");
	
	            $("#accidentDate").val("");
	            $("#accidentLocation").val("");
	            $("#repairPrice").val("");
	            $("#description").val("");
	            $("#claimImages").val(""); 
	        },
	        error: function (error) {
	            console.error('Error: ', error);
	        }
	    });
	});
	
	$("#schedulePaymentLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#fileClaim").hide();
		$("#schedulePayment").show();
		$("#paymentInfo").hide();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
		
	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/findPaymentInfoByUsername",
	        success: function (data) {
				if (data == null) {
					$("#noPaymentInfoNotice").show();
				} else {
					$("#schedulePaymentForm").show();
				}
	        },
	        error: function () {
	            console.log("Error fetching payment info");
	        }
	    });
	})
	
    $("#schedulePaymentDetailsForm").submit(function (event) {
        event.preventDefault(); 

        var paymentAmount = $("#paymentAmount").val();
        var paymentOption = $("#paymentOption").val();
        var paymentDate = $("#paymentDate").val();

	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/findPaymentInfoByUsername",
	        success: function (paymentInfo) {
				
			var currentDate = new Date();
			var formattedCurrentDate = currentDate.toISOString().split('T')[0];
				
	        var formData = {
	            amount : paymentAmount,
	            paymentMethod : paymentOption,
	            scheduledDate : paymentDate,
	            username : username, 
	            submittedDate : formattedCurrentDate, 
	            bankAccountNo : paymentInfo.accountNo,
	            routingNo : paymentInfo.routingNo,
	            accountType : paymentInfo.accountType,
	            cardNo : paymentInfo.cardNo,
	            expiryDate : paymentInfo.expirationDate,
	            cvv : paymentInfo.cvv,
	            nameOnCard : paymentInfo.nameOnCard, 
	            nameOnAccount : paymentInfo.nameOnoAccount
	        };
	
	        $.ajax({
	            type: "POST",
	            url: "http://localhost:8282/savePayment",
	            data: JSON.stringify(formData),
	            contentType: "application/json",
	            dataType: "json",
	            success: function (response) {
	                console.log('Success: ', response);
	                
	                alert("Payment submitted!");
	                
                    $("#paymentAmount").val('');
                    $("#paymentOption").val('');
                    $("#paymentDate").val('');
	            },
	            error: function (error) {
	                console.error('Error: ', error);
	            }
	        });
				
			},
			error: function () {
	            console.log("Error fetching payment info");
	        }
	    });
    });
	
	$("#paymentInfoLink").click(function() {
		$("#userInfo").hide();
		$("#policyInfo").hide();
		$("#fileClaim").hide();
		$("#schedulePayment").hide();
		$("#paymentInfo").show();
		$("#applicationStatus").hide();
		
		$(".profile-nav-link").removeClass("active-link");
		$(this).addClass("active-link");
		
	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/findPaymentInfoByUsername",
	        success: function (data) {
				$("#cardNumberLabel").text("No credit card on record");
				$("#accountNumberLabel").text("No bank account on record");
				
				if (data != null && data.cardNo != null) {
					$("#cardNumberLabel").text("Credit Card on File: " + data.cardNo);
					$("#cardHolderLabel").text("Name on Card: " + data.nameOnCard);
					$("#cardExpirationLabel").text("Card Expiration Date: " + data.expirationDate);
					$("#cardInfo").show();
				}
				
				if (data != null && data.accountNo != null) {
					$("#accountNumberLabel").text("Bank Account No. on File: " + data.accountNo);
					$("#accountHolderLabel").text("Name on Card: " + data.nameOnAccount);
					$("#accountTypeLabel").text("Account Type: " + data.accountType);
					$("#bankAccountInfo").show();
				}
	        },
	        error: function () {
	            console.log("Error fetching payment info");
	        }
	    });
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
				
				if (data == null) {
					$("#statusLabel").text("N/A");
					$("#statusLabel").addClass("denied");
					$("#applicationActions").text("Please submit an application first.");
				} else {
				
		            var status = data.status;
		
		            if (status == "pending") {
						//$("#statusLabel").text("Application Status: PENDING");
						$("#statusLabel").text("PENDING")
						$("#statusLabel").addClass("pending");
						$("#applicationActions").text("No action is necessary yet.");
					} else if (status == "approved") {
						$("#statusLabel").text("APPROVED");
						//$("#applicationActions").text("Please fill out the required information below.");
						$("#statusLabel").addClass("approved");
						
					    $.ajax({
					        type: "GET",
					        url: "http://localhost:8282/findDriversLicenseByUsername",
					        success: function (data) {
								if (data == null) {
									$("#applicationActions").text("Please fill out the required information below.");
									$("#driverLicenseForm").show();
								} else {
									$("#applicationActions").text("You will get an email within 3 days notifying when you can make your first payment after your policy has been assigned.");
								}
					        },
					        error: function () {
					            console.log("Error fetching driver's license");
					        }
					    });
						
						//$("#driverLicenseForm").show();
					} else {
						$("#statusLabel").text("DENIED");
						$("#applicationActions").text("Your application has been denied.");
						$("#statusLabel").addClass("denied");
					}
				}
				
	        },
	        error: function () {
	            console.log("Error fetching user data");
	        }
	    });
	})
	
    $("#driverLicenseDetailsForm").submit(function (event) {
        //event.preventDefault();

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
        //var expirationDate = new Date($("#expirationDate").val());
		//var formattedExpirationDate = expirationDate.toISOString().split('T')[0];
		//var formattedExpirationDate = expirationDate.toLocaleDateString('en-US');

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
		            success: function (driverLicenseResponse) {
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
