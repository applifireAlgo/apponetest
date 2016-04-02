CREATE TABLE art_component_config (
  id varchar2(64) NOT NULL,
  component_name varchar2(256) NOT NULL,
  initializer varchar2(256) DEFAULT NULL,
  status number(3) DEFAULT '0',
  project_id varchar2(256) NOT NULL,
  project_version_id varchar2(256) DEFAULT NULL,
  app_creator_id varchar2(256) DEFAULT NULL,
  created_by varchar2(64) DEFAULT NULL,
  created_date timestamp(0) DEFAULT NULL,
  updated_by varchar2(64) DEFAULT NULL,
  updated_date timestamp(0) DEFAULT NULL,
  version_id number(10) DEFAULT NULL,
  active_status number(3) DEFAULT '1',
  PRIMARY KEY (id)
);

exit

