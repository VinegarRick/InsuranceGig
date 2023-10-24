$(document).ready(function () {

  $('#submit-button').click(function () {
    // Get the form data
    var name = $('#name').val();
    var email = $('#email').val();
    var subject = $('#subject').val();
    var message = $('#message').val();

    var formData = {
      name: name,
      email: email,
      subject: subject,
      message: message,
    };

	$.ajax({
	  type: 'POST',
	  url: 'http://localhost:8282/sendContactEmail',
	  data: JSON.stringify(formData), 
	  contentType: 'application/json', 
	  dataType: 'json', 
	  success: function (response) {
	    $('#name').val('');
	    $('#email').val('');
	    $('#subject').val('');
	    $('#message').val('');
	
	    alert('Your message has been sent.');
	  },
	  error: function (error) {
	    alert('An error occurred while sending the message.');
	  },
	});

  });
});
