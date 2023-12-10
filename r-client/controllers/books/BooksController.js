'use strict';

(function() {

    angular.module('app')
        .controller('BooksController', ['$q', 'books', 'dataService', 'badgeService', '$cookies', '$cookieStore', '$log', '$route', 'currentUser', BooksController]);

 

    function BooksController($q, books, dataService, badgeService, $cookies, $cookieStore, $log, $route, currentUser) {

        var vm = this;

        vm.appName = books.appName;
        
        function getUserSummarySuccess(summaryData) {
            //$log.log(summaryData);
            vm.summaryData = summaryData;
        } 
        dataService.getUserSummary()
            .then(getUserSummarySuccess);

     
        function getBooksSuccess(books) {
            //throw 'error in success handler';
            vm.allBooks = books;
        }

        function getBooksNotification(notification) {
            //console.log('Promise Notification: ' + notification);
        }

        function errorCallback(errorMsg) {
            console.log('Error Message: ' + errorMsg);
        }

        function getAllBooksComplete() {
            //console.log('getAllBooks has completed');
        }


        dataService.getAllBooks()
            .then(getBooksSuccess, null, getBooksNotification)
            .catch(errorCallback)
            .finally(getAllBooksComplete);


        function getReadersSuccess(readers) {
            vm.allReaders = readers;
        }

        function getAllReadersComplete() {
            $log.awesome('All readers retrieved');
        }

        dataService.getAllReaders()
            .then(getReadersSuccess)
            .catch(errorCallback)
            .finally(getAllReadersComplete);


        function deleteBookSuccess(message) {
            $log.info(message);
            $route.reload();
        }

        function deleteBookError(errorMessage) {
            $log.error(errorMessage);
        }

        vm.getBadge = badgeService.retrieveBadge;

        vm.favoriteBook = $cookies.favoriteBook;

        vm.currentUser = currentUser;

        vm.deleteBook = function (bookID) {

            dataService.deleteBook(bookID)
                .then(deleteBookSuccess)
                .catch(deleteBookError);

        };

    }

}());