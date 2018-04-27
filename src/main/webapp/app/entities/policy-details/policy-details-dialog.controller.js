(function() {
    'use strict';

    angular
        .module('baseappApp')
        .controller('Policy_detailsDialogController', Policy_detailsDialogController);

    Policy_detailsDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Policy_details'];

    function Policy_detailsDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Policy_details) {
        var vm = this;

        vm.policy_details = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.policy_details.id !== null) {
                Policy_details.update(vm.policy_details, onSaveSuccess, onSaveError);
            } else {
                Policy_details.save(vm.policy_details, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('baseappApp:policy_detailsUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.date = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
