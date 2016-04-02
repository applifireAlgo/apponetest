CREATE TABLE art_password_algorithm ( algoId varchar2(256) NOT NULL, algorithm varchar2(256) NOT NULL, algoName varchar2(256) NOT NULL, algoDescription varchar2(256) DEFAULT NULL, active_status number(10) DEFAULT '1', created_date timestamp(0) DEFAULT TO_TIMESTAMP('1900-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS.FF'), updated_by varchar2(64) DEFAULT '-1', version_id number(10) DEFAULT '-1', created_by varchar2(64) DEFAULT '-1', updated_date timestamp(0) DEFAULT TO_TIMESTAMP('1900-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS.FF'), PRIMARY KEY (algoId) );

exit

