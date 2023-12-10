'use strict';

(function() {

    angular.module('app')
        .controller('BlogsController', ['$q', 'blogs', 'dataService', 'badgeService', '$cookies', '$cookieStore', '$log', '$route', 'currentUser', BlogsController]);

 

    function BlogsController($q, blogs, dataService, badgeService, $cookies, $cookieStore, $log, $route, currentUser) {

        var vm = this;

        vm.appName = blogs.appName;

        dataService.getUserSummary()
            .then(getUserSummarySuccess);

        function getUserSummarySuccess(summaryData) {
            //$log.log(summaryData);
            vm.summaryData = summaryData;
        } 
 

        dataService.getAllBlogs()
            .then(getBlogsSuccess, null, getBlogsNotification)
            .catch(errorCallback)
            .finally(getAllBlogsComplete);

        function getBlogsSuccess(blogs) {
            //throw 'error in success handler';
            vm.allBlogs = blogs;
        }

        function getBlogsNotification(notification) {
            //console.log('Promise Notification: ' + notification);
        }

        function errorCallback(errorMsg) {
            console.log('Error Message: ' + errorMsg);
        }

        function getAllBlogsComplete() {
            //console.log('getAllBlogs has completed');
        }

        dataService.getAllReaders()
            .then(getReadersSuccess)
            .catch(errorCallback)
            .finally(getAllReadersComplete);

        function getReadersSuccess(readers) {
            vm.allReaders = readers;
        }

        function getAllReadersComplete() {
            $log.awesome('All readers retrieved');
        }

        vm.getBadge = badgeService.retrieveBadge;

        vm.favoriteBlog = $cookies.favoriteBlog;

        vm.currentUser = currentUser;

        vm.deleteBlog = function (blogID) {

            dataService.deleteBlog(blogID)
                .then(deleteBlogSuccess)
                .catch(deleteBlogError);

        };

        function deleteBlogSuccess(message) {
            $log.info(message);
            $route.reload();
        }

        function deleteBlogError(errorMessage) {
            $log.error(errorMessage);
        }

    }

}());