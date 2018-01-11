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

/* Controllers */
  // signin controller
app.controller('SigninFormController', function($scope,$state,$http,$resource,Base64,$localStorage) {
    $scope.user = {};
    $scope.authError = null;
    $scope.login = function() {
        $scope.authError = "";
        // var authdata = Base64.encode($scope.user.uid + ':' + $scope.user.pwd);
        var authdata = $scope.user.uid + ':' + $scope.user.pwd;
        $http.defaults.headers.common['Authorization'] = authdata;
        console.log(authdata);
        var $com = $resource($scope.app.host + "/user/signin");
        $com.get(function(data){
            $scope.session_user = $localStorage.user = data;
            $localStorage.auth = authdata;
            $state.go('app.dashboard-v1');
        },function(data){
            $scope.authError = data.errMsg;
        })
    }
});


// signup controller
app.controller('SignupFormController', function($scope,$state,$http,$resource,Base64) {
    $scope.user = {};
    $scope.authError = null;
    $scope.signup = function() {
        $scope.authError = "";
        var authdata = $scope.user.name + ":" + $scope.user.phone + ':' + $scope.user.pwd1;
        // var authdata = Base64.encode($scope.user.username + ':' + $scope.user.password);
        $http.defaults.headers.common['Authorization'] = authdata;
        console.log(authdata);
        var $com = $resource($scope.app.host + "/user/signin");
        $com.get(function(data){
            data.errMsg = "注册成功，请登录完善用户信息";
            $scope.authError = data.errMsg;
        },function(data){
            data.errMsg = "注册失败";
            $scope.authError = data.errMsg;
        })
    }
});

app.factory('Base64',function(){
    var keyStr = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=';
    return {
        encode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            do {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);

                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;

                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }

                output = output +
                    keyStr.charAt(enc1) +
                    keyStr.charAt(enc2) +
                    keyStr.charAt(enc3) +
                    keyStr.charAt(enc4);
                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";
            } while (i < input.length);

            return output;
        },

        decode: function (input) {
            var output = "";
            var chr1, chr2, chr3 = "";
            var enc1, enc2, enc3, enc4 = "";
            var i = 0;

            // remove all characters that are not A-Z, a-z, 0-9, +, /, or =
            var base64test = /[^A-Za-z0-9\+\/\=]/g;
            if (base64test.exec(input)) {
                window.alert("There were invalid base64 characters in the input text.\n" +
                    "Valid base64 characters are A-Z, a-z, 0-9, '+', '/',and '='\n" +
                    "Expect errors in decoding.");
            }
            input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");

            do {
                enc1 = keyStr.indexOf(input.charAt(i++));
                enc2 = keyStr.indexOf(input.charAt(i++));
                enc3 = keyStr.indexOf(input.charAt(i++));
                enc4 = keyStr.indexOf(input.charAt(i++));

                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;

                output = output + String.fromCharCode(chr1);

                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }

                chr1 = chr2 = chr3 = "";
                enc1 = enc2 = enc3 = enc4 = "";

            } while (i < input.length);

            return output;
        }
    };
});