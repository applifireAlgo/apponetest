CREATE TABLE cloud_drive_file_shared ( file_id varchar2(64) DEFAULT NULL, shared_user_id varchar2(64) DEFAULT NULL, updated_by varchar2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL NULL, created_by varchar2(64) DEFAULT NULL, created_date timestamp(0) DEFAULT SYSTIMESTAMP NULL, version_id number(10) DEFAULT NULL, active_status number(10) DEFAULT NULL, id varchar2(64) NOT NULL, PRIMARY KEY (id) );

exit

