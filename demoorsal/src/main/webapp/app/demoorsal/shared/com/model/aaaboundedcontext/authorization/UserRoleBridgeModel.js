Ext.define('Demoorsal.demoorsal.shared.com.model.aaaboundedcontext.authorization.UserRoleBridgeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "roleUserMapId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleid",
          "reference": "Roles",
          "defaultValue": ""
     }, {
          "name": "userid",
          "reference": "User",
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