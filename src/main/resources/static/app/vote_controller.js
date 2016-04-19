'use strict';

App.controller('VoteController', ['$scope', '$rootScope', '$window', '$location', 
                                  'VoteService', 'noCAPTCHA', function($scope, $rootScope, $window, $location, VoteService) {
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
			$scope.gRecaptchaResponse = '';			
			self.enableCaptcha = '';
			
			$scope.checkEnableCaptcha = function(){
				VoteService.getProperties().then(
					function(response){						
						self.enableCaptcha = response.data.enableCaptcha;
						console.log('CAPTCHA enabled? ' + response.data.enableCaptcha);
					}
				)
			};
			$scope.checkEnableCaptcha();

			$scope.setVote = function(option){
				
				<!-- Apenas um mock de implementacao de captcha rodando em localhost para verificar humanos --> 
				if($scope.gRecaptchaResponse=="" && self.enableCaptcha){
					alert('Por favor resolva o CAPTCHA antes de votar!');
				}else{
					self.vote.option = option;
					$rootScope.userOption = option;
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
