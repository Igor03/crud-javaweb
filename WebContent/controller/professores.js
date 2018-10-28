var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller("professoresController", function($scope, $http) {

	urlProfessores = 'http://localhost:8080/websystem-final/rest/professores';
	// $scope.listarProfessores = function() {
	// $http.get(urlProfessores).success(function(professores) {
	// $scope.professores = professores;
	//			
	// }).error(function(erro) {
	// alert(erro);
	// });
	// }

	// $http.get(urlProfessores).then(successCallback, errorCallback);
	//
	// function successCallback(response) {
	// // success code
	// $scope.professores = response.data;
	// }
	// function errorCallback(error) {
	// // error code
	// }

	$scope.selecionaProfessor = function(professorSelecionado) {
		$scope.professor = professorSelecionado;
	}

	$scope.limparCampos = function() {
		$scope.professor = null;
	}

	$scope.listarProfessores = function() {
		$http.get(urlProfessores).then(function(response) {
			$scope.professores = response.data;
			// console.log(response.data)
		});
	}
	// Chama a função listarProfessores()
	$scope.listarProfessores();
	
	
	
// $scope.salvar = function() {
// if ($scope.professores.codigo == null) {
// $http.post(urlProfessores, $scope.professores).success(function(professores)
// {
// $scope.professores.push($scope.professor);
// $scope.limparCampos();
// }).error(function(erro) {
// alert(erro);
// });
// }
// }
	
	
	// 
	$scope.salvar = function() {
		console.log('entrou')
		if ($scope.professor.codigo == null ) {
			console.log('entrou1')
			$http.post(urlProfessores, $scope.professor).then(function(response) {
				$scope.professores.push($scope.professor);
				console.log(response.data)
				$scope.limparCampos();
			})
		} else {
			console.log('entrou2')
			$http.put(urlProfessores, $scope.professor).then(function(response) {
				$scope.listarProfessores();
				$scope.limparCampos();
			})
		}
	}
	
	$scope.excluir = function() {
		if ($scope.professor.codigo == null) {
			alert('Selecione um registro!');
			
		} else {
			$http.delete(urlProfessores+'/'+$scope.professor.codigo).then(function(response) {
				$scope.listarProfessores();
				$scope.limparCampos();
			})
		}
	}

});
