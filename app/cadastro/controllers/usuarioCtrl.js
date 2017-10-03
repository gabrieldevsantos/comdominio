angular.module('Emmapp').controller('usuarioCtrl',
    function ($http, $routeParams, $location, $log, usuarioService) {
        var pc = this;
        pc.id = $routeParams.id;
        pc.lista = [];
        pc.dadosUsuario = [];
        pc.successAlert = true;

       /*
        pc.lista = usuarioService.Listar().then(function (result) {
            pc.lista = result;
        });
        */

        pc.listar = function listar() {
            //Testando com objeto local 
            pc.lista  = [ 
                {
                    "id":1,   
                    "nome":"Matheus Murta",
                    "cpf":"11804492663",
                    "email":"matheus_mge@hotmail.com",
                    "codigo":"3015724",
                    "observacao":"obs sobre este cara",
                    "ativo":true
                },
                {
                    "id":3,   
                    "nome":"Alex",
                    "cpf":"55804492663",
                    "email":"matheus_mge@hotmail.com",
                    "codigo":"3015724",
                    "observacao":"obs sobre este cara",
                    "ativo":true
                },
                {
                    "id":4,   
                    "nome":"Bruno Victor",
                    "cpf":"99804492663",
                    "email":"brunp@hotmail.com",
                    "codigo":"3015724",
                    "observacao":"obs sobre este cara",
                    "ativo":true
                },
                {
                    "id":5,   
                    "nome":"Lucian",
                    "cpf":"66804492663",
                    "email":"matheus_mge@hotmail.com",
                    "codigo":"3015724",
                    "observacao":"obs sobre este cara",
                    "ativo":true
                }
                ,
                {
                    "id":6,   
                    "nome":"Artur",
                    "cpf":"77804492663",
                    "email":"artur@hotmail.com",
                    "codigo":"3015724",
                    "observacao":"obs sobre este cara",
                    "ativo":true
                }
                , {
                    "id":7,   
                    "nome":"Gabriel",
                    "cpf":"12804492663",
                    "email":"gabriel@hotmail.com",
                    "codigo":"3015724",
                    "observacao":"obs sobre este cara",
                    "ativo":true
                }
        ];
            return pc.lista;
        };

        pc.Recuperar = function Recuperar() {
            /*
            pc.dadosUsuario = usuarioService.Recuperar(pc.id).then(function (result) {
                pc.dadosUsuario = result;
            });
            */
            
            //Testando com objeto local 
            pc.dadosUsuario = 
            { 
                "id":1, 
                "nome":"matheus",
                "cpf":"11804492663",
                "email":"matheus_mge@hotmail.com",
                "codigo":"3015724",
                "observacao":"obs sobre este cara"
            };
            return pc.dadosUsuario;
        };

        pc.Salvar = function Salvar() {
            if (pc.id == 0)
                usuarioService.Inserir(pc.dadosUsuario).then(function (result) {
                    $location.path("/usuario");
                })
            else
                usuarioService.Editar(pc.dadosUsuario, pc.id).then(function (result) {
                    $location.path("/usuario");
                })
        };

        pc.Excluir = function Excluir() {
            usuarioService.Excluir(pc.id).then(function (result) {
                $location.path("/usuario");
            })
        };
    });
