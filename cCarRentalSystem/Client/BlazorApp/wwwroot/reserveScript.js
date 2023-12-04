const dateControl = document.querySelector('input[type="date"]');
var currentDateAndTime = new Date();

dateControl.value = currentDateAndTime;
const dateControl2 = document.getElementById("inputEnd");
dateControl2.value = currentDateAndTime;
document.getElementById('openBtn').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'block';
});

document.getElementById('closeBtn').addEventListener('click', function() {
    document.getElementById('popup').style.display = 'none';
});

window.addEventListener('click', function(event) {
    if (event.target === document.getElementById('popup')) {
        document.getElementById('popup').style.display = 'none';
    }
});