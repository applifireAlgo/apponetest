Ext.define('Appone.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Appone.view.reportui.datachart.DataChartTController',
	             'Appone.view.reportui.datachart.datagrid.DataGridView',
	             'Appone.view.reportui.datachart.chart.ChartTabView',
	             'Appone.view.reportui.datachart.ChartPointView' ],
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