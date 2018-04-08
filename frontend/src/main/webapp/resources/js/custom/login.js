/**
 * Created by anpi0316 on 15.03.2018.
 */
$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjax',
        INPUT_ID: '.jsInputId',
        INPUT_NAME: '.jsInputName',
        SEND_DATA_BTN: '.jsSendData',
        STUDENTS_TABLE: '.jsStudentsTable',
        CONTAINER_ADDED_USER: '.jsAddedUser'
    };

    var $usersContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $addedUserContainer = $(ELEMENTS.CONTAINER_ADDED_USER),
        $studentsTable = $(ELEMENTS.STUDENTS_TABLE),
        $sendDataBtn = $(ELEMENTS.SEND_DATA_BTN);

    function sorting(A){
        alert(A);
    }

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

        }

    });


});