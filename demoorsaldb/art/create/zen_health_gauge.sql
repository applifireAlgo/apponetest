CREATE TABLE zen_health_gauge (   gaugeId VARCHAR2(64) NOT NULL,   scheduledDateTime timestamp(0) NOT NULL,  methodHitCount binary_double NOT NULL,  serverInstanceId number(11) NOT NULL,  methodHitTime binary_double NOT NULL,  serverIpAddress VARCHAR2(256) NOT NULL,  serviceName VARCHAR2(256) NOT NULL,  methodName VARCHAR2(32) NOT NULL,  PRIMARY KEY (gaugeId));

exit

