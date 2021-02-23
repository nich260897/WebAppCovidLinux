<%@ page import="it.thinkopen.model.User" %>
<%@ page import="com.google.api.client.googleapis.auth.oauth2.GoogleIdToken" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--GOOGLE-->
    <meta name="google-signin-client_id"
          content="814089384535-86mgd20udbi66d6r2oaq9ratp0llc4s0.apps.googleusercontent.com">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../css/graphics.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <title>graphics</title>
</head>
<body class="border">
<div class="container-fluid ">

    <div class="row">
        <div class="col sidebar">

            <nav class="navbar navbar-expand-lg navbar-light">
                <a class="navbar-brand" href="#"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active ">

                            <img id="img">
                        </li>
                        <li class="nav-item active mt-2 ml-2">

                        </li>
                        <li>
                            <button class="upload" id="Dashboard">Homepage</button>
                        </li>
                    </ul>

                    <button class="btn btn-danger logout ml-auto">Logout</button>
                    <iframe id="logoutframe" src="https://accounts.google.com/logout" style="display: none"></iframe>


                </div>

            </nav>
        </div>
    </div>
</div>


<!--   <ul class="nav flex-column">
       <li class="nav-item">
           <img id="img">
       </li>
       <li>
           <button class="upload" id="Dashboard">Homepage</button>
       </li>
       <li>
           <button class="btn btn-danger logout">Logout</button>
           <iframe id="logoutframe" src="https://accounts.google.com/logout" style="display: none"></iframe>
       </li>
   </ul>
</div>
--><div class ="container">
    <div class="row">
        <div class="col">

            <button class="upload" id="renderPeriod">Render Period</button>
            <button class="upload" id="renderAreas">Render Areas</button>
            <button class="upload" id="mappa">Render Mappa</button>
            <!--<button class="btn btn-primary upload" id="renderAreas">Render Areas</button>-->
            <div class="">
                <canvas id="chartPeriod"></canvas>
            </div>
            <div class="white">
                <canvas id="GeoArea"></canvas>
            </div>
            <div class="white">
                <div id="regions_div">

                </div>
            </div>

        </div>
    </div>
</div>
</div>
</div>

</div>


<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>

<!-- Optional JavaScript -->
<script type="text/javascript" src="<c:url value="/js/chart.js"/>"></script>
</body>
</html>
