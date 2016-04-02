




DB_PATH=/tmp/applifire/db/JAFRTOITE3ZP7JPEHMWKIW/A5286AD3-CF74-4BD8-9EF5-F183A14868C4
ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
USER=demoorsal
PASSWORD=demoorsal
HOST=localhost

echo 'drop db starts....'
sqlplus $USER/$PASSWORD @$DB_PATH/drop_db.sql;
sqlplus $USER/$PASSWORD @$DB_PATH/dropSequence.sql;
echo 'drop db ends....'

