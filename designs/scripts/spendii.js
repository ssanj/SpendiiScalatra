$(document).ready(function() {
    init();
});

function init() {
    hideNotification("messages");
    hideNotification("errors");
}

function hideNotification(noticeId) {
    var notice = $("#" + noticeId);
    if (notice.text().trim() == "N/A") notice.hide(); else notice.show();
}
