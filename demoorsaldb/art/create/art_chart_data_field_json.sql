CREATE TABLE art_chart_data_field_json (
data_field_id varchar2(64) NOT NULL ,
data_field_name varchar2(256) DEFAULT NULL,
data_field_json clob,
created_by varchar2(64) DEFAULT NULL,
created_date date DEFAULT NULL,
updated_by varchar2(64) DEFAULT NULL,
updated_date date DEFAULT NULL,
version_id number(10) DEFAULT NULL,
active_status number(10) DEFAULT NULL,
PRIMARY KEY (data_field_id)
);

exit

