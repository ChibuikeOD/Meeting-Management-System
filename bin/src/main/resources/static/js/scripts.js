/*!
    * Start Bootstrap - SB Admin v7.0.7 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2023 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */

window.addEventListener('DOMContentLoaded', event => {
    // Create meeting modal
    const createMeeting = document.body.querySelector('#createMeeting');
    const closeMeetingModal = document.body.querySelector('#modalCloseButton');

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
    const meetingTimeField = document.body.querySelector('#meetingTime');

    if (meetingTimeField) {
        meetingTimeField.addEventListener('blur', event => {
            console.log(meetingTimeField.value);
            if (meetingTimeField.value < meetingTimeField.min) {
                meetingTimeField.value = meetingTimeField.min;
            } else if (meetingTimeField.value > meetingTimeField.max) {
                meetingTimeField.value = meetingTimeField.max;
            }
        });
    }
});
