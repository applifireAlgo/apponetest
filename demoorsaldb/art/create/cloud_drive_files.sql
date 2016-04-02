CREATE TABLE cloud_drive_files ( file_id varchar2(64) NOT NULL, file_name VARCHAR2(50) DEFAULT NULL, file_extension VARCHAR2(100) DEFAULT NULL, file_application_type VARCHAR2(300) DEFAULT NULL, file_mime_type VARCHAR2(300) DEFAULT NULL, system_name VARCHAR2(100) DEFAULT NULL, system_path VARCHAR2(500) DEFAULT NULL, size1 NUMBER(10,0) DEFAULT NULL, file_scope CHAR(1) DEFAULT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT SYSTIMESTAMP NOT NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL NULL, version_id VARCHAR2(11) DEFAULT NULL, app_creator_id VARCHAR2(64) DEFAULT NULL, active_status NUMBER(10) DEFAULT NULL, PRIMARY KEY (file_id) );

CREATE INDEX fk_file_content_id ON cloud_drive_files (file_mime_type);

exit

