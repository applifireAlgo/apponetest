CREATE TABLE cloud_drive_file_versions ( base_file_Id varchar2(64) DEFAULT NULL, file_id varchar2(64) NOT NULL, file_version_id NUMBER(10) NOT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT SYSTIMESTAMP NOT NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL NULL, version_id NUMBER(10) DEFAULT NULL, active_status NUMBER(10) DEFAULT NULL, PRIMARY KEY (file_id,file_version_id), CONSTRAINT fk_file_version_id FOREIGN KEY (file_id) REFERENCES cloud_drive_files (file_id) );

exit

