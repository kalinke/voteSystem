'use strict';

App.factory('VoteService', ['$http', '$q', function($http, $q) {
			return {
				submitVote : function(vote) {
					return $http.post('/vote', vote).then(
							function(response) {
								return response;
							}, function(errResponse) {
								console.error('Error submitting vote');
								return $q.reject(errResponse);
							});
				},
				listPartialVotes : function() {
					return $http.get('/vote').then(
							function(response) {
								return response;
							}, function(errResponse) {
								console.error('Error getting votes');
								return $q.reject(errResponse);
							});
				},
				getProperties : function() {
					return $http.get('angular.property').then(
							function (response) {
								return response;						
				      });
				}
			};
		} ]);