/**
 * 
 */
Ext.define('Loadcheck.view.scheduleconfiguration.panel.ScheduleConfigViewModel', {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.schedulerConfigViewModel',

	stores : {
		months : {
			fields : [ 'month' ],
			data : [ [ 'january' ], [ 'february' ], [ 'march' ], [ 'april' ], [ 'may' ], [ 'june' ], [ 'july' ], [ 'august' ], [ 'september' ], [ 'october' ],
					[ 'november' ], [ 'december' ] ]

		},
		days : {
			fields : [ 'day' ],
			data : [ [ 'monday' ], [ 'tuesday' ], [ 'wednesday' ], [ 'thusday' ], [ 'friday' ], [ 'saturday' ], [ 'sunday' ], [ 'last weekday of month' ] ]
		},
		hours : {
			fields : [ 'hour' ],
			data : [ [ '1' ], [ '2' ], [ '3' ], [ '4' ], [ '5' ], [ '6' ], [ '7' ], [ '8' ], [ '9' ], [ '10' ], [ '11' ], [ '12' ], [ '13' ], [ '14' ], [ '15' ], [ '16' ],
					[ '17' ], [ '18' ], [ '19' ], [ '20' ], [ '21' ], [ '22' ], [ '23' ] ]
		},
		minutes : {
			fields : [ 'minute' ],
			data : [ [ '1' ], [ '2' ], [ '3' ], [ '4' ], [ '5' ], [ '6' ], [ '7' ], [ '8' ], [ '9' ], [ '10' ], [ '11' ], [ '12' ], [ '13' ], [ '14' ], [ '15' ], [ '16' ],
					[ '17' ], [ '18' ], [ '19' ], [ '20' ], [ '21' ], [ '22' ], [ '23' ], [ '24' ], [ '25' ], [ '26' ], [ '27' ], [ '28' ], [ '29' ], [ '30' ], [ '31' ],
					[ '32' ], [ '33' ], [ '34' ], [ '35' ], [ '36' ], [ '37' ], [ '38' ], [ '39' ], [ '40' ], [ '41' ], [ '42' ], [ '43' ], [ '44' ], [ '45' ], [ '46' ],
					[ '47' ], [ '48' ], [ '49' ], [ '50' ], [ '51' ], [ '52' ], [ '53' ], [ '54' ], [ '55' ], [ '56' ], [ '57' ], [ '58' ], [ '59' ] ]
		},
		customSchedules : {
			fields : [ 'month', 'day', 'hour', 'minute', 'key' ],
			data : []
		},
		byWhom : {
			fields : [ 'userId', 'userName' ],
			data : [ [ 'id', 'system' ] ],
			sorters : [ 'userName', 'ASC' ]
		}
	}
});