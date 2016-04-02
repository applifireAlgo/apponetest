CREATE TABLE zen_health_status (  healthId varchar2(64) NOT NULL,  scheduledDateTime timestamp(0) NOT NULL,  freeSpace binary_double NOT NULL,  status varchar2(256) NOT NULL,  serverInstanceId number(3) NOT NULL,  usedSpace binary_double NOT NULL,  serverIpAddress varchar2(30) NOT NULL,  totalSpace binary_double NOT NULL,  PRIMARY KEY (healthId));

exit

