(function() {

    angular.module('app')
        .controller('AddBlogController', ['$log', '$location', 'dataService', AddBlogController]);

    function AddBlogController($log, $location, dataService) {

        var vm = this;

        vm.newBlog = {};

        vm.addBlog = function () {

            dataService.addBlog(vm.newBlog)
                .then(addBlogSuccess)
                .catch(addBlogError);

        };

        function addBlogSuccess(message) {
            $log.info(message);
            $location.path('/Blogs');
        }

        function addBlogError(errorMessage) {
            $log.error(errorMessage);
        }

    }

}());