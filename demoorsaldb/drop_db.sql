connect sys/oracle as sysdba
declare
CURSOR c1 is select * from SYS.USER_TABLES WHERE TABLESPACE_NAME='demoorsal';
TABLENAME c1%ROWTYPE;
v_exists integer;
begin
FOR item IN c1
LOOP
execute immediate 
'DROP TABLE ' || item.TABLE_NAME || ' CASCADE CONSTRAINTS';
END LOOP;
SELECT count(*) INTO v_exists FROM dba_tablespaces WHERE tablespace_name = 'DEMOORSAL';
if(v_exists>0) then
execute immediate 'DROP TABLESPACE demoorsal INCLUDING CONTENTS AND DATAFILES';
end if;
end;
/
exit;
