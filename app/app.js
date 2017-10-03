var module = angular.module('Emmapp', ['ngRoute', 'ui.bootstrap']);

module.config(['$routeProvider', '$locationProvider', '$httpProvider', function ($routeProvider, $locationProvider, $httpProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'app/common/template/default.html'
        })
        //Usuario
        .when('/usuario', {
            controller: 'usuarioCtrl',
            controllerAs: 'usuario',
            templateUrl: 'app/cadastro/templates/usuario/list.html'
        })
        .when('/usuario/edit/:id', {
            controller: 'usuarioCtrl',
            controllerAs: 'usuario',
            templateUrl: 'app/cadastro/templates/usuario/edit.html'
        })
        .when('/usuario/delete/:id', {
            controller: 'usuarioCtrl',
            controllerAs: 'usuario',
            templateUrl: 'app/cadastro/templates/usuario/delete.html'
        })
        .when('/usuario/view/:id', {
            controller: 'usuarioCtrl',
            controllerAs: 'usuario',
            templateUrl: 'app/cadastro/templates/usuario/view.html'
        })

        .otherwise({
            redirectTo: 'app/common/template/default.html'
        });

    $httpProvider.interceptors.push('myHttpInterceptor');

}]);

module.constant("API_URL", {
    "url": "api-url-aqui"
});

