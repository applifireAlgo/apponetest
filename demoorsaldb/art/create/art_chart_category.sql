CREATE TABLE art_chart_category (
 chart_id varchar2(64) NOT NULL ,
 chart_tree_id varchar2(30) NOT NULL,
 chart_label varchar2(100) NOT NULL,
 chart_description varchar2(200) DEFAULT NULL,
 chart_json_id VARCHAR2(64) NOT NULL,
 created_by varchar2(64) NOT NULL,
 created_date date NOT NULL,
 updated_by varchar2(64) NOT NULL,
 updated_date date NOT NULL,
 version_id number(10) NOT NULL,
 active_status number(10) NOT NULL,
 chart_point number(10) DEFAULT '0' NOT NULL,
 PRIMARY KEY (chart_id),CONSTRAINT fk_chart_jsonId FOREIGN KEY (chart_json_id) REFERENCES art_chart_json (chart_json_id) ON DELETE CASCADE
);

exit

