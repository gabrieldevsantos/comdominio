angular.module('Emmapp').factory("usuarioService", function (API_URL, $http) {

    var usuarioService = {};
    var dadosUsuario = [];
    var id = 0;

    usuarioService.Listar = function () {
        var promise = $http({
            method: 'GET',
            url: API_URL.url + '/api/v1/usuario'
        })
            .then(function (response) {
                return response.data.content;
            },
            function (response) {
                return response.data;
            });

        return promise;
    };

    usuarioService.Recuperar = function (id) {
        var promise = $http({
            method: 'GET',
            url: API_URL.url + '/api/v1/usuario/' + id
        })
            .then(function (response) {
                return response.data.content;
            },  
            function (response) {
                return response.data;
            });
        return promise;
    };

    usuarioService.Inserir = function (dadosUsuario) {
        var promise = $http({
            method: 'POST',
            url: API_URL.url + '/api/v1/usuario',
            data: dadosUsuario

        })
            .then(function (response) {
                return response.data;
            },
            function (response) {
                return response.data;
            });

        return promise;
    };  

    usuarioService.Editar = function (dadosUsuario, id) {
        var promise = $http({
            method: 'PUT',
            url: API_URL.url + '/api/v1/usuario/' + id,
            data: dadosUsuario
        })
            .then(function (response) {
                return response.data;
            },
            function (response) {
                return response.data;
            });
        return promise;
    };

    usuarioService.Excluir = function (id) {
        var promise = $http({
            method: 'DELETE',
            url: API_URL.url + '/api/v1/usuario/' + id
        })
            .then(function (response) {
                return response.data;
            },
            function (response) {
                return response.data;
            });
        return promise;
    };

    return usuarioService;
});