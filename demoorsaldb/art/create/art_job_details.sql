CREATE TABLE art_job_details (
  jobId varchar2(64) NOT NULL,
  jobName varchar2(128) DEFAULT NULL,
  uiJson clob NOT NULL,
  processJson clob,
  project_id varchar2(256) DEFAULT NULL,
  app_creator_id varchar2(256) DEFAULT NULL,
  project_version_id varchar2(256) DEFAULT NULL,
  created_by varchar2(64) DEFAULT NULL,
  created_date timestamp(0) DEFAULT NULL,
  updated_by varchar2(64) DEFAULT NULL,
  updated_date timestamp(0) DEFAULT NULL,
  version_id number(10) DEFAULT NULL,
  active_status number(3) DEFAULT NULL,
  beanName varchar2(64) DEFAULT NULL,
  currentStatus varchar2(64) DEFAULT NULL,
  statusTime timestamp(0) DEFAULT NULL NULL,
  PRIMARY KEY (jobId)
);

exit

