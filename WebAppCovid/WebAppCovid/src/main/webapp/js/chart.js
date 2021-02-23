$(document).ready(function() {
    $("#img").attr("src", localStorage.getItem("img"));
    $(".nav-item:nth-of-type(2)").text(localStorage.getItem("name"));
    /*$(".nav-item:nth-of-type(3)").text(localStorage.getItem("email"));*/

    $("#Dashboard").on("click", function () {

        $.ajax({
            url: "http://localhost:8080/WebAppCovid/userController?action=change_home",
            type: "POST",
            headers: {Authorization: "Bearer " + localStorage.getItem("token")}
        })
            .done(function (responseJson) {
                console.log(responseJson);
                window.location.href = "http://localhost:8080//WebAppCovid/view/dashboard.jsp";

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
                window.location.href = "http://localhost:8080/WebAppCovid/index.jsp";

            })
            .fail(function (xhr, status, errorThrown) {
                console.log(errorThrown);
            })



    });



    $("#renderPeriod").on("click", function () {
        $.ajax({
            url: "http://localhost:8080/WebAppCovid/periodController?action=calendar",
            type: "POST",
            dataType: "json"

        })
            .done(function(responsePeriod) {
                renderPeriod(responsePeriod["num_search"], responsePeriod["weeks"]);
            })
            .fail(function(xhr, status, errorThrown){
                console.log("Error: " + errorThrown);
            });
    });

    $("#renderAreas").on("click", function () {
        $.ajax({
            url: "http://localhost:8080/WebAppCovid/areasController?action=globe",
            type: "POST",
            dataType: "json"

        })
            .done(function(responseAreas) {
                renderAreas(responseAreas["num_search"], responseAreas["countries"]);
            })
            .fail(function(xhr, status, errorThrown){
                console.log("Error: " + errorThrown);
            });
    });

    google.charts.load('current', {
        'packages':['geochart'], 'language' : 'it',
        // Note: you will need to get a mapsApiKey for your project.
        // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
        'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
    });
    google.charts.setOnLoadCallback(drawRegionsMap);
});

function renderPeriod(num_period, weeks){
    var ctx = $("#chartPeriod")[0].getContext("2d");
    console.log(num_period[0]);


    var cartFloat = new Chart(ctx, {
        type: 'line',
        data: {
            labels: weeks,
            datasets: [{
                label: 'Week',
                data: num_period,
                borderColor: 'rgba(153, 51, 255, 1)',
                backgroundColor: 'rgba(163, 45, 192, 0.2)',
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                    }
                }]
            }
        },

    });
}

function renderAreas(num_areas, countries){
    var ctx = $("#GeoArea")[0].getContext("2d");
    console.log(num_areas[0]);






    var cartFloat = new Chart(ctx, {
        type: 'line',
        data: {
            labels: countries,
            datasets: [{
                label: 'searches',
                data: num_areas,
                borderColor: 'rgba(153, 51, 255, 1)',
                backgroundColor: 'rgba(163, 45, 192, 0.2)',
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true,
                    }
                }]
            }
        },

    });
}





function drawRegionsMap() {

    $.ajax({
        url: "http://localhost:8080/WebAppCovid/areasController?action=globe",
        type: "POST",
        headers: {Authorization: "Bearer " + localStorage.getItem("token")},
        dataType: "json"

    })
        .done(function(responseAreas) {
            var countries = responseAreas["countries"];
            var num_search = responseAreas["num_search"];

            var i;
            var chartData = [];
            chartData.push(['Country', 'Number of Searches']);

            for (i=0; i < countries.length; i++){
                chartData.push([countries[i],num_search[i]]);
            }
            var data = google.visualization.arrayToDataTable(chartData);
            var options = {

                backgroundColor: 'rgba(163, 45, 192, 0.2)',
                colors: ['#efbbff', '#d896ff', '#be29ec', '#800080', '#660066']
            };

            var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

            chart.draw(data, options);
        })
        .fail(function(xhr, status, errorThrown){
            console.log("Error: " + errorThrown);
        });

}

/*
$("#renderAreas").on("click", function () {

        $.ajax({
            url: "http://localhost:8080/WebAppCovid/areasController?action=globe",
            type: "GET",
            dataType: "json"

        })
            .done(function(responseAreas) {
                renderAreas(responseAreas["countries"], responseAreas["num_search"]);
            })
            .fail(function(xhr, status, errorThrown){
                console.log("Error: " + errorThrown);
            });
    });

    function renderAreas(countries,num_searches) {
    google.charts.load('current', {
    'packages':['geochart'],
    // Note: you will need to get a mapsApiKey for your project.
    // See: https://developers.google.com/chart/interactive/docs/basic_load_libs#load-settings
    'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
});

            google.charts.setOnLoadCallback(drawRegionsMap());
    function drawRegionsMap(){
    var data = google.visualization.arrayToDataTable([
        ["Country", "Number of Searches"],
        [countries[0], num_searches[0]]
    ]);

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Task');
        data.addColumn('number', 'Hours per Day');
        data.insertRows([countries, num_searches
        ]);

    var options = {
        backgroundColor: 'rgba(163, 45, 192, 0.2)',
        colors: ['#660066', '#800080', '#be29ec', '#d896ff', '#efbbff']
    };

    var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

    chart.draw(data, options);
}
}
*/
