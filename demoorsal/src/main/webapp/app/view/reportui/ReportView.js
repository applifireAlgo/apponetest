Ext.define('Demoorsal.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Demoorsal.view.reportui.querycriteria.QueryCriteriaView',
			'Demoorsal.view.reportui.datachart.DataChartViewTab',
			'Demoorsal.view.reportui.datachart.DataChartViewPanel',
			'Demoorsal.view.reportui.ReportViewController' ,
			'Demoorsal.view.fw.MainDataPointPanel',
			'Demoorsal.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
