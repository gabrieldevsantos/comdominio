angular.module('Emmapp').factory('myHttpInterceptor', ['$q', '$location', '$rootScope',

function httpInterceptor($q, $location, $rootScope) {

        console.log('instanciado');

        return {
            'request': function (config) {
                $rootScope.hasError = false;
                return config;
            },

            'requestError': function (rejection) {
                console.log('ERRO');
                if (canRecover(rejection)) {
                    return responseOrNewPromise
                }
                return $q.reject(rejection);
            },

            'response': function (response) {
                console.log('OK');
                return response;
            },

            'responseError': function (rejection) {
                console.log('erro');
                console.log(rejection);
                $rootScope.hasError = true;
                $rootScope.ErrorMessage = rejection.data.message;
                console.log($rootScope.ErrorMessage);

                return $q.reject(rejection);
            }
        };

        /* console.log('instanciado');
 
         return function (promise) {
 
             var success = function (response) {
                 console.log('OK');
                 return response;
             };
 
             var error = function (response) {
                 console.log('erro');
                 if (response.status === 404) {
                     console.log("peguei o erro 404");
                     $location.url('/usuario');
                     console.log(response.status);
                 } else if (response.status === 500) {
                     console.log("peguei o erro 500");
                     $location.url('/usuario');
                 }
                 return $q.reject(response);
             };
 
             return promise.then(success, error);
 
         };*/


    }
]);
