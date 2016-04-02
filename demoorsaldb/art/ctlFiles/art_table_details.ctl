load data infile '$ART_DATA_PATH/art_table_details.csv' into table art_table_details FIELDS TERMINATED BY '#appfire#' (table_id,entity_name,table_name,display_entity_name,table_type,domain,project_id,app_creator_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

