load data infile '$ART_DATA_PATH/art_table_field_details.csv' into table art_table_field_details FIELDS TERMINATED BY '#appfire#' (field_id,table_id,field_name,data_type,datatype_precision,is_pkey,is_null,is_auto_inc,is_unique,is_fkey,reff_key,reff_table,primary_display,default_value,
system_field,column_sequence,display_json CHAR(30000),project_id,app_creator_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status,field_order,field_group,target_field,transient_field,ui_permission)

