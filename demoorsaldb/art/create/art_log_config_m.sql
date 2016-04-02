CREATE TABLE art_log_config_m ( log_config_id varchar2(64) NOT NULL, version_id NUMBER(10) DEFAULT NULL, created_by varchar2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by varchar2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (log_config_id) );

exit

