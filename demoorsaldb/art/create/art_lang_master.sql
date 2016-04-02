CREATE TABLE art_lang_master (
lang_id varchar2(64) NOT NULL ,
lang_name varchar2(50) DEFAULT NULL,
country_code varchar2(10) NOT NULL,
country_name varchar2(100) DEFAULT NULL,
updated_by varchar2(64) NOT NULL,
updated_date date NOT NULL,
created_by varchar2(64) NOT NULL,
created_date date NOT NULL,
version_id number(10) NOT NULL,
active_status number(10) NOT NULL,
PRIMARY KEY (lang_id,country_code)
);

exit

