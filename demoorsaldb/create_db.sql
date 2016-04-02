
connect sys/oracle as sysdba
create tablespace demoorsal DATAFILE '/u01/app/oracle/oradata/demoorsal.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='DEMOORSAL';
if (userexist = 0) then
execute immediate 'create user demoorsal identified by demoorsal default tablespace demoorsal';
end if;
end;
/
ALTER USER "DEMOORSAL" DEFAULT TABLESPACE "DEMOORSAL" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;