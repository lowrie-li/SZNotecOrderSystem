'use strict';

/* Controllers */
// loading controller
app.controller('LoadingController',function($scope,$resource,$state,$localStorage){
    var $com = $resource($scope.app.host + "/user/signin");
    $com.get(function(data){
        $scope.session_user = $localStorage.user = data;
        $state.go('app.dashboard-v1');
    },function(){
        $state.go('access.signin');
    })
});