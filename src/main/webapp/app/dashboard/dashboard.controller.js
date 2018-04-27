(function () {
    'use strict';

    angular
        .module('baseappApp')
        .controller('DashboardController', DashboardController);

    DashboardController.$inject = ['$scope', 'DashboardService','Policy_details'];

    function DashboardController($scope, DashboardService, Policy_details) {
        var vm = this;

        loadAll();


        function loadAll(){
           Policy_details.query(function(result){
             vm.policy_details=result;
           })
        }

    }
})();
