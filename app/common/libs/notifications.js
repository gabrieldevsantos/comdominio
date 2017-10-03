function notifyMe(Text) {
    if (!Notification) {
        alert('Desktop notifications not available in your browser. Try Chromium.');
        return;
    }

    if (Notification.permission !== "granted")
        Notification.requestPermission();
    else {
        var notification = new Notification('Telegram APP', {
            icon: 'app/common/img/telegram_logo.png',
            body: Text
        });
    }
}