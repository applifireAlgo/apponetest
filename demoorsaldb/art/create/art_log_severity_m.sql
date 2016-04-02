CREATE TABLE art_log_severity_m ( severity_id varchar2(64) NOT NULL, log_config_id NUMBER(10) DEFAULT NULL, severity NUMBER(10) NOT NULL, label VARCHAR2(256) NOT NULL, version_id NUMBER(10) DEFAULT NULL, created_by NUMBER(10) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by NUMBER(10) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (severity_id) ) ;

exit

