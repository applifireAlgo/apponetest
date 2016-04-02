CREATE TABLE art_chart_properties (
property_id varchar2(64) NOT NULL,
property_name varchar2(300) NOT NULL,
widgets varchar2(300) NOT NULL,
widgets_json clob,
created_by varchar2(64) NOT NULL,
created_date date NOT NULL,
updated_by varchar2(64) NOT NULL,
updated_date date NOT NULL,
version_id number(10) NOT NULL,
active_status number(10) NOT NULL,
PRIMARY KEY (property_id)
);

exit

