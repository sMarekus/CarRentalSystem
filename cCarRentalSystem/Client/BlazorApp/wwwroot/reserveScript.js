var scriptExecuted = false;

if (scriptExecuted === false) {
    scriptExecuted = true;
    console.log('Script executed for the first time.');
    initializeCarDetails();
}

function initializeCarDetails() {
        
        function formatDateToDDMMYYYY(date) {
            const options = { day: '2-digit', month: '2-digit', year: 'numeric' };
            const formattedDate = new Date(date).toLocaleDateString(undefined, options);
            return new Date(formattedDate);
        }

        const dateControl = document.getElementById("inputStart");
        const control = document.getElementById("inputEnd");
        const currentDate = new Date();
        const formattedDate = formatDateToDDMMYYYY(currentDate);

        dateControl.value = formattedDate;
        control.value = formattedDate;

        document.getElementById('openBtn').addEventListener('click', function() {
            document.getElementById('popup').style.display = 'block';
        });

        document.getElementById('closeBtn').addEventListener('click', function() {
            document.getElementById('popup').style.display = 'none';
        });

        window.addEventListener('click', function(event) {
            if (event.target === document.getElementById('popup')) {
                document.getElementById('popup').style.display = 'none';
            }});
}


