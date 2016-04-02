CREATE TABLE art_health_status_config_m ( statusConfigId varchar2(64) NOT NULL , diskPath VARCHAR2(100) DEFAULT NULL, diskThreshold NUMBER(10) DEFAULT NULL, executeSql VARCHAR2(250) DEFAULT NULL, version_id NUMBER(10) DEFAULT NULL, created_by varchar2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by varchar2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (statusConfigId) );

exit

