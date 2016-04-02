Ext.define('Demoorsal.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Demoorsal.view.appreportui.ReportViewController',
	            'Demoorsal.view.appreportui.datagrid.DataGridPanel',
	            'Demoorsal.view.appreportui.datagrid.DataGridView',
	            'Demoorsal.view.appreportui.querycriteria.QueryCriteriaView',
	            'Demoorsal.view.appreportui.chart.ChartView',
	            'Demoorsal.view.appreportui.datapoint.DataPointView',
	            'Demoorsal.view.googlemaps.map.MapPanel',
	            'Demoorsal.view.appreportui.chartpoint.ChartPointView'
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
