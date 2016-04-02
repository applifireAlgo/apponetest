

CREATE TABLE art_health_scheduler_config_m ( schedulerId varchar2(64) NOT NULL , schedulerkey VARCHAR2(45) DEFAULT NULL, refreshTime NUMBER(10) DEFAULT NULL, refreshUnit VARCHAR2(45) DEFAULT NULL, batchSize NUMBER(10) DEFAULT NULL, enabled VARCHAR2(45) DEFAULT NULL, connectorClass VARCHAR2(100) DEFAULT NULL, dataModel VARCHAR2(100) DEFAULT NULL, schedulerName VARCHAR2(45) DEFAULT NULL, threadPoolSize NUMBER(10) DEFAULT NULL, version_id NUMBER(10) DEFAULT NULL, created_by varchar2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by varchar2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (schedulerId) );

exit

