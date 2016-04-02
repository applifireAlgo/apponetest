CREATE TABLE art_chart_json (
chart_json_id varchar2(64) NOT NULL ,
chart_json clob NOT NULL,
json_data_structure clob NOT NULL,
java_class varchar2(2048) DEFAULT NULL,
created_by varchar2(64) NOT NULL,
created_date date NOT NULL,
updated_by varchar2(64) NOT NULL,
updated_date date NOT NULL,
version_id number(10) NOT NULL,
active_status number(10) NOT NULL,
data_field_id VARCHAR2(64) DEFAULT NULL,
PRIMARY KEY (chart_json_id)
);

exit

