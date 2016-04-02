
CREATE TABLE art_scheduler_details (
  schedulerId varchar2(64) NOT NULL,
  schedulerExpression varchar2(64) DEFAULT NULL,
  jobId varchar2(64) DEFAULT NULL,
  project_id varchar2(64) DEFAULT NULL,
  app_creator_id varchar2(64) DEFAULT NULL,
  project_version_id varchar2(64) DEFAULT NULL,
  created_by varchar2(64) DEFAULT NULL,
  created_date timestamp(0) DEFAULT NULL,
  updated_by varchar2(64) DEFAULT NULL,
  version_id number(10) DEFAULT NULL,
  active_status number(3) DEFAULT NULL,
  PRIMARY KEY (schedulerId)
) ;

exit

