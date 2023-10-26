$(document).ready(function () {
    // Initialize Bootstrap tab functionality
    $('.nav-pills a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });

    // Show the User Info section by default
    $('#userInfo').tab('show');

    // Handle clicks on table of contents links
    $('.nav-pills a').on('shown.bs.tab', function (event) {
        var targetSectionId = $(event.target).attr('href');
        var targetSectionName = $(event.target).text();
        
        // Update the browser's URL without refreshing the page (optional)
        //window.history.pushState(null, '', window.location.pathname + targetSectionId);
        
        // Log the selected section (you can replace this with your logic)
        console.log('Selected section: ' + targetSectionName);
    });
});
