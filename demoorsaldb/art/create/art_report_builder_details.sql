CREATE TABLE art_report_builder_details (
  report_id VARCHAR2(64) NOT NULL,
  report_name VARCHAR2(256) NOT NULL,
  report_synopsis CLOB,
  report_help CLOB,
  query_criteria_json CLOB,
  grid_conf_json CLOB,
  chart_properties CLOB,
  drilldown_json CLOB,
  dataEndPoint_json CLOB,
  created_by VARCHAR2(64) NOT NULL,
  created_date DATE NOT NULL,
  updated_by VARCHAR2(64) NOT NULL,
  updated_date DATE NOT NULL,
  project_id VARCHAR2(256) NOT NULL,
  project_version_id NUMBER(10) NOT NULL,
  app_creator_id VARCHAR2(256) NOT NULL,
  active_status NUMBER(10) NOT NULL,
  version_id NUMBER(10) NOT NULL,
  query_info CLOB,
  other_properties_json CLOB,
  search_json CLOB,
  edit_flag NUMBER(10) DEFAULT NULL,
  bounded_context VARCHAR2(64) DEFAULT NULL,
  system_flag NUMBER(10) DEFAULT '0',
  data_browser NUMBER(10) DEFAULT '0',
  advance_config_json VARCHAR2(4000),
  PRIMARY KEY (report_id)
) ;

exit

