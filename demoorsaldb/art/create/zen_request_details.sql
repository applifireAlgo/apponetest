CREATE TABLE zen_request_details (   requestId varchar2(46) NOT NULL,  className varchar2(150) DEFAULT NULL,  ipAddress varchar2(45) DEFAULT NULL,  requestTime timestamp(0) DEFAULT NULL,  requestMethod varchar2(45) DEFAULT NULL,  httpStatus varchar2(45) DEFAULT NULL,  returnStatus varchar2(45) DEFAULT NULL,  executionTime binary_double DEFAULT NULL,  methodName varchar2(45) DEFAULT NULL,  startTime timestamp(0) DEFAULT NULL,  endTime timestamp(0) NOT NULL,  typeofClass varchar2(11) DEFAULT NULL,  callSeqId number(11) DEFAULT NULL,  exceptionId number(11) DEFAULT NULL,  userId varchar2(45) DEFAULT NULL,  appSessionId varchar2(45) DEFAULT NULL);

exit

