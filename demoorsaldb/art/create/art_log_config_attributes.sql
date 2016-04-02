CREATE TABLE art_log_config_attributes ( attribute_id varchar2(64) NOT NULL , log_config_id varchar2(64) NOT NULL , attribute_name VARCHAR2(256) DEFAULT NULL, attribute_value VARCHAR2(256) DEFAULT NULL, attribute_comment VARCHAR2(1000) DEFAULT NULL, attribute_display_name VARCHAR2(256) DEFAULT NULL, version_id NUMBER(10) DEFAULT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (attribute_id), CONSTRAINT ArtLogFK FOREIGN KEY (log_config_id) REFERENCES art_log_config_m (log_config_id) ) ;
 
 CREATE INDEX LogFK ON art_log_config_attributes (log_config_id);

exit

