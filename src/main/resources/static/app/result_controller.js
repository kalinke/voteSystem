'use strict';

App.controller('ResultController', ['$scope', '$window', '$location', 'highchartsNG', 'ResultService',  function($scope, $window, $location, highchartsNG, ResultService) {

			
			$scope.partialResults = {
					optionOnePercentage: '',
					optionTwoPercentage: ''
				};
			
			self.partialResults = function() {
				ResultService.listPartialVotes().then(
				function(response){
					$scope.partialResults.optionOnePercentage = response.data.optionOnePercentage;
					$scope.partialResults.optionTwoPercentage = response.data.optionTwoPercentage;
					$scope.highchartsNG = {
				    	    options:{
				              	colors: ['orange', '#cacaca'],	
				              	tooltip: {
				                    valueDecimals: 0,
				                    valueSuffix: ' %'
				                },
				                chart: {
								     backgroundColor: 'rgba(255, 255, 255, 0.1)'
								  },
				    	        plotOptions: {
				    	            pie: {
				    	            	size: 270,
				    	                dataLabels: {
				    	                    enabled: true,
				    	                    distance: -20,
				    	                    style: {
				    	                    	fontSize: '16px',
				    	                        fontWeight: 'bold',
				    	                        color: 'white',
				    	                        textShadow: '0px 1px 2px black'
				    	                    }
				    	                },
				    	                startAngle: -120,
				    	                endAngle: 120,
				    	                center: ['50%', '40%']
				    	            }
				    	        }
						        
				    	    },
				    	    credits: {
				    	        enabled: false
				    	    },

				    	        title: {
				    	            text: ''
				    	        },
				    	        series: [{
				    	            type: 'pie',
				    	            name: 'Votos',
				    	            innerSize: '60%',
				    	            data: [
				    	                [response.data.optionOnePercentage + '%', response.data.optionOnePercentage],
				    	                [response.data.optionTwoPercentage + '%', response.data.optionTwoPercentage]
				    	                
				    	            ]
				    	        }],
				    	        loading: false
				    	    }
				}, 
				function(errResponse) {
					console.error('Error listing partial results');
				});
			};
			
		    
			self.partialResults();
}]);
