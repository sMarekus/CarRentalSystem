var scriptExecuted = false;

if (scriptExecuted === false) {
    console.log('Script executed for the first time.');
    initializeChangePassword();
    scriptExecuted = true;
}

function initializeChangePassword() {

    var openBtn = document.getElementById('openBtn');
    console.log(openBtn);
    if (openBtn) {
        openBtn.addEventListener('click', function() {
            document.getElementById('popup').style.display = 'block';
        });
    }
    document.getElementById('closeBtn').addEventListener('click', function() {
        document.getElementById('popup').style.display = 'none';
    });

    window.addEventListener('click', function(event) {
        if (event.target === document.getElementById('popup')) {
            document.getElementById('popup').style.display = 'none';
        }});
}