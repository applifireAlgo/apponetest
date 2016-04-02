load data infile '$ART_DATA_PATH/art_service.csv' into table art_service FIELDS TERMINATED BY '#appfire#' (service_id,service_name,service_class,service_json CHAR(20000),source_details CHAR(20000),status,project_id,app_creator_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status,dao_id)

