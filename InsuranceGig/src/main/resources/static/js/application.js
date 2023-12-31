$(document).ready(function () {

	function populateCarMakes() {
	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/getCarMakes",
	        success: function (data) {
	            var carMakeDropdown = $("#carMake");

	            carMakeDropdown.empty();
	
	            carMakeDropdown.append($('<option>', {
	                value: "",
	                text: "Select Car Make"
	            }));
	
	            $.each(data, function (key, value) {
	                carMakeDropdown.append($('<option>', {
	                    value: value,
	                    text: value
	                }));
	            });
	        },
	        error: function (error) {
	            console.error('Error: ', error);
	        }
	    });
	}
	
	function populateCarModels(selectedMake) {
	    $.ajax({
	        type: "GET",
	        url: "http://localhost:8282/getCarModels?make=" + selectedMake, 
	        success: function (data) {
	            var carModelDropdown = $("#carModel");
	
	            carModelDropdown.empty();
	
	            carModelDropdown.append($('<option>', {
	                value: "",
	                text: "Select Car Model"
	            }));
	
	            $.each(data, function (key, value) {
	                carModelDropdown.append($('<option>', {
	                    value: value,
	                    text: value
	                }));
	            });
	        },
	        error: function (error) {
	            console.error('Error: ', error);
	        }
	    });
	}
	
	populateCarMakes();
	
	$("#carMake").change(function () {
	    var selectedMake = $(this).val();
	    if (selectedMake !== "") {
	        populateCarModels(selectedMake);
	    }
	});
	
    $('#application-submit-button').click(function (e) {
        e.preventDefault();

		var currentDate = new Date();
		var formattedCurrentDate = currentDate.toISOString().split('T')[0];

        var formData = {
			username: username,
            firstName: $('#firstName').val(),
            lastName: $('#lastName').val(),
            mobile: $('#mobile').val(),
            email: $('#email').val(),
            addressLine: $('#address').val(),
            city: $('#city').val(),
            county: $('#county').val(),
            zipcode: $('#zipcode').val(),
            dateOfBirth: $('#dob').val(),
            //dateOfBirth: formattedDateOfBirth,
            gender: $('#gender').val(),
            licenseNo: $('#licenseNo').val(),
            ssn: $('#ssn').val(),
            vin: $('#vin').val(),
            carYear: $('#carYear').val(),
            carMake: $('#carMake').val(),
            carModel: $('#carModel').val(),
            carMileage: $('#carMileage').val(),
            status: "pending",
            submittedDate: formattedCurrentDate
        };

        /*var coveragePlans = [];
        $('input[name="coveragePlan"]:checked').each(function() {
            coveragePlans.push($(this).val());
        });*/ 
        
        var coveragePlans;
        $('input[name="coveragePlan"]:checked').each(function() {    	
         	if (coveragePlans === undefined) {
				 coveragePlans = $(this).val();
			} else {
				coveragePlans += ", " + $(this).val();
			}
        });

        formData.plans = coveragePlans;

        $.ajax({
            type: "POST",
            url: "http://localhost:8282/saveApplication",
            data: JSON.stringify(formData),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                console.log('Success: ', response);
                alert("Application sent!");
                $('#application-form')[0].reset();
            },
            error: function (error) {
                console.error('Error: ', error);
            }
        });
    });
});
