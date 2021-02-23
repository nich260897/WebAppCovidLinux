<%@ page import="it.thinkopen.model.User" %>
<%@ page import="com.google.api.client.googleapis.auth.oauth2.GoogleIdToken" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

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
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <title>Dashboard</title>
</head>

<body leftmargin="0" topmargin="0"  marginleft="0" margintop="0">

<div class="container-fluid contenitore">
    <header>
        @GRUPPO1
    </header>
    <div class="d-flex flex-row riga">
        <div class="col-md-3 sidebar">
            <ul class="nav flex-column nomeCognomeEmail">
                <li class="nav-item">
                    <img id="img">
                </li>
                <li class="nav-item">

                </li>
                <!--<li class="nav-item">

                </li>-->
                <li>
                    <button class="btn btn-danger logout">Logout</button>
                    <iframe id="logoutframe" src="https://accounts.google.com/logout" style="display: none"></iframe>
                </li>
            </ul>
        </div>
        <div class="col-md colonna">
            WebAppCovid<br>
            <div class="col pulsanti">
                <form action="" method=post enctype="multipart/form-data" id="GeoArea">
                    <input type="file" class="inserisciFile" name="file" id="geo"/>

                    <input type="button" class="upload" name="button1" value="Upload geo areas" id="UploadGeoAreas"/>
                </form>

                <form action="" method=post enctype="multipart/form-data" id="Period">
                    <input type="file" class="inserisciFile" name="file" id="peri"/>

                    <input type="button" class="upload" name="button2" value="Upload period" id="UploadPeriod"/>
                </form>

                <button class="upload2" id="Graphics">Graphics</button>
                <div class="notify"><span id="notifyType" class=""></span></div>
            </div>

        </div>
    </div>
    <footer>
        @GRUPPO1
    </footer>
</div>



<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<!-- Optional JavaScript -->
<script type="text/javascript" src="<c:url value="/js/dashboard.js"/>"></script>
</body>
</html>
