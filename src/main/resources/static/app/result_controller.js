'use strict';


App.controller('ResultController', ['$scope', 'ResultService', function($scope, ResultService) {
	
	$scope.partialResults = {
			optionOnePercentage: '',
			optionTwoPercentage: ''
		};
	
	self.partialResults = function() {
		ResultService.listPartialVotes().then(
		function(response){
			$scope.partialResults.optionOnePercentage = response.data.optionOnePercentage;
			$scope.partialResults.optionTwoPercentage = response.data.optionTwoPercentage;
		}, 
		function(errResponse) {
			console.error('Error listing partial results');
		});
	};
	
	self.partialResults();
	
}]);
