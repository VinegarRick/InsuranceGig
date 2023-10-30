$(document).ready(function () {
    $('#application-submit-button').click(function (e) {
        e.preventDefault();

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
            gender: $('#gender').val(),
            licenseNo: $('#licenseNo').val(),
            ssn: $('#ssn').val(),
            vin: $('#vin').val(),
            carYear: $('#carYear').val(),
            carMake: $('#carMake').val(),
            carModel: $('#carModel').val(),
            carMileage: $('#carMileage').val(),
            status: "pending"
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
