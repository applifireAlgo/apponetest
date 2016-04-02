CREATE TABLE art_log_events_t (
  event_id number(19) NOT NULL,
  customer_id number(10) NOT NULL,
  app_name varchar2(20) NOT NULL,
  time_stamp timestamp(0),
  alarm_id number(10),
  severity varchar2(64),  
  user_id varchar2(200) ,
  ip_address varchar2(30),
  module varchar2(100) ,
  class_name varchar2(300) ,
  method_name varchar2(100),  
  message varchar2(2000) ,  
  throwable_message CLOB DEFAULT NULL NULL,
  FOREIGN KEY (severity) REFERENCES art_log_severity_m(severity_id)
);

exit

