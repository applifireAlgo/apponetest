CREATE TABLE art_chart_prop_language (
  label_id varchar2(64) NOT NULL,
  property_id varchar2(64) NOT NULL,
  display_name varchar2(200) NOT NULL,
  lang_id varchar2(64) NOT NULL,
  country_code varchar2(64) NOT NULL,
  created_by varchar2(64) NOT NULL,
  created_date date NOT NULL,
  updated_by varchar2(64) NOT NULL,
  updated_date date NOT NULL,
  version_id number(10) NOT NULL,
  active_status number(10) NOT NULL,
  PRIMARY KEY (label_id),
  CONSTRAINT art_chart_prop_language FOREIGN KEY (lang_id,country_code) REFERENCES art_lang_master (lang_id,country_code),
  CONSTRAINT art_chart_prop_language1 FOREIGN KEY (property_id) REFERENCES art_chart_properties (property_id)
);

exit

