$(document).ready(function () {
	
    $('#quote-submit-button').click(function (e) {
        e.preventDefault(); 

        var formData = {
            name: $('#name').val(),
            email: $('#email').val(),
            phNo: $('#ph-no').val(),
            valuation: $('#valuation').val(),
            plans: $('input[name="plans"]:checked').map(function () {
                return $(this).val();
            }).get(),
            message: $('#message').val()
        };

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8282/sendQuoteEmail',
            data: JSON.stringify(formData),
            contentType: 'application/json',
            dataType: 'json',
            success: function (response) {
                console.log('Success: ', response);
                $('#get-quote')[0].reset();
                
                alert('Your message has been sent.');
            },
            error: function (error) {
                console.error('Error: ', error);
            }
        });
    });
});
