function onSignIn(googleUser) {

    var profile = googleUser.getBasicProfile();
    var idToken = googleUser.getAuthResponse().id_token;

    console.log("GOOGLE_USER: " + JSON.stringify(googleUser));
    console.log("ID_TOKEN: " + idToken);
    console.log("--------------");
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

    $.ajax({
        url: "http://localhost:8080/WebAppCovid/userController?action=validate",
        type: "POST",
        headers: {Authentication: "Bearer " + idToken},
        dataType: "json"
    })
        .done(function (responseJson) {
            console.log(responseJson);

            localStorage.setItem("token", responseJson["jwt"]);
            localStorage.setItem("name", profile.getName());
            localStorage.setItem("img", profile.getImageUrl());
            localStorage.setItem("email", profile.getEmail());
            window.location.href = "http://localhost:8080/WebAppCovid/view/dashboard.jsp";
            console.log(localStorage.getItem("token"));
            console.log(localStorage.getItem("name"));

        })
        .fail(function (xhr, status, errorThrown) {
            console.log(errorThrown);
        })
}
