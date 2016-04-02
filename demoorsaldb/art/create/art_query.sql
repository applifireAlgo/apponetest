CREATE TABLE art_query (
query_id varchar2(64) NOT NULL ,
jpql_query clob,
query_type number(3) DEFAULT NULL,
query_json clob,
name varchar2(256) DEFAULT NULL,
hidden_name varchar2(256) DEFAULT NULL,
app_creator_id varchar2(256) DEFAULT NULL,
project_id varchar2(256) DEFAULT NULL,
project_version_id varchar2(256) DEFAULT NULL,
created_by number(10) DEFAULT NULL,
created_date timestamp(0) DEFAULT NULL,
updated_by number(10) DEFAULT NULL,
updated_date timestamp(0) DEFAULT NULL,
version_id number(10) DEFAULT NULL,
active_status number(3) DEFAULT NULL,
sql_query clob,
user_access number(1) DEFAULT '0',
PRIMARY KEY (query_id)
);

exit

