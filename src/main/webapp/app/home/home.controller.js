(function() {
    'use strict';

    angular
        .module('baseappApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'Scheme_master', 'Agent_master', 'Policy_details'];

    function HomeController ($scope, Principal, LoginService, $state, Scheme_master, Agent_master, Policy_details) {
        var vm = this;

        vm.account = null;
        vm.getCommision=getCommision;
        vm.save = save;
        vm.isAuthenticated = null;

        vm.policy_details = {
            date: null,
            customerName: null,
            policyAmount: null,
            commission: null,
            schemeNo: null,
            agentNo: null,
            policyNo: null,
            id: null
        };
//        vm.login = LoginService.open;
//        vm.register = register;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        loadAll();

        function getCommision()
        {
            vm.commission = JSON.parse(vm.scheme).commission;
            vm.policy_details.commission = vm.policy_details.policyAmount*vm.commission/100;
            console.log(vm.policy_details.commission);
        }

        function loadAll()
        {
            Policy_details.query(function(result){
                vm.policy_details.policyNo = result.length+1;
            });

            Agent_master.query(function(result){
                vm.agent_masters = result;
            });

            Scheme_master.query(function(result){
                vm.scheme_masters = result;
            })
        }

        function save () {
            vm.isSaving = true;
            vm.policy_details.schemeNo = JSON.parse(vm.scheme).schemNo;
            if (vm.policy_details.id !== null) {
                Policy_details.update(vm.policy_details, onSaveSuccess, onSaveError);
            } else {
                console.log(vm.policy_details);
                Policy_details.save(vm.policy_details, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('baseappApp:policy_detailsUpdate', result);
            $state.go("dashboard");
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.date = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }

//        getAccount();
//
//        function getAccount() {
//            Principal.identity().then(function(account) {
//                vm.account = account;
//                vm.isAuthenticated = Principal.isAuthenticated;
//            });
//        }
//
//        function register () {
//            $state.go('register');
//        }
    }
})();
