$(document).on('FCLOGIN_SUCCEED', function() {
    window.SOHUCS && window.SOHUCS.reset && window.SOHUCS.reset();
})
$(document).on('FCLOGIN_CLOSED', function() {
    var isSubmit = $('#SOHUCS').find('.isSubmit');
    isSubmit && isSubmit.removeClass('isSubmit');
})