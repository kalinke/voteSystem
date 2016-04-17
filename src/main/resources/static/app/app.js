'use strict';

var App = angular.module('myApp', ['ngRoute']);

App.config(function ($routeProvider) { 
	  $routeProvider 
	    .when('/', { 
	      controller: 'VoteController', 
	      templateUrl: 'voto.html' 
	    })
	    .when('/resultado', { 
	    	controller: 'ResultController', 
	    	templateUrl: 'resultado.html' 
	    })
	});