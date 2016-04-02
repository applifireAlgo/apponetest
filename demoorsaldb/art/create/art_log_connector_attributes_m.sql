CREATE TABLE art_log_connector_attributes_m ( attribute_id varchar2(64) NOT NULL, connector_id varchar2(64) NOT NULL , attribute_name VARCHAR2(256) NOT NULL, attribute_value VARCHAR2(256) NOT NULL, attribute_comment VARCHAR2(1024) DEFAULT NULL, attribute_display_name VARCHAR2(256) DEFAULT NULL, version_id NUMBER(10) DEFAULT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT NULL NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, PRIMARY KEY (attribute_id), CONSTRAINT ArtConnectorFK FOREIGN KEY (connector_id) REFERENCES art_log_connector_m (connector_id) );

CREATE INDEX ConnectorFK ON art_log_connector_attributes_m (connector_id);

exit

