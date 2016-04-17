'use strict';

App.controller('VoteController', ['$scope', '$window', '$location', 'VoteService', function($scope, $window, $location, VoteService) {
			var self = this;
			self.vote = {
				id : null,
				option : '',
				voteDate : ''
			};
			self.partialResults = {
					optionOnePercentage: '',
					optionTwoPercentage: ''
				};

			$scope.setVote = function(option){
				self.vote.option = option;
				VoteService.submitVote(self.vote).then(
				function(response){
					self.partialResults.optionOnePercentage = response.data.optionOnePercentage;
					self.partialResults.optionTwoPercentage = response.data.optionTwoPercentage;
					$location.path('/resultado');
				},
				function(errResponse) {
					console.error('Error submitting vote');
				});
			};
}]);
