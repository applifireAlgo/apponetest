CREATE TABLE art_log_module ( id varchar2(64) NOT NULL , log_module_name VARCHAR2(100) DEFAULT NULL, connector_order_id VARCHAR2(45) DEFAULT NULL, severity NUMBER(10) DEFAULT NULL, id_range_starts_with NUMBER(10) DEFAULT NULL, system_defined NUMBER(3) DEFAULT NULL, version_id NUMBER(10) DEFAULT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(10) DEFAULT NULL, PRIMARY KEY (id) ) ;
 
 CREATE INDEX alm_idx ON art_log_module (connector_order_id);

exit

