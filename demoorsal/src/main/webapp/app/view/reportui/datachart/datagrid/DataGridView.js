Ext.define('Demoorsal.view.reportui.datachart.datagrid.DataGridView',{
	extend : 'Ext.grid.Panel',
	requires : [ 'Demoorsal.view.reportui.datachart.datagrid.DataGridController' ],
	xtype : 'data-grid-view',
	controller:'datagridController',
	autoscroll:true,
	columnLines:true,
	//forceFit:true,
	itemId : 'data-grid-view',
	//width : "100%",
	listeners : {
		scope:'controller',
		cellclick : 'dataGridCellClick',
		itemcontextmenu : 'dataGridRightClick',
	}
});
