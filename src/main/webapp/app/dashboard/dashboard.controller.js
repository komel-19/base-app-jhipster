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
           getAgentScheme();
        }

        function getAgentScheme()
        {
            DashboardService.query(function(result){
                vm.agentSchemes = result;
            });

            DashboardService.query({agentNo:'12121212'},function(result){
                vm.agentCommission = result;
            });
        }

    }
})();
