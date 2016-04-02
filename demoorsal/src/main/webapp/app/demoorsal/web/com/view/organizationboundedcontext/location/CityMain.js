Ext.define('Demoorsal.demoorsal.web.com.view.organizationboundedcontext.location.CityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CityMainController",
     "restURL": "/City",
     "defaults": {
          "split": true
     },
     "requires": ["Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.CityModel", "Demoorsal.demoorsal.web.com.controller.organizationboundedcontext.location.CityMainController", "Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.CountryModel", "Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.StateModel", "Demoorsal.demoorsal.shared.com.viewmodel.organizationboundedcontext.location.CityViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "City",
               "name": "CityTreeContainer",
               "itemId": "CityTreeContainer",
               "restURL": "/City",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CityTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "City",
                    "title": "City",
                    "name": "City",
                    "itemId": "CityForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cityId",
                         "itemId": "cityId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Id<font color='red'> *<\/font>",
                         "fieldId": "713FB66B-6803-47A9-A685-724C987E30A1",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "cityId"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "fieldId": "8FCD4B44-F239-4AE6-B552-9E48A7722E13",
                         "restURL": "Country",
                         "bindable": "countryId",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.StateModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "fieldId": "9E29455F-9F03-4517-87B0-9114E3856AE5",
                         "restURL": "State",
                         "bindable": "stateId",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityName",
                         "itemId": "cityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B99038C7-493C-48C2-97BB-1DBDD4C84450",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "cityName",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCodeChar2",
                         "itemId": "cityCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D2D2FBD0-D5E9-4CA4-AFE0-84DC494817AD",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "cityCodeChar2",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCode",
                         "itemId": "cityCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Code1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6C64BF13-96F8-4BED-970A-53CF48A7EF3D",
                         "minValue": "0",
                         "maxValue": "3",
                         "bindable": "cityCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityDescription",
                         "itemId": "cityDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "City Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Description",
                         "fieldId": "19FCC8CC-F6FB-45B1-9623-FA4B36349F90",
                         "bindable": "cityDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityFlag",
                         "itemId": "cityFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "9E227C8E-C159-49D3-967C-0BB8E454E777",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "cityFlag",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLatitude",
                         "itemId": "cityLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Latitude",
                         "fieldId": "CFE4F756-5F92-4CD0-BAA0-01BF47BC5B26",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "cityLatitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLongitude",
                         "itemId": "cityLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Longitude",
                         "fieldId": "25331B15-EF86-4C4F-9949-28398B2A27F9",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "cityLongitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "142CC3E4-EFC3-41C1-A5FC-CE24118A49E5",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 30,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 30,
                              "customId": 690
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 30,
                              "customId": 691,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 30,
                              "customId": 692,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "City",
                    "title": "Details Grid",
                    "name": "CityGrid",
                    "itemId": "CityGrid",
                    "restURL": "/City",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "City Id",
                         "dataIndex": "cityId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "City Name",
                         "dataIndex": "cityName",
                         "flex": 1
                    }, {
                         "header": "City Code",
                         "dataIndex": "cityCodeChar2",
                         "flex": 1
                    }, {
                         "header": "City Code1",
                         "dataIndex": "cityCode",
                         "flex": 1
                    }, {
                         "header": "City Description",
                         "dataIndex": "cityDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "cityFlag",
                         "flex": 1
                    }, {
                         "header": "City Latitude",
                         "dataIndex": "cityLatitude",
                         "flex": 1
                    }, {
                         "header": "City Longitude",
                         "dataIndex": "cityLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "City",
               "title": "City",
               "name": "City",
               "itemId": "CityForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "cityId",
                    "itemId": "cityId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Id<font color='red'> *<\/font>",
                    "fieldId": "713FB66B-6803-47A9-A685-724C987E30A1",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "cityId"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.CountryModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "fieldId": "8FCD4B44-F239-4AE6-B552-9E48A7722E13",
                    "restURL": "Country",
                    "bindable": "countryId",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Demoorsal.demoorsal.shared.com.model.organizationboundedcontext.location.StateModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "fieldId": "9E29455F-9F03-4517-87B0-9114E3856AE5",
                    "restURL": "State",
                    "bindable": "stateId",
                    "columnWidth": 0.5
               }, {
                    "name": "cityName",
                    "itemId": "cityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B99038C7-493C-48C2-97BB-1DBDD4C84450",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "cityName",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCodeChar2",
                    "itemId": "cityCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D2D2FBD0-D5E9-4CA4-AFE0-84DC494817AD",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "cityCodeChar2",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCode",
                    "itemId": "cityCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Code1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6C64BF13-96F8-4BED-970A-53CF48A7EF3D",
                    "minValue": "0",
                    "maxValue": "3",
                    "bindable": "cityCode",
                    "columnWidth": 0.5
               }, {
                    "name": "cityDescription",
                    "itemId": "cityDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "City Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Description",
                    "fieldId": "19FCC8CC-F6FB-45B1-9623-FA4B36349F90",
                    "bindable": "cityDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "cityFlag",
                    "itemId": "cityFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "9E227C8E-C159-49D3-967C-0BB8E454E777",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "cityFlag",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLatitude",
                    "itemId": "cityLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Latitude",
                    "fieldId": "CFE4F756-5F92-4CD0-BAA0-01BF47BC5B26",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "cityLatitude",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLongitude",
                    "itemId": "cityLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Longitude",
                    "fieldId": "25331B15-EF86-4C4F-9949-28398B2A27F9",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "cityLongitude",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "142CC3E4-EFC3-41C1-A5FC-CE24118A49E5",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 30,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 30,
                         "customId": 690
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 30,
                         "customId": 691,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 30,
                         "customId": 692,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});