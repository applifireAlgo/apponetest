Ext.define('Loadcheck.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Loadcheck.view.reportui.querycriteria.QueryCriteriaView',
			'Loadcheck.view.reportui.datachart.DataChartViewTab',
			'Loadcheck.view.reportui.datachart.DataChartViewPanel',
			'Loadcheck.view.reportui.ReportViewController' ,
			'Loadcheck.view.fw.MainDataPointPanel',
			'Loadcheck.view.googlemaps.map.MapPanel'
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
