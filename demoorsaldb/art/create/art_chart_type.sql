CREATE TABLE art_chart_type (
chart_type_id varchar2(64) NOT NULL ,
chart_id VARCHAR2(64) NOT NULL,
chart_type varchar2(100) NOT NULL,
chart_default varchar2(1) NOT NULL,
created_by varchar2(64) NOT NULL,
created_date date NOT NULL,
updated_by varchar2(64) NOT NULL,
updated_date date NOT NULL,
version_id number(10) NOT NULL,
active_status number(10) NOT NULL,
PRIMARY KEY (chart_type_id), CONSTRAINT ForeignKey FOREIGN KEY (chart_id) REFERENCES art_chart_category (chart_id) ON DELETE CASCADE
);

exit

