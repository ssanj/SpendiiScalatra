$(document).ready(function() {
    spendii.init();
});

var spendii = {
    init : function() {
        this.hideNotification("messages");
        this.hideNotification("errors");
    },

    hideNotification : function(noticeId) {
        var notice = $("#" + noticeId);
        if (notice.text().trim() == "N/A") notice.hide(); else notice.show();
    }
};
