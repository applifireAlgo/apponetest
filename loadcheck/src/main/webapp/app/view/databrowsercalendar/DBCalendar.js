Ext.define('Loadcheck.view.databrowsercalendar.DBCalendar', {
	extend : 'Loadcheck.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Loadcheck.view.databrowsercalendar.DBCalendarController',
	             'Loadcheck.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
