$(document).ready(function() {

    $("#registrationForm").submit(function(event) {
        event.preventDefault();

        var username = $("#username").val();
        var password = $("#password").val();
        var email = $("#email").val();
        var mobile = $("#mobile").val();

        var formData = {
            "username": username,
            "password": password,
            "email": email,
            "mobile": mobile
        };
        
        $.ajax({
            url: "http://localhost:8282/registerUser",
            type: "POST",
            data: JSON.stringify(formData),
            contentType: "application/json",
            dataType: "json",
            success: function(response) {
				if (response != null) {
	                console.log("User registered successfully");
	                
	                window.location.href = '/login';
	                alert("You have successfully registered!");
				} else {
					console.log("User already exists");
					alert("User with selected username already exists");
				}
            },
            error: function(error) {
                console.error("Registration failed: " + error.responseText);
            }
        });
    });
});
