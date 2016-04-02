load data infile '$ART_DATA_PATH/art_rules.csv' into table art_rules FIELDS TERMINATED BY '#appfire#' (rule_id,rule_name,rule_drl,updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status,project_id,project_version_id,app_creator_id)

