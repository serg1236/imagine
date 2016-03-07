<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring4 MVC -HelloWorld</title>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/css/materialize.min.css"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
    <link rel="stylesheet" href="/styles/main.css"/>
    <script src="/scripts/vendor/requirejs/require.js" data-main="/scripts/main.js"/></script>
</head>
<body ng-controller="MainCtrl">
    <div id="page" class="no-display">

    <header>
        <nav class="purple lighten-1" role="navigation">
            <div class="nav-wrapper container"><a id="logo-container" href="#/" class="brand-logo">Imagine<span ng-show="loginedToFb">, {{currentUser.first_name}}!</span></a>
              <ul class="right" ng-show="loginedToFb">
                <li ><a class="btn-flat white-text" ng-click="logoutFromFb()">Logout</a></li>
                <!-- <li ><a ng-click="logoutFromFb()" class="cursor-pointer"><i class="material-icons">person_pin</i></a></li> -->
              </ul>
            </div>

      </nav>
    </header>
    <main  ng-switch="loginedToFb">
        <div ng-switch-when="true">
            <!-- <div class="container"> -->
            <div class="row">
                <div class="col s12 m8 l9">
                    <br><br>
                    <div ng-view></div>
                </div>
                <!-- TODO: move to directive -->
                <div class="user-list col l3 m4 s12">
                    <user-list exclude="currentUser"></user-list>
                </div>
            </div>



        </div>
        <div ng-switch-default>
            <start-screen></start-screen>
        </div>
    </main>
    <footer class="page-footer purple lighten-1">
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="orange-text text-lighten-3" href="https://www.facebook.com/sergiy.dakhniy">Sergiy Dakhniy</a>
      </div>
    </div>
    </footer>
    </div>
    <div id="preloader" class="main-preloader">
        <div class="container">
            <div class="row center">
                <div class="preloader-wrapper large active" style="vertival-align:center">
                    <div class="spinner-layer spinner-blue-only">
                      <div class="circle-clipper left">
                        <div class="circle"></div>
                      </div><div class="gap-patch">
                        <div class="circle"></div>
                      </div><div class="circle-clipper right">
                        <div class="circle"></div>
                      </div>
                    </div>
                  </div>
            </div>
        </div>
    </div>
</body>
</html>