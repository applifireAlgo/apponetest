CREATE TABLE art_session_data (
  sessionid varchar2(45) NOT NULL,
  sno number(10) NOT NULL,
  sessionDataType varchar2(45) DEFAULT NULL,
  sessionData clob,
  version_id number(10) DEFAULT NULL,
  PRIMARY KEY (sno)
)  ;

exit

