CREATE TABLE art_user_last_status (
id VARCHAR2(64) NOT NULL,
user_id VARCHAR2(64) DEFAULT NULL,
menu_id VARCHAR2(64) DEFAULT NULL,
json CLOB,
project_id VARCHAR2(256) DEFAULT NULL,
project_version_id VARCHAR2(256) DEFAULT NULL,
updated_by varchar2(64) DEFAULT NULL,
updated_date TIMESTAMP(0) DEFAULT NULL,
created_by varchar2(64) DEFAULT NULL,
created_date TIMESTAMP(0) DEFAULT NULL,
version_id NUMBER(10) DEFAULT NULL,
active_status NUMBER(3) DEFAULT NULL,
app_creator_id VARCHAR2(256) DEFAULT NULL,
PRIMARY KEY (id)
);

exit

