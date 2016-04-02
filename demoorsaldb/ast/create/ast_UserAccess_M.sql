CREATE TABLE ast_UserAccess_M ( userId VARCHAR2(64)  NOT NULL, region VARCHAR2(64)  NOT NULL, userAccessId NUMBER(10)  NOT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '11-nov-01', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '11-nov-01', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (userAccessId));
CREATE SEQUENCE ast_UserAccess_M_seq START WITH 1 INCREMENT BY 1;


exit;