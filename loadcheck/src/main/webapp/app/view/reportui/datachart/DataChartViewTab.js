Ext.define('Loadcheck.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Loadcheck.view.reportui.datachart.DataChartTController',
	             'Loadcheck.view.reportui.datachart.datagrid.DataGridView',
	             'Loadcheck.view.reportui.datachart.chart.ChartTabView',
	             'Loadcheck.view.reportui.datachart.ChartPointView' ],
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