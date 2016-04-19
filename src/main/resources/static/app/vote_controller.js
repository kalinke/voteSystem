'use strict';

App.controller('VoteController', ['$scope', '$window', '$location', 'VoteService', 'noCAPTCHA', function($scope, $window, $location, VoteService) {
			$scope.gRecaptchaResponse = '';
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
				
				<!-- Apenas um mock de implementacao de captcha rodando em localhost para verificar humanos --> 
				if($scope.gRecaptchaResponse==""){
					alert('Por favor resolva o CAPTCHA antes de votar!');
				}else{
					self.vote.option = option;
					VoteService.submitVote(self.vote).then(
					function(response){
						$location.path('/resultado');
					},
					function(errResponse) {
						console.error('Error submitting vote');
					});
				}
			};		
}]);
