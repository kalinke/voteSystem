'use strict';

App.factory('VoteService', ['$http', '$q', function($http, $q) {
			return {
				submitVote : function(vote) {
					return $http.post('http://localhost:8080/vote', vote).then(
							function(response) {
								return response;
							}, function(errResponse) {
								console.error('Error submitting vote');
								return $q.reject(errResponse);
							});
				},
				listPartialVotes : function() {
					return $http.get('http://localhost:8080/vote').then(
							function(response) {
								return response;
							}, function(errResponse) {
								console.error('Error getting votes');
								return $q.reject(errResponse);
							});
				}
			};
		} ]);