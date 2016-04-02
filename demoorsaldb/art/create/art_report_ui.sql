CREATE TABLE art_report_ui (
  report_name VARCHAR2(256) DEFAULT NULL,
  report_id VARCHAR2(64) NOT NULL,
  query_id VARCHAR2(64) DEFAULT NULL,
  data_json CLOB,
  chart_json CLOB,
  created_by VARCHAR2(64) NOT NULL,
  created_date DATE NOT NULL,
  updated_by VARCHAR2(64) NOT NULL,
  updated_date DATE NOT NULL,
  project_id VARCHAR2(256) NOT NULL,
  project_version_id NUMBER(10) NOT NULL,
  app_creator_id VARCHAR2(256) NOT NULL,
  active_status NUMBER(10) NOT NULL,
  version_id NUMBER(10) NOT NULL,
  search_json CLOB,
  advance_config_json VARCHAR2(4000),
  PRIMARY KEY (report_id)
) ;

exit

