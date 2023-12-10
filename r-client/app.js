'use strict';

(function() {

    var app = angular.module('app', ['ngRoute', 'ngCookies', 'ngResource' ]);
  
    app.config(['booksProvider',   '$routeProvider', '$logProvider', '$httpProvider', '$locationProvider','$provide', function (booksProvider,  $routeProvider, $logProvider, $httpProvider, $locationProvider, $provide) {

        $provide.decorator('$log', ['$delegate', 'books', logDecorator]);
 
        booksProvider.setIncludeVersionInTitle(true);
        $logProvider.debugEnabled(true);

        $httpProvider.interceptors.push('bookLoggerInterceptor');

        $routeProvider
            .when('/', {
 
             
            }) 
            .when('/Blogs', {
                controller:'BlogsController',
                templateUrl: '/templates/blogs.html'
            })  
            .when('/_For_Cat_Eyes_Only_', {
                controller:'CatsController',
                templateUrl: '/templates/cats.html'
            })  
            .otherwise('/');
            $locationProvider.html5Mode(true);

    }]);

    app.run(['$rootScope', function($rootScope) {

        $rootScope.$on('$routeChangeSuccess', function(event, current, previous) {

         console.log('successfully changed routes'); 
         console.log(event);
         console.log(current);
         console.log(previous);
     //    console.log(rejection);
        });

        $rootScope.$on('$routeChangeError', function(event, current, previous, rejection) {

            console.log('error changing routes');

            console.log(event);
            console.log(current);
            console.log(previous);
            console.log(rejection);

        });
 
        $rootScope.$on("$routeChangeError", function(e, next, prev, err) {
            if(err === "AUTH_REQUIRED") {
            $location.path("/login");
            }
        }) 
      
    }]);
 

}());