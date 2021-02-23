<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--GOOGLE-->
    <meta name="google-signin-client_id" content="814089384535-86mgd20udbi66d6r2oaq9ratp0llc4s0.apps.googleusercontent.com">
  <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
 <title>Index</title>
</head>
<body class="bg-image">
<div class="container">
    <div class="row">
        <div class="col center">
    <div class="card " style="width: 18rem;">
        <h3 class="card-title"><b>Login into your account</b></h3>
        <div class="card-body">
            <p class="card-text">Log in with your Google account</p>
            <form>
                <div class="" align="center">
                <div id="buttonLogin" class="g-signin2 bottone" data-onsuccess="onSignIn"></div>
                </div>
                <div class="text-center mt-2" >
                    <a class="small py-2" href="./view/privacy.html">Privacy</a>
                </div>

            </form>
        </div>
    </div>
    </div>
    </div>
</div>




<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script type="text/javascript" src="<c:url value="/js/jquery-3.5.1.js"/>"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<!-- Optional JavaScript -->
<script type="text/javascript" src="<c:url value="/js/check_user_information.js"/>"></script>
</body>
</html>