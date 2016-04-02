Ext.define('Loadcheck.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Loadcheck.view.appreportui.ReportViewController',
	            'Loadcheck.view.appreportui.datagrid.DataGridPanel',
	            'Loadcheck.view.appreportui.datagrid.DataGridView',
	            'Loadcheck.view.appreportui.querycriteria.QueryCriteriaView',
	            'Loadcheck.view.appreportui.chart.ChartView',
	            'Loadcheck.view.appreportui.datapoint.DataPointView',
	            'Loadcheck.view.googlemaps.map.MapPanel',
	            'Loadcheck.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
