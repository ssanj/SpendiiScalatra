var spendii = {
    init : function() {
        this.hideNotification("messages");
        this.hideNotification("errors");
    },

    hideNotification : function(noticeId) {
        var notice = $("#" + noticeId);
        if (notice.text().trim() == "N/A") notice.hide(); else notice.show();
    },

    validateCreateFirstUser: function() {
	    this.addAlphanumericValidator();//move this into another js.
		var validator = $('#firstUser').validate({
		  rules: {
			username: { required: true, minlength: 6, alphanumeric: true},
			password: { required: true, minlength: 6},
			verification: { required:true, minlength: 6,  equalTo: "#password"}
		  },
		
		  validClass: "valid",
		
		  errorClass: "error",
		
		  success: function(label) {
			if (validator.numberOfInvalids() == 0) $("#errors:visible").slideUp(2000, 'jswing');
			// label.prev().removeClass("error").addClass("valid");
		  },
		
		  invalidHandler: function(form, validator) { 
			$("#errors:hidden").text("Please correct the highlighted errors.").fadeIn(2000);
		  },
		  
		  messages: {
		     verification: {equalTo: "Please enter the same password"}
		 }
    });
   },

   addAlphanumericValidator: function() {
	jQuery.validator.addMethod("alphanumeric", function(value, element) {
		return this.optional(element) || /^[a-zA-Z0-9]+$/i.test(value);
	}, "only alphanumeric characters please");	
   }
};

$(document).ready(function() {
    spendii.init();
    spendii.validateCreateFirstUser();
});
