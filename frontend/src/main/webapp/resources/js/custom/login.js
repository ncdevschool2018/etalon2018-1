/**
 * Created by anpi0316 on 15.03.2018.
 */
$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjax',
        INPUT_ID: '.jsInputId',
        INPUT_NAME: '.jsInputName',
        INPUT_PASSWORD: '.jsLoginPassword',
        INPUT_USERNAME: '.jsUsername',
        BTN_SUBMIT_LOGIN: '.jsSubmitLogin',
        SEND_DATA_BTN: '.jsSendData',
        STUDENTS_TABLE: '.jsStudentsTable',
        CONTAINER_ADDED_USER: '.jsAddedUser',
        NOTIFICATION_CREDENTIAL_INCORRECT: '.jsCredentialsIncorrectNotification'
    };

    var $usersContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $submitButton = $(ELEMENTS.BTN_SUBMIT_LOGIN),
        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $addedUserContainer = $(ELEMENTS.CONTAINER_ADDED_USER),
        $studentsTable = $(ELEMENTS.STUDENTS_TABLE),
        $sendDataBtn = $(ELEMENTS.SEND_DATA_BTN),
        $credentialNotification = $(ELEMENTS.NOTIFICATION_CREDENTIAL_INCORRECT);

    Validation.validateOnEmpty([$usernameField, $passwordField], [$submitButton]);


    $usernameField.on('blur', function () {
        Validation.validateOnEmpty([$usernameField], [$submitButton]);
    });

    $passwordField.on('blur', function () {
        Validation.validateOnEmpty([$passwordField], [$submitButton]);
    });


    $submitButton.click(function (event) {
        event.stopPropagation();

        $.ajax({
            url: 'authorize',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                username: $usernameField.val()/*,
                password: $passwordField.val()*/
            }),
            success: function (xhr) {
                console.log(xhr.status);
                $credentialNotification.hide();

                window.location.href = "/home"
            },
            error: function (xhr, textStatus) {
                xhr.status == 401 ? $credentialNotification.show() : alert('Something went wrong, try again later.');
            }
        });


    })


    $sendDataBtn.click(function (event) {
        event.stopPropagation();

        var obj = {
            id: $(ELEMENTS.INPUT_ID).val(),
            name: $(ELEMENTS.INPUT_NAME).val()
        };

        $.ajax({
            url: 'users',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedUser) {
                $addedUserContainer.text(addedUser ? addedUser.id + " | " + addedUser.name : '');
            }

        });
    });

// bootstrap-table documentation http://bootstrap-table.wenzhixin.net.cn/documentation
    $.ajax({
        url: 'students',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (students) {
            $studentsTable.bootstrapTable('load', students);
            $studentsTable.on('all.bs.table', function (e, clickedUser) {
                console.log(clickedUser);
            });


        }

    });


});