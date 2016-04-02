CREATE TABLE art_log_connector_m ( connector_id  varchar2(64) NOT NULL , log_config_id varchar2(64) NOT NULL , connector_log_level NUMBER(10) NOT NULL, cid NUMBER(10) NOT NULL, id VARCHAR2(256) DEFAULT NULL, enabled NUMBER(3) NOT NULL, connector_name VARCHAR2(256) NOT NULL, class_name VARCHAR2(256) NOT NULL, system_defined NUMBER(3) DEFAULT NULL, version_id NUMBER(10) DEFAULT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (connector_id), CONSTRAINT ArtLogConfigFK FOREIGN KEY (log_config_id) REFERENCES art_log_config_m (log_config_id) ) ;
 
 CREATE INDEX LogConfigFK ON art_log_connector_m (log_config_id);

exit

