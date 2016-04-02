CREATE TABLE zen_health_counter (  counterId varchar2(64) NOT NULL ,  serverInstanceId number(10) NOT NULL,  httpStatus varchar2(256) NOT NULL,  serverIpAddress varchar2(256) NOT NULL,  serviceName varchar2(32) NOT NULL,  scheduledDateTime timestamp(0) NOT NULL,  statusCount number(10) NOT NULL,  methodName varchar2(100) NOT NULL,  counterType number(10) NOT NULL,  PRIMARY KEY (counterId));

exit

