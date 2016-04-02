CREATE TABLE cloud_drive_tags ( tag_id varchar2(64) NOT NULL, tag_hierachy VARCHAR2(100) DEFAULT NULL, tag_name VARCHAR2(50) DEFAULT NULL, tag_image VARCHAR2(50) DEFAULT NULL, created_by VARCHAR2(64) DEFAULT NULL, created_date TIMESTAMP(0) DEFAULT SYSTIMESTAMP NOT NULL, updated_by VARCHAR2(64) DEFAULT NULL, updated_date TIMESTAMP(0) DEFAULT NULL NULL, version_id NUMBER(10) DEFAULT NULL, active_status NUMBER(10) DEFAULT NULL, app_creator_id VARCHAR2(64) DEFAULT NULL );

CREATE INDEX tag_id ON cloud_drive_tags (tag_id);

exit

