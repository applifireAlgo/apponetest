Ext.define('Appone.view.databrowsercalendar.DBCalendarController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.databrowsercalendar',
	requires : [],
	calendar:null,
	rightClickMenu:null,
	init : function() {
		
		
		this.control({
            "calendarpanel": {
            	eventclick:this.clickEvent,
            	afterrender : 'loadData',
            	viewchange:'getQueryData',
            	//contextmenu:this.eventRigthClick
            },
        });
	},
	loadData : function(panel) {
		panel.getEl().on('contextmenu', this.eventRigthClick,this);
		this.getReportData();
		this.getQueryData();
		this.prepareRightClickMenu();
	},
	/*
	 * get Report Data from refId to load calendar data
	 */
	getReportData:function(){
		var panel=this.getView();
		var response = this
		.syncAjaxPOSTCall(
				 'secure/reportViewController/getReportDetailsById?reportId='
						+ panel.refId, '');
		var rptJSon = Ext.decode(response.response.data);
		panel.reportId = rptJSon.report_id;
		panel.reportJSON = rptJSon.data_json;
		this.calendar=panel.reportJSON.calendar;
		
	},
	/*
	 * get Query Data
	 */
	getQueryData:function(){
		var cal=this.getView().down("#app-calendar");
		var params = {
				report_id : this.getView().reportId,
				queryCriteria :this.prepareQueryCriteria(cal.getActiveView().getViewBounds().start,cal.getActiveView().getViewBounds().end),
				sqlId : this.getView().reportJSON.sqlId,
				calendar:this.calendar
			};
		Ext.Ajax
		.request({
			url : 'secure/reportViewController/getCalendarData',
			method : 'POST',
			scope : this.getView(),
			jsonData : Ext.encode(params),
			params : {},
			success : function(response, currentObject,
					options) {
				 var data=Ext.decode(response.responseText).response.data;
				 currentObject.scope.controller.loadCalendarData(data);
				},
			failure : function() {
				Ext.Msg.alert('Error',
						'Cannot connect to server');
			}
		});
	},
	prepareQueryCriteria:function(startdate,enddate,recFilter){
		var qc=[];
		var controller=this;
		Ext.Array.each(this.getView().reportJSON.queryCWidgetU, function(item, ind, items) {
			//if (item.defaultValue.length > 0) 
			{
				value = item.defaultValue;
				if (item.xtype != 'combobox') {if (item.xtype == "adatepickerfield"
					|| item.xtype == 'datefield') {
							this.filterCondition.push({
								name : item.name,
								fromui:true,
								label:"",
								datatype : item.datatype,
								value : this.getDefaultDateValue(value)
							});
				} else if(item.xtype == "daterange") {
					this.filterCondition.push({
						name : item.fromname,
						fromui:true,
						label:"",
						datatype : item.fromdatatype,
						value :controller.getFromDate(this.startdate.getTime()),
						customDateValue:controller.getCalendarFromDate(this.startdate)
					});
					this.filterCondition.push({
						name : item.toname,
						fromui:true,
						label:"",
						datatype : item.todatatype,
						value :controller.getToDate(this.enddate.getTime()),
						customDateValue:controller.getCalendarToDate(this.enddate)
					});
				}else{
					
					if(this.recFilter!= undefined && this.recFilter.column == item.name){
						value=this.recFilter.value;
					}
					this.filterCondition.push({
						name : item.name,
						label:"",
						fromui:true,
						datatype : item.datatype,
						value : value
					});
				}}
			}
		}, {
			filterCondition : qc,
			scope:this,
			startdate:startdate,
			enddate:enddate,
			recFilter:recFilter
		});
		return qc;
	},
	/*
	 * Used to load calendar Data
	 */
	loadCalendarData:function(responseData){
		var calendarData=[];
		var cal_date;
		var data=responseData.data;
		if(this.calendar.calDispColumn!=null){
			for(var x=0;x<data.length;x++){
				if(data[x].hasOwnProperty("dateLongValue") && data[x].dateLongValue.hasOwnProperty(this.calendar.calDateColumn) && this.calendar.calDispColumn != null )
				{
					cal_date=new Date(data[x].dateLongValue[this.calendar.calDateColumn]);
					var cond=data[x].hasOwnProperty(this.calendar.calDispColumn)?data[x][this.calendar.calDispColumn]:"";
					if(cond!=undefined && cond!="")
					{
						calendarData.push({
							"EventId" : x,
							"CalendarId" :1,
							"Title" :data[x].hasOwnProperty(this.calendar.calDispColumn)?data[x][this.calendar.calDispColumn]:"",
							"StartDate" : cal_date,
							"EndDate" : cal_date,
							"Notes" : ""
						});
					}
				}
			}
		}
		this.eventdata=data;
		this.loadAggregateData(responseData.aggregate,calendarData);
		this.getView().down("#app-calendar").eventStore.loadData(calendarData);
	},
	loadAggregateData:function(aggregate,calendardata){
		if(aggregate == undefined){
			return;
		}
		var aggCounter=0;
		for(var x=0;x<aggregate.length;x++){
			if(aggregate[x].hasOwnProperty("data") && aggregate[x]["data"].length>0){
				var data=aggregate[x]["data"];
				for(var x1=0;x1<data.length;x1++){
					cal_date=new Date(data[x1].date);
					calendardata.push({
						"EventId" : aggCounter,
						"CalendarId" :1,
						"Title" :data[x1].value,
						"value":data[x1].groupvalue,
						"columnname":aggregate[x].dfieldList,
						"StartDate" : cal_date,
						"EndDate" : cal_date,
						"Notes" : ""
					});
					aggCounter++;
				}
			}
			
		}
	},
	prepareRightClickMenu:function(){
		var cols=this.getView().reportJSON.gridColumns;
		for(var x1=0;x1<cols.length;x1++){
			if(cols[x1].dataIndex ==this.calendar.calDispColumn){
				var column=cols[x1]
				var targetReportList = cols[x1].targetRList== undefined?[]: cols[x1].targetRList;
				var menuItems = [];
				var qc = [];
				var queryCriteria = {};
				queryCriteria["name"] = column.qFieldName != undefined
						&& column.qFieldName.length > 0 ? column.qFieldName
						: column.dataIndex;
			//	queryCriteria["value"] = val;
				queryCriteria["datatype"] = column.datatype;
			//	queryCriteria["displayValue"] = displayval;
				queryCriteria["label"] = column.text;
				qc.push(queryCriteria);			
				for (var x = 0; x < targetReportList.length; x++) {
					menuItems.push(Ext.create('Ext.Action', {
						text :targetReportList[x].type!=undefined && targetReportList[x].type == 'f' ?'Launch '+targetReportList[x].report_name:  targetReportList[x].report_name,
						reportId : targetReportList[x].report_id,
						reportName:targetReportList[x].report_name,
						targetObj:targetReportList[x],
						scope:this,
						icon : "images/redirect.png",
						handler : function(menu) {
							var menuObj = menu.up();
							this.openDrillReport(menu.reportId,menu.reportName,menuObj.queryCriteria,menu.targetObj);
						}
					}));
				}
				if(menuItems.length>0){
					this.rightClickMenu= Ext.create('Ext.menu.Menu', {
						scope : this,
						queryCriteria : qc,
						qcFilterColumn:column.qFieldName != undefined
						&& column.qFieldName.length > 0 ? column.qFieldName
								: column.dataIndex,
					//	record : record.data,
						column : cols[x1],
						targetlist:column.targetRList[0],
						columns : cols,
						//gridObj : gridObj,
						items : menuItems
					});
				}else{
					this.rightClickMenu=undefined;
				}
					
			} 
		}
		
		
	},
	clickEvent:function(vw, rec,el){
		var recFilter={
				column:rec.data.columnname,
				value:rec.data.value
		}
		var fromDate = this.fromDate(new Date(rec.data.StartDate));
		var toDate = this.toDate(new Date(rec.data.EndDate));
		
		var qc=this.prepareQueryCriteria(fromDate,toDate,recFilter);
		this.openDrillReport(this.getView().reportId,this.getView().reportJSON.report_name,qc,{type:"r"});
	},
	openDrillReport:function(reportid,name,qccriteria,targetObj){
		var component;
		if(targetObj.type == "f"){
			//targetObj.menuAction = targetObj.menuAction.replace("Main", "");
			component= Ext.create(
					targetObj.menuAction, {
						closable : true,
						drilled : true,		
						title :name,
						refId : reportid,
						rptHrefQC : qccriteria,
						primaryKey : qccriteria[0].value,
						caller : this,
						disableDB:true

					});
		}else{
				component= Ext.create(
					'Appone.view.appreportui.ReportView', {
						closable : true,
						drilled : true,		
						title :name,
						refId : reportid,
						rptHrefQC : qccriteria
					});
			
			
		}
		var tabs = Ext.getCmp('appMainTabPanel');
		 tab = tabs.add({
				xtype : component,
				title : this.getView().reportJSON.report_name
			});
		tabs.setActiveTab(tab);
	},
	eventRigthClick:function(vw, record, item,index, e, eOpts){
		if(record.hasAttribute("eventId")){
			var eventId=record.getAttribute("eventId");
			var rec=this.eventdata[parseInt(eventId)];
			if(this.rightClickMenu== undefined){
				return;
			}
			this.rightClickMenu.queryCriteria[0]["value"]=rec[this.rightClickMenu.qcFilterColumn];
			this.rightClickMenu.queryCriteria[0]["displayValue"]=rec[this.calendar.calDispColumn];
			this.rightClickMenu.showAt(vw.getXY());
		}
		vw.stopEvent();
	},
	syncAjaxPOSTCall : function(url, data) {
		// Define function to perform synchronous requests to
		// get model data
		var request = ((window.XMLHttpRequest) ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP"));
		request.open("POST", url, false); // <-- false makes
											// it a synchonous
		// request!
		request.setRequestHeader("Content-type",
				"application/json", "application/xml");
		request.send(Ext.encode(data));

		// request.send(null);
		return Ext.decode(request.responseText);
	},
	getDefaultDateValue : function(defaultVal) {
		// dDate defaultDate;
		var defaultDate="";
		
		if (defaultVal.toUpperCase() == "TODAY") {
			defaultDate = new Date();
		}
		return defaultDate;
	},
	getFromDate:function(dateValue){
		var fromDate=new Date(dateValue);
			fromDate.setSeconds(1);
			return fromDate.getTime();
	},
	getToDate:function(dateValue){
		var toDate=new Date(dateValue);
			toDate.setHours(23);
			toDate.setMinutes(59);
			toDate.setSeconds(59);
			return toDate.getTime();
	},
	
	//Currently this two methods are used
	fromDate : function(fromDate){
		fromDate.setHours(00);
		fromDate.setMinutes(00);
		fromDate.setSeconds(00);
		return fromDate;
	},
	
	toDate : function(toDate)
	{
		toDate.setHours(23);
		toDate.setMinutes(59);
		toDate.setSeconds(59);
		return toDate;
	},
	getCalendarFromDate:function(fromDate){
		return fromDate.getDate()+"-0"+(fromDate.getMonth()+1)+"-"+ fromDate.getFullYear()+" 00:00:00 "+Ext.util.Cookies.get('XA_TID')
	},
	getCalendarToDate:function(fromDate){
		return fromDate.getDate()+"-0"+(fromDate.getMonth()+1)+"-"+ fromDate.getFullYear()+" 23:59:59 "+Ext.util.Cookies.get('XA_TID')
	}
	
});