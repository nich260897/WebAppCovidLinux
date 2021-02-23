$(document).ready(function() {
    $("#img").attr("src", localStorage.getItem("img"));
    $(".nav-item:nth-of-type(2)").text(localStorage.getItem("name"));
    /*$(".nav-item:nth-of-type(3)").text(localStorage.getItem("email"));*/

    $("#Graphics").on("click", function () {

        $.ajax({
            url: "http://localhost:8080/WebAppCovid/userController?action=change",
            type: "POST",
            headers: {Authorization: "Bearer " + localStorage.getItem("token")}
        })
            .done(function (responseJson) {
                console.log(responseJson);
                window.location.href = "http://localhost:8080/WebAppCovid/view/graphics.jsp";

            })
            .fail(function (xhr, status, errorThrown) {
                console.log(errorThrown);
            })

    });

    $(".logout").on("click", function(){



                $.ajax({
                    url: "http://localhost:8080/WebAppCovid/userController?action=logout",
                    type: "POST",
                    headers: {Authorization: "Bearer " + localStorage.getItem("token")}
                })
                    .done(function () {

                        localStorage.removeItem("token");
                        window.location.href = "http://localhost:8080//WebAppCovid/index.jsp";

                    })
                    .fail(function (xhr, status, errorThrown) {
                        console.log(errorThrown);
                    })



    });


    $("#UploadPeriod").on("click", function () {

        console.log("UploadPeriod");

        var url = "http://localhost:8080/WebAppCovid/inputController?action=importPeriod";
        var form = $("#Period")[0];
        var data = new FormData(form);

        $.ajax({
            type: "POST",
            encType: "multipart/form-data",
            url: url,
            cache: false,
            processData: false,
            contentType: false,
            headers: {Authorization: "Bearer " + localStorage.getItem("token")},
            data: data
        })
            .done(function (msg) {
                console.log(msg);
                $(".notify").toggleClass("active");
                $("#notifyType").toggleClass("success");
                $("#peri").val(null);

                setTimeout(function(){
                    $(".notify").removeClass("active");
                    $("#notifyType").removeClass("success");
                },2000);
            })
            .fail(function (xhr, status, errorThrown) {
                console.log(errorThrown);
                $(".notify").addClass("active");
                $("#notifyType").addClass("failure");
                $("#peri").val(null);

                setTimeout(function(){
                    $(".notify").removeClass("active");
                    $("#notifyType").removeClass("failure");
                },2000);
            })

    });

    $("#UploadGeoAreas").on("click", function () {
        console.log("UploadGeoarea");

        var url = "http://localhost:8080/WebAppCovid/inputController?action=importArea";
        var form = $("#GeoArea")[0];
        var data = new FormData(form);

        $.ajax({
            type: "POST",
            encType: "multipart/form-data",
            url: url,
            cache: false,
            processData: false,
            contentType: false,
            headers: {Authorization: "Bearer " + localStorage.getItem("token")},
            data: data
        })
            .done(function (msg) {
                console.log(msg);
                $(".notify").toggleClass("active");
                $("#notifyType").toggleClass("success");
                $("#geo").val(null);

                setTimeout(function(){
                    $(".notify").removeClass("active");
                    $("#notifyType").removeClass("success");
                },2000);
            })
            .fail(function (xhr, status, errorThrown) {
                console.log(errorThrown);
                $(".notify").addClass("active");
                $("#notifyType").addClass("failure");
                $("#geo").val(null);

                setTimeout(function(){
                    $(".notify").removeClass("active");
                    $("#notifyType").removeClass("failure");
                },2000);
            })
    });

});
/*
$(document).ready(function() {

$(".graphics").click(function goGraphics() {
        window.location.href = "/WebAppCovid/view/graphics.jsp";
    });

    $("#Graphics").on("click", function () {

        $.ajax({
            url: "http://localhost:8080/WebAppCovid/userController?action=change",
            type: "POST",
            headers: {Authorization: "Bearer " + localStorage.getItem("token")},
            dataType: "json"
        })
            .done(function (responseJson) {
                console.log(responseJson);
                window.location.href = "http://localhost:8080//WebAppCovid/view/graphics.jsp";

            })
            .fail(function (xhr, status, errorThrown) {
                console.log(errorThrown);
            })

    });


    $("#UploadPeriod").on("click", function () {

        console.log("UploadPeriod");

        var url = "http://localhost:8080/WebAppCovid/inputController?action=importPeriod";
        var form = $("#Period")[0];
        var data = new FormData(form);

        $.ajax({
            type: "POST",
            encType: "multipart/form-data",
            url: url,
            cache: false,
            processData: false,
            contentType: false,
            headers: {Authorization: "Bearer " + localStorage.getItem("token")},
            data: data
        })
            .done(function (msg) {
                console.log(msg);
            })
            .fail(function (xhr, status, errorThrown) {
                console.log(errorThrown);
            })

    });

    $("#UploadGeoAreas").on("click", function () {
        console.log("UploadGeoarea");

        var url = "http://localhost:8080/WebAppCovid/inputController?action=importArea";
        var form = $("#GeoArea")[0];
        var data = new FormData(form);

        $.ajax({
            type: "POST",
            encType: "multipart/form-data",
            url: url,
            cache: false,
            processData: false,
            contentType: false,
            headers: {Authorization: "Bearer " + localStorage.getItem("token")},
            data: data
        })
            .done(function (msg) {
                console.log(msg);
            })
                .fail(function (xhr, status, errorThrown) {
                    console.log(errorThrown);
                })
        });

});
*/