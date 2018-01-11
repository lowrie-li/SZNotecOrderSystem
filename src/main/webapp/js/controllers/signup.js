'use strict';

// signup controller
app.controller('SignupFormController', function($scope,$state,$http,$resource,Base64,$localStorage) {
    $scope.user = {};
    $scope.authError = null;
    $scope.login = function() {
        $scope.authError = "";
        // var authdata = Base64.encode($scope.user.username + ':' + $scope.user.password);
        $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
        var $com = $resource($scope.app.host + "/user/signin");
        $com.get(function(data){
            $scope.session_user = $localStorage.user = data;
            $localStorage.auth = authdata;
            $state.go('app.dashboard-v1');
        },function(){
            $scope.authError = data.errMsg;
        })
    }
  })
 ;