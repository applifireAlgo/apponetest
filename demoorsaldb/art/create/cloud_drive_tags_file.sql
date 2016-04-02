CREATE TABLE cloud_drive_tags_file ( id number(10) NOT NULL, file_id varchar2(64) DEFAULT NULL, tag_id varchar2(64) DEFAULT NULL, PRIMARY KEY (id), CONSTRAINT fk_file_id FOREIGN KEY (file_id) REFERENCES cloud_drive_files (file_id) );

CREATE SEQUENCE cloud_drive_tags_file_seq START WITH 1 INCREMENT BY 1;

CREATE INDEX fk_file_id ON cloud_drive_tags_file (file_id);

CREATE OR REPLACE TRIGGER cloud_drive_tags_file_seq_tr
 BEFORE INSERT ON cloud_drive_tags_file FOR EACH ROW
WHEN (NEW.ID IS NULL)
BEGIN
 SELECT cloud_drive_tags_file_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

exit

