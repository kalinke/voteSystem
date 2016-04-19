'use strict';

var App = angular.module('myApp', ['ngRoute', 'ui.grid', 'highcharts-ng', 'noCAPTCHA', 'timer']);

App.config(function ($routeProvider, $locationProvider) { 
	  $routeProvider 
	    .when('/', { 
	      controller: 'VoteController', 
	      templateUrl: 'voto.html' 
	    })
	    .when('/resultado', { 
	    	controller: 'ResultController', 
	    	templateUrl: 'result.html' 
	    })
	    .when('/relatorio', { 
	    	controller: 'ReportController', 
	    	templateUrl: 'relatorio.html' 
	    })
	    .otherwise({redirectTo: '/'});
	});
