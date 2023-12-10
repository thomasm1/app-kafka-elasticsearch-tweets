'use strict';

(function() {

    var app = angular.module('app', ['ngRoute', 'ngCookies', 'ngResource' ]);
 
    app.config(['$routeProvider', function($routeProvider) {
        $routeProvider 
        .when('/home', {
            template: '<home expenses-in-order="$resolve.expensesInOrder" categories="$resolve.categories"></home>',
            resolve: {
              "currentAuth": function(auth) {
                return auth.$requireSignIn();
              },
              "expensesInOrder": function(fbRef, expenseList, auth) {
                return auth.$requireSignIn().then(function() {
                  var query = fbRef.getExpensesRef().orderByChild("date");
                  return expenseList(query).$loaded();
                })
              },
              "categories": function(fbRef, $firebaseArray, auth) {
                return auth.$requireSignIn().then(function() {
                  var categoriesQuery = fbRef.getCategoriesRef().orderByChild("name");
                  return $firebaseArray(categoriesQuery).$loaded();
                })
              }
            }
          })   
          .when('/userpref', {
            template: '<edit-user-pref user-preferences="$resolve.userPreferences"></edit-user-pref>',
            resolve: {
              currentAuth: function(auth) {
                return auth.$requireSignIn();
              },
              userPreferences: function(fbRef, $firebaseObject, auth) {
                return auth.$requireSignIn().then(function() {
                  return new $firebaseObject(fbRef.getPreferencesRef()).$loaded()  
                })
                
              }
            }
          }) 
          .when('/categories', {
            template: '<category-list categories="$resolve.categories"></category-list>',
            resolve: {
              "currentAuth": function(auth) {
                return auth.$requireSignIn();
              },
              "categories": function(fbRef, $firebaseArray, auth) {
                return auth.$requireSignIn().then(function() {
                  var categoriesQuery = fbRef.getCategoriesRef().orderByChild("name");
                  return $firebaseArray(categoriesQuery).$loaded();
                })
              }
            }
          }) 
          .when('/login', {
            template: '<login current-auth="$resolve.currentAuth"></login>',
            resolve: {
              currentAuth: function(auth) {
                return auth.$waitForSignIn();
              }
            }
          })
          .when('/logout', {
            template: '<logout></logout>'
          }) 
           .otherwise({ redirectTo: '/' }); // go to the welcome page
     }
     ]);
     
    app.provider('books', ['constants', function (constants) {

        var includeVersionInTitle = false;
        this.setIncludeVersionInTitle = function (value) {
            includeVersionInTitle = value;
        };

        this.$get = function () {

            var appName = constants.APP_TITLE;
            var version = constants.APP_VERSION;

            if (includeVersionInTitle) {
                appName += ' ' + version;
            }

            var appDesc = constants.APP_DESCRIPTION;

            return {
                appName: appName,
                appDesc: appDesc
            };
        };

    }]);
  
    app.config(['booksProvider',   '$routeProvider', '$logProvider', '$httpProvider', '$locationProvider','$provide', function (booksProvider,  $routeProvider, $logProvider, $httpProvider, $locationProvider, $provide) {

        $provide.decorator('$log', ['$delegate', 'books', logDecorator]);
 
        booksProvider.setIncludeVersionInTitle(true);
        $logProvider.debugEnabled(true);

        $httpProvider.interceptors.push('bookLoggerInterceptor');

        $routeProvider
            .when('/', {
               template: '<div><style>div.card-header {display:none;} button {z-index:1001 !important;} form {z-index:1001 !important;}</style></div>',
              
                controller: 'IndexController',
             
            }) 
            .when('/Books', {
                templateUrl: 'templates/books.html',
                controller: 'BooksController',
                controllerAs: 'books'
            })
            .when('/AddBook', {
                templateUrl: 'templates/addBook.html',
                controller: 'AddBookController',
                controllerAs: 'bookAdder'
            })
            .when('/archives', {
                controller:'ArchivesController',
                templateUrl: 'templates/archives.html'
            })  
            .when('/Blogs', {
                controller:'BlogsController',
                templateUrl: '/templates/blogs.html'
            })  
            .when('/_For_Cat_Eyes_Only_', {
                controller:'CatsController',
                templateUrl: '/templates/cats.html'
            })  
            .when('/EditBook/:bookID', {
                templateUrl: 'templates/editBook.html',
                controller: 'EditBookController',
                controllerAs: 'bookEditor'
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

    function logDecorator($delegate, books) {

        function log(message) {
            message += ' - ' + new Date() + ' (' + books.appName + ')';
            $delegate.log(message);
        }

        function info(message) {
            $delegate.info(message);
        }

        function warn(message) {
            $delegate.warn(message);
        }

        function error(message) {
            $delegate.error(message);
        }

        function debug(message) {
            $delegate.debug(message);
        }

        function awesome(message) {
            message = 'Awesome!!! - ' + message;
            $delegate.debug(message);
        }

        return {
            log: log,
            info: info,
            warn: warn,
            error: error,
            debug: debug,
            awesome: awesome
        };

    }

}());