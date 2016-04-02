CREATE TABLE ast_CommunicationMap_B ( commMapId NUMBER(11)  NOT NULL, contactId VARCHAR2(64)  NOT NULL, commDataId VARCHAR2(64)  NOT NULL, PRIMARY KEY (commMapId));
CREATE SEQUENCE ast_CommunicationMap_B_seq START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER ast_CommunicationMap_B_seq_tr
 BEFORE INSERT ON ast_CommunicationMap_B FOR EACH ROW
WHEN (NEW.commMapId IS NULL)
BEGIN
 SELECT ast_CommunicationMap_B_seq.NEXTVAL INTO :NEW.commMapId FROM DUAL;
END;
/

exit;