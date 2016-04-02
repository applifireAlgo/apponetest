Ext.define('Demoorsal.demoorsal.shared.com.model.aaaboundedcontext.authorization.RoleMenuBridgeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "roleMenuMapId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "menuid",
          "reference": "AppMenus",
          "defaultValue": ""
     }, {
          "name": "isRead",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "isWrite",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "isExecute",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "Roles",
          "reference": "RolesModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});