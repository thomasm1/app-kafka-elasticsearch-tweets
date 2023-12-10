'use strict';

(function () {

    angular.module('app')
        .controller('IndexController', ['$q', '$scope', '$http', 'books', 'dataService', 'badgeService', '$cookies', '$cookieStore', '$log', '$route', 'currentUser', IndexController]);



    function IndexController($q, $scope, $http, dataService, $cookies, $cookieStore, $log, $route, currentUser) {

        var vm = this;
        $scope.titleLambda = "AWS Lambda POSTS";

        // AWS Lambda Call to dailytech (thomasm1) endpoint
        $scope.postBlogs = function () {
            console.log("posts hit");
            return $http({
                method: 'GET',
                // url: 'https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/dev/posts',
                    url: 'https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/PROD/posts',
                 headers: {
                    'Content-Type': 'application/json'
                },
            }).then(function successCallback(response) {
                $scope.posts = response.data;
                console.log($scope.posts);
            }, function errorCallback(response) {
                console.log($scope.posts);
            });
 
        };
      
        $scope.postBlog = function(id) {
             id = 'c208bd6d-fcdb-4a69-aa07-a90ea54f1c47';
             return $http({
                method: 'GET',
                url: `https://emfm9dpoeh.execute-api.us-east-1.amazonaws.com/dev/post/${id}?Content-Type=Application/JSON`,
                headers: {
                    'Content-Type': 'application/json'
                },
                transformResponse: transformGetBlogs,
                cache: true
            }).then(function successCallback(response) {
                $scope.post = response.data;
                console.log($scope.post);
            }, function errorCallback(response) {
                console.log($scope.post);
            })
        }

        // console.log($scope.array);

        const okToGreet = function () {
            console.log(name);
            var favoriteName = name;
            return favoriteName;
        };

        vm.favoriteName = $cookies.favoriteName;

        function asyncGreet(name) {
            // perform some asynchronous operation, resolve or reject the promise when appropriate.
            return $q(function (resolve, reject) {
                setTimeout(function () {
                    if (okToGreet(name)) {
                        resolve('Hello, ' + name + '!');
                    } else {
                        reject('Greeting ' + name + ' is not allowed.');
                    }
                }, 1000);
            });
        }

        var promise = asyncGreet('Robin Hood');
        promise.then(function (greeting) {
            console.log('Success: ' + greeting);
        }, function (reason) {
            console.log('Failed: ' + reason);
        });

    }

}());