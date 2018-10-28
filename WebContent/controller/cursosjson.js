var cursoModulo = angular.module('cursoModulo', []);

cursoModulo.controller("cursoController", function($scope, $http) {
    $http.get('controller/cursosjson.json').then(function(response) {
        $scope.cursos = response.data.cursos;
    });
});