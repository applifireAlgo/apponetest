Ext.define('Demoorsal.demoorsal.shared.com.model.salesboundedcontext.sales.SalesDataModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "autoid",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "channelid",
          "reference": "Channel",
          "defaultValue": ""
     }, {
          "name": "reatilercode",
          "reference": "Retailer",
          "defaultValue": ""
     }, {
          "name": "retailername",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "salesdate",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "salesmonth",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "salesyear",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "salesinvoicenbr",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "materialdesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "branddesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "salesqty",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "netsalesamt",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "grosssalesamt",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "materialcode",
          "reference": "Material",
          "defaultValue": ""
     }, {
          "name": "brandcode",
          "reference": "Brand",
          "defaultValue": ""
     }, {
          "name": "category",
          "reference": "Category",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});