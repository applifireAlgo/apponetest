Ext.define('Appone.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Appone.view.reportui.querycriteria.QueryCriteriaView',
			'Appone.view.reportui.datachart.DataChartViewTab',
			'Appone.view.reportui.datachart.DataChartViewPanel',
			'Appone.view.reportui.ReportViewController' ,
			'Appone.view.fw.MainDataPointPanel',
			'Appone.view.googlemaps.map.MapPanel'
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
