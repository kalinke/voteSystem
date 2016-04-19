App.controller('ReportController', ['$scope','uiGridConstants', '$http', function ($scope, uiGridConstants, $http) {
var data = [];
 
$scope.gridOptions = {
	    showGridFooter: true,
	    showColumnFooter: true,
	    enableFiltering: true,
	    columnDefs: [
	        { name: 'Data', field: 'voteDate', width: '20%', cellFilter: 'date', footerCellFilter: 'date'},
	        { name: 'Hora', field: 'hour',  width: '20%' },
	        { name: 'Participante 1', field: 'optionOne', aggregationType: uiGridConstants.aggregationTypes.sum, aggregationHideLabel: true, width: '20%' },
	        { name: 'Participante 2', field: 'optionTwo', aggregationType: uiGridConstants.aggregationTypes.sum, aggregationHideLabel: true, width: '20%' },
	        { name: 'Votos Por Hora', field: 'hourlyCount', aggregationType: uiGridConstants.aggregationTypes.sum, aggregationHideLabel: true, width: '20%' }
	    ],
	    data: data,
	    onRegisterApi: function(gridApi) {
	            $scope.gridApi = gridApi;
	    }
	};

	$http.get('http://localhost:8080/report')
	  .success(function(data) {
	    data.forEach( function(row) {
	      row.registered = Date.parse(row.registered);
	    });
	    $scope.gridOptions.data = data;
	  });
	}]);
