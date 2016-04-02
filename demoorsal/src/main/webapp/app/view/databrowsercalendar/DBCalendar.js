Ext.define('Demoorsal.view.databrowsercalendar.DBCalendar', {
	extend : 'Demoorsal.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Demoorsal.view.databrowsercalendar.DBCalendarController',
	             'Demoorsal.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
