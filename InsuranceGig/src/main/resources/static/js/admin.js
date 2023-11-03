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
	                        success: function (response) {
	                            console.log('Success: ', response);
	
	                            if (response != null) {
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
});
