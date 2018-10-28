var cursosModulo = angular.module('cursoModulo', []);

cursosModulo.controller("cursoController", function($scope, $http) {

	urlCursos = 'http://localhost:8080/websystem-final/rest/cursos';
	urlProfessores = 'http://localhost:8080/websystem-final/rest/professores';

	$scope.selecionaCurso = function(cursoSelecionado) {
		$scope.curso = cursoSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.curso = null;
	}

	$scope.listarCursos = function() {
		$http.get(urlCursos).then(function(response) {
			$scope.cursos = response.data;
			// console.log(response.data)
		});
	}
	
	$scope.listarProfessores = function() {
		$http.get(urlProfessores).then(function(response) {
			$scope.professores = response.data;
			// console.log(response.data)
		});
	}
	
	// Chama a função listarcursos()
	$scope.listarCursos();
	$scope.listarProfessores();
	
	
	
	// 
	$scope.salvar = function() {
		console.log($scope.curso.codigo)
		if ($scope.curso.codigo == null ) {
			console.log('entrou1')
			$http.post(urlCursos, $scope.curso).then(function(response) {
				$scope.cursos.push($scope.curso); // Insere em cursos
				console.log(response.data)
				$scope.limparCampos();
			})
		} else {
			console.log('entrou2')
			$http.put(urlCursos, $scope.curso).then(function(response) {
				$scope.listarCursos();
				$scope.limparCampos();
			})
		}
	}
	
	$scope.excluir = function() {
		if ($scope.curso.codigo == null) {
			alert('Selecione um registro!');
			
		} else {
			$http.delete(urlCursos+'/'+$scope.curso.codigo).then(function(response) {
				$scope.listarCursos();
				$scope.limparCampos();
			})
		}
	}

});
