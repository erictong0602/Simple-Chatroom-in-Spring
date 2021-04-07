alert("loaded");

$("#userForm").on("submit",function(e) {

        e.preventDefault(); // avoid to execute the actual submit of the form.

        var form = {
            user_Name: $("#user_name").val(),
            user_Password: $("#user_password").val()
        }
        console.log(form);

        $.ajax({
            type: "POST",
            url: "/user/addUser",
            contentType: 'application/json',
            data: JSON.stringify(form), // serializes the form's elements.
            processData: false,
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
