(function () {

    angular.module('app')
        .controller('EditBlogController', ['$routeParams', 'blogs', '$cookies', '$cookieStore', 'dataService', '$log', '$location', 'currentUser', EditBlogController]);

    function EditBlogController($routeParams, blogs, $cookies, $cookieStore, dataService, $log, $location, currentUser) {

        var vm = this;

        dataService.getBlogByID($routeParams.blogID)
            .then(getBlogSuccess)
            .catch(getBlogError);

        function getBlogSuccess(blog) {
            vm.currentBlog = blog;
            currentUser.lastBlogEdited = vm.currentBlog;
        }

        function getBlogError(reason) {
            $log.error(reason);
        }

        vm.setAsFavorite = function() {

            $cookies.favoriteBlog = vm.currentBlog.title;

        };

        vm.saveBlog = function() {

            dataService.updateBlog(vm.currentBlog)
                .then(updateBlogSuccess)
                .catch(updateBlogError);

        };

        function updateBlogSuccess(message) {
            $log.info(message);
            $location.path('/');
        }

        function updateBlogError(errorMessage) {
            $log.error(errorMessage);
        }


    }

}());