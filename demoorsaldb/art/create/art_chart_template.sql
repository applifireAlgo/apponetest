CREATE TABLE art_chart_template (
template_id varchar2(64) NOT NULL ,
template_name varchar2(500) NOT NULL,
template_json clob NOT NULL,
created_by varchar2(64) NOT NULL,
created_date date NOT NULL,
updated_by varchar2(64) NOT NULL,
updated_date date NOT NULL,
version_id number(10) NOT NULL,
project_id VARCHAR2(256),
project_version_id NUMBER(10),
active_status number(10) NOT NULL,
app_creator_id varchar2(256),
PRIMARY KEY (template_id)
);

exit

