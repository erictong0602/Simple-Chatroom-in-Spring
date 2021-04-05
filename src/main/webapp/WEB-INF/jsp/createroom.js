$(document).ready(function(){
    $("#roomForm").submit(function(e) {

        e.preventDefault(); // avoid to execute the actual submit of the form.

        var form = {
            room_name:$("#room_name").val(),
            room_limitation:$("#room_limitation").val()
        }

        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: form, // serializes the form's elements.
            dataType: 'application/json',
            encode: true,
            success: function(data)
            {
                console.log('Submission was successful.');
                alert(data); // show response from the php script.
            },
            error: function (data) {
                console.log('An error occurred.');
                console.log(data);
            },
        });
    });
});