'use strict';

App.factory('ResultService', ['$http', '$q', function($http, $q) {
			return {
				listPartialVotes : function() {
					return $http.get('http://localhost:8080/vote').then(
							function(response) {
								console.log(response)
								return response;
							}, function(errResponse) {
								console.error('Error getting votes');
								return $q.reject(errResponse);
							});
				}
			};
		} 
		
]);