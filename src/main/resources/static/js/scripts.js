window.addEventListener('DOMContentLoaded', event => {
    // Create meeting modal
    const createMeeting = document.getElementById('createMeeting');
    const closeMeetingModal = document.getElementById('modalCloseButton');

    if (createMeeting && closeMeetingModal) {
        var modal = new bootstrap.Modal(document.getElementById('createMeetingModal'));

        createMeeting.addEventListener('click', event => {
            modal.show();
        });

        closeMeetingModal.addEventListener('click', event => {
            modal.hide();
        });
    }
    
    // Time constraint
    const meetingTimeField = document.getElementById('meetingTime');

    if (meetingTimeField) {
        meetingTimeField.addEventListener('blur', event => {
            if (meetingTimeField.value < meetingTimeField.min) {
                meetingTimeField.value = meetingTimeField.min;
            } else if (meetingTimeField.value > meetingTimeField.max) {
                meetingTimeField.value = meetingTimeField.max;
            }
        });
    }

    // Handle form submission to create a meeting
    const submitMeetingButton = document.getElementById('submitMeeting');

    if (submitMeetingButton) {
        submitMeetingButton.addEventListener('click', function() {
            const meetingTitle = document.getElementById('meetname').value;
            const meetingRoom = document.getElementById('meetingRoom').value;
            const meetingTime = document.getElementById('meetingTime').value;

            const meetingData = {
                title: meetingTitle,
                room: meetingRoom,
                time: meetingTime
            };

            // Send the data to the server using fetch (or AJAX)
            fetch('/api/meetings', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(meetingData)
            })
            .then(response => {
                if (response.ok) {
                    modal.hide();
                    alert('Meeting created successfully!');
                } else {
                    alert('Failed to create meeting.');
                }
            })
            .catch(error => {
                console.error('Error creating meeting:', error);
                alert('An error occurred while creating the meeting.');
            });
        });
    }

    // Form validation for registration
    const form = document.querySelector('form[action="/register"]');
    const passwordField = document.getElementById('inputPassword');
    const confirmPasswordField = document.getElementById('inputPasswordConfirm');

    form.addEventListener('submit', function(event) {
        const password = passwordField.value;
        const confirmPassword = confirmPasswordField.value;

        // Check if password meets criteria
        const passwordPattern = /^(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
        if (!passwordPattern.test(password)) {
            alert('Password must be at least 8 characters long and contain at least one number and one special character.');
            event.preventDefault(); // Prevent form submission
            return;
        }

        // Check if password and confirm password match
        if (password !== confirmPassword) {
            alert('Password and Confirm Password do not match.');
            event.preventDefault(); // Prevent form submission
            return;
        }
    });
});
