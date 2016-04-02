CREATE TABLE art_schedule_config ( schedule_id VARCHAR2(64) NOT NULL, schedule_name VARCHAR2(256) NOT NULL, schedule_job VARCHAR2(64) NOT NULL, scheduler_expression VARCHAR2(256) DEFAULT NULL, schedule_strategy CLOB NOT NULL, created_by VARCHAR2(64) DEFAULT '-1', created_date TIMESTAMP(0) DEFAULT TO_TIMESTAMP('1900-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS.FF'), updated_by VARCHAR2(64) DEFAULT '-1', updated_date TIMESTAMP(0) DEFAULT TO_TIMESTAMP('1900-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS.FF'), version_id NUMBER(10) DEFAULT '-1', active_status NUMBER(10) DEFAULT '1', PRIMARY KEY (schedule_id) ) ;

exit

