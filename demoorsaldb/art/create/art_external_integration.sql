CREATE TABLE art_external_integration (
  integration_id varchar2(64) NOT NULL,
  integration_name VARCHAR2(500) DEFAULT NULL,
  integration_config_json CLOB,
  integration_dsl CLOB,
  project_id VARCHAR2(50) DEFAULT NULL,
  project_version_id VARCHAR2(50) DEFAULT NULL,
  created_by VARCHAR2(64) DEFAULT NULL,
  created_date TIMESTAMP(0) DEFAULT NULL,
  app_creator_id VARCHAR2(500) DEFAULT NULL,
  updated_by VARCHAR2(64) DEFAULT NULL,
  updated_date TIMESTAMP(0) DEFAULT NULL,
  version_id NUMBER(10) DEFAULT NULL,
  active_status NUMBER(3) DEFAULT NULL,
 connectorId  varchar2(50) DEFAULT NULL,
  PRIMARY KEY (integration_id)
);


exit

