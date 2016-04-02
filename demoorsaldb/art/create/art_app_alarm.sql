CREATE TABLE art_app_alarm ( id varchar2(64) NOT NULL , alarm_id NUMBER(10) DEFAULT NULL, severity NUMBER(10) DEFAULT NULL, connector_order_id VARCHAR2(45) DEFAULT NULL, message CLOB, diagnose CLOB, solution CLOB, log_module_id varchar2(64) NOT NULL, version_id NUMBER(10) DEFAULT NULL, created_by varchar2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL, updated_by varchar2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(10) DEFAULT NULL, PRIMARY KEY (id), CONSTRAINT fk_art_app_alarm_log_module FOREIGN KEY (log_module_id) REFERENCES art_log_module (id) ) ;
 
 CREATE INDEX fk_art_app_alarm_co_idx ON art_app_alarm (connector_order_id);
 CREATE INDEX fk_art_app_alarm_lm_idx ON art_app_alarm (log_module_id);

exit

