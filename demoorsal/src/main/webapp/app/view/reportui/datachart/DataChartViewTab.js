Ext.define('Demoorsal.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Demoorsal.view.reportui.datachart.DataChartTController',
	             'Demoorsal.view.reportui.datachart.datagrid.DataGridView',
	             'Demoorsal.view.reportui.datachart.chart.ChartTabView',
	             'Demoorsal.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});