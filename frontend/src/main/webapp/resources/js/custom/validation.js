
+function () {

    var Validation = {

        validateOnEmpty: function (inputs, btns) {
            var isAnyValidationErrors = false;
            if (inputs) {
                inputs.some(function (input) {
                    if (!input.val().trim()) {
                        isAnyValidationErrors = true;

                        input.next().html('Should not be empty');
                        input.next().show();
                    } else {
                        input.next().hide();
                    }
                });
            }
            if (btns) {
                if (isAnyValidationErrors) {
                    btns.some(function (button) {
                        button.attr("disabled", true)
                    })
                } else {
                    btns.some(function (button) {
                        button.removeAttr('disabled')
                    })
                }
            }
        }
    };
    window.Validation = Validation;

}();


