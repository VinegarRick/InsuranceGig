$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "http://localhost:8282/findAllApplications",
        success: function (result) {
            if (result == null) return;

            var pendingTableBody = $("#pendingApplicationsTable tbody");
            var approvedTableBody = $("#approvedApplicationsTable tbody");
            var declinedTableBody = $("#declinedApplicationsTable tbody");

            pendingTableBody.empty();
            approvedTableBody.empty();
            declinedTableBody.empty();

            $.each(result, function (key, data) {
                var tableBody;
                if (data.status == "pending") {
                    tableBody = pendingTableBody;
                } else if (data.status == "approved") {
                    tableBody = approvedTableBody;
                } else {
                    tableBody = declinedTableBody;
                }

                var row = $("<tr></tr>");

                row.append("<td>" + data.applicationId + "</td>");
                row.append("<td>" + data.plans + "</td>");
                row.append("<td>" + data.submittedDate + "</td>");

                var actionCell = $("<td></td>");
                
                if (data.status == "pending") {
	                var approveLink = $("<a href='#' class='approve-link'>Approve</a>");
	                var declineLink = $("<a href='#' class='decline-link'>Decline</a>");

	                approveLink.click(function () {
	                    var row = $(this).closest('tr');
	                    var applicationId = row.find('td:eq(0)').text();
	
	                    payload = {
	                        applicationId: applicationId,
	                        status: "approved"
	                    }
	
	                    $.ajax({
	                        type: "POST",
	                        url: "http://localhost:8282/updateApplicationStatus",
	                        data: JSON.stringify(payload),
	                        contentType: "application/json",
	                        success: function (application) {
	                            console.log('Success: ', application);
	
								vehicleInfo = {
									username : application.username,
									vin : application.vin,
									make : application.carMake,
									model : application.carModel,
									year : application.carYear, 
									mileage : application.carMileage, 
								}
	
								$.ajax({
			                        type: "POST",
			                        url: "http://localhost:8282/saveVehicle",
			                        data: JSON.stringify(vehicleInfo),
			                        contentType: "application/json",
			                        success: function (response) {
			                            console.log('Success: ', response);
			                           
					                    policyInfo = {
											username : application.username,
											plans : application.plans,
											dob : application.dateOfBirth
										}
					                            
					                    $.ajax({
					                        type: "POST",
					                        url: "http://localhost:8282/savePolicy",
					                        data: JSON.stringify(policyInfo),
					                        contentType: "application/json",
					                        success: function (response) {
					                            console.log('Success: ', response);
					
					                        },
					                        error: function (error) {
					                            console.error('Error: ', error);
					                        }
					                    });
			                        },
			                        error: function (error) {
			                            console.error('Error: ', error);
			                        }
			                    });
			                            
	
	                            if (application != null) {
					               	row.find('a.approve-link').remove(); 
					                row.find('a.decline-link').remove();
	                                row.remove();
	                                $("#approvedApplicationsTable tbody").append(row);
	                            }
	                        },
	                        error: function (error) {
	                            console.error('Error: ', error);
	                        }
	                    });
	                   
	                });
	
	                declineLink.click(function () {
	                    var row = $(this).closest('tr');
	                    var applicationId = row.find('td:eq(0)').text();
	
	                    payload = {
	                        applicationId: applicationId,
	                        status: "declined"
	                    }
	
	                    $.ajax({
	                        type: "POST",
	                        url: "http://localhost:8282/updateApplicationStatus",
	                        data: JSON.stringify(payload),
	                        contentType: "application/json",
	                        success: function (response) {
	                            console.log('Success: ', response);
	
	                            if (response != null) {
					               	row.find('a.approve-link').remove(); 
					                row.find('a.decline-link').remove();
	                                row.remove();
	                                $("#declinedApplicationsTable tbody").append(row);
	                            }
	                        },
	                        error: function (error) {
	                            console.error('Error: ', error);
	                        }
	                    });
	                });
	                
			        actionCell.append(approveLink);
		            actionCell.append(" | ");
		            actionCell.append(declineLink);
		            actionCell.append(" | ");
	            }

				var detailsLink = $("<a href='#' class='details-link'>Details</a>");
				
                detailsLink.click(function () {
                    var row = $(this).closest('tr');
                    var applicationId = row.find('td:eq(0)').text();
                    
				    $.ajax({
				        type: "GET",
				        contentType: "application/json",
				        url: "http://localhost:8282/findApplicationById/" + applicationId,
				        success: function (result) {
				            var modalBody = $('#applicationDetailsModal .modal-body');
				            modalBody.empty(); 
				
							modalBody.append('<p><strong>Application ID:</strong> ' + result.applicationId + '</p>');
							modalBody.append('<p><strong>Status:</strong> ' + result.status.toUpperCase() + '</p>');
							modalBody.append('<p><strong>Username:</strong> ' + result.username + '</p>');
							modalBody.append('<p><strong>First Name:</strong> ' + result.firstName + '</p>');
							modalBody.append('<p><strong>Last Name:</strong> ' + result.lastName + '</p>');
							modalBody.append('<p><strong>Address Line:</strong> ' + result.addressLine + '</p>');
							modalBody.append('<p><strong>City:</strong> ' + result.city + '</p>');
							modalBody.append('<p><strong>County:</strong> ' + result.county + '</p>');
							modalBody.append('<p><strong>Zipcode:</strong> ' + result.zipcode + '</p>');
							modalBody.append('<p><strong>Date of Birth:</strong> ' + result.dateOfBirth + '</p>');
							modalBody.append('<p><strong>Gender:</strong> ' + result.gender + '</p>');
							modalBody.append('<p><strong>License No:</strong> ' + result.licenseNo + '</p>');
							modalBody.append('<p><strong>SSN:</strong> ' + result.ssn + '</p>');
							modalBody.append('<p><strong>VIN:</strong> ' + result.vin + '</p>');
							modalBody.append('<p><strong>Car Year:</strong> ' + result.carYear + '</p>');
							modalBody.append('<p><strong>Car Make:</strong> ' + result.carMake + '</p>');
							modalBody.append('<p><strong>Car Model:</strong> ' + result.carModel + '</p>');
							modalBody.append('<p><strong>Car Mileage:</strong> ' + result.carMileage + '</p>');
							modalBody.append('<p><strong>Plans:</strong> ' + result.plans + '</p>');
							modalBody.append('<p><strong>Submitted Date:</strong> ' + result.submittedDate + '</p>');

				            $('#applicationDetailsModal').modal('show');
						},
				        error: function () {
				            console.log("Error fetching application");
				        }
					});
                });

                actionCell.append(detailsLink);
                row.append(actionCell);

                tableBody.append(row);
            });
        },
        error: function () {
            console.log("Error fetching applications");
        }
    });

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "http://localhost:8282/findAllClaims",
        success: function (result) {
            if (result == null) return;

            var pendingTableBody = $("#pendingClaimsTable tbody");
            var approvedTableBody = $("#approvedClaimsTable tbody");
            var declinedTableBody = $("#declinedClaimsTable tbody");

            pendingTableBody.empty();
            approvedTableBody.empty();
            declinedTableBody.empty();

            $.each(result, function (key, data) {
                var tableBody;
                if (data.status == "pending") {
                    tableBody = pendingTableBody;
                } else if (data.status == "approved") {
                    tableBody = approvedTableBody;
                } else {
                    tableBody = declinedTableBody;
                }

                var row = $("<tr></tr>");

                row.append("<td>" + data.id + "</td>");
                row.append("<td>" + data.accidentDate + "</td>");
                row.append("<td>" + data.repairPrice + "</td>");

                var actionCell = $("<td></td>");

                if (data.status == "pending") {
                    var approveLink = $("<a href='#' class='approve-claim-link'>Approve</a>");
                    var declineLink = $("<a href='#' class='decline-claim-link'>Decline</a>");

                    approveLink.click(function () {
                        var row = $(this).closest('tr');
                        var claimId = row.find('td:eq(0)').text();

                        payload = {
                            id: claimId,
                            status: "approved"
                        }

                        $.ajax({
                            type: "POST",
                            url: "http://localhost:8282/updateClaimStatus",
                            data: JSON.stringify(payload),
                            contentType: "application/json",
                            success: function (claim) {
                                console.log('Success: ', claim);

                                if (claim != null) {
                                    row.find('a.approve-claim-link').remove();
                                    row.find('a.decline-claim-link').remove();
                                    row.remove();
                                    $("#approvedClaimsTable tbody").append(row);
                                }
                            },
                            error: function (error) {
                                console.error('Error: ', error);
                            }
                        });
                    });

                    declineLink.click(function () {
                        var row = $(this).closest('tr');
                        var claimId = row.find('td:eq(0)').text();

                        payload = {
                            id: claimId,
                            status: "declined"
                        }

                        $.ajax({
                            type: "POST",
                            url: "http://localhost:8282/updateClaimStatus",
                            data: JSON.stringify(payload),
                            contentType: "application/json",
                            success: function (response) {
                                console.log('Success: ', response);

                                if (response != null) {
                                    row.find('a.approve-claim-link').remove();
                                    row.find('a.decline-claim-link').remove();
                                    row.remove();
                                    $("#declinedClaimsTable tbody").append(row);
                                }
                            },
                            error: function (error) {
                                console.error('Error: ', error);
                            }
                        });
                    });

                    actionCell.append(approveLink);
                    actionCell.append(" | ");
                    actionCell.append(declineLink);
                    actionCell.append(" | ");
                }

                var detailsLink = $("<a href='#' class='details-claim-link'>Details</a>");

                detailsLink.click(function () {
                    var row = $(this).closest('tr');
                    var claimId = row.find('td:eq(0)').text();

                    $.ajax({
                        type: "GET",
                        contentType: "application/json",
                        url: "http://localhost:8282/findClaimById/" + claimId,
                        success: function (result) {
                            var modalBody = $('#claimDetailsModal .modal-body');
                            modalBody.empty();

				            modalBody.append('<p><strong>Claim ID:</strong> ' + claimId + '</p>');
				            //modalBody.append('<p><strong>Username:</strong> ' + result.username + '</p>');
				            modalBody.append('<p><strong>Accident Date:</strong> ' + result.accidentDate + '</p>');
				            modalBody.append('<p><strong>Accident Location:</strong> ' + result.accidentLocation + '</p>');
				            modalBody.append('<p><strong>Repair Price:</strong> ' + result.repairPrice + '</p>');
				            modalBody.append('<p><strong>Description:</strong> ' + result.description + '</p><br>');

				            if (result.images.length > 0) {
				                //modalBody.append('<h4>Claim Images:</h4>');
				                var imagesDiv = $('<div class="claim-images"></div>');
				
				                $.each(result.images, function (index, image) {
				                    var img = $('<img class="claim-image" src="data:image/jpeg;base64,' + image.data + '" alt="' + image.filename + '">');
				                    imagesDiv.append(img);
				                });
				
				                modalBody.append(imagesDiv);
				            }

                            $('#claimDetailsModal').modal('show');
                        },
                        error: function () {
                            console.log("Error fetching claim");
                        }
                    });
                });

                actionCell.append(detailsLink);
                row.append(actionCell);

                tableBody.append(row);
            });
        },
        error: function () {
            console.log("Error fetching claims");
        }
    });
    

    $("#applications").show();
    $("#pendingApplications").show();

    $("#primary-navbar a").click(function () {
        var section = $(this).data("section");

        $(".section").hide();

        $("#" + section).show();

        $("#primary-navbar a").removeClass("active-link-2");

        $(this).addClass("active-link-2");
       
    });

    $("#applications-navbar a").click(function () {
        var subSection = $(this).attr("id").replace("Link", "");

        $(".sub-section").hide();

        $("#" + subSection).show();

        $("#applications-navbar a").removeClass("active-link");

        $(this).addClass("active-link");
    });
    
    $("#claims-navbar a").click(function () {
        var status = $(this).attr("id").replace("ClaimsLink", ""); 

        $(".sub-section").hide();
        $("#claims-navbar a").removeClass("active-link");

        $("#" + status + "Claims").show();
        $(this).addClass("active-link");

        //loadClaims(status);
    });
    
	$("#applicationsLink").click();
	
	$("#claimsLink").click();
});
