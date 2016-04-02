




echo $PATH
DB_PATH=/tmp/applifire/db/BV2UQT3J7NHP07LGX6WWCA/A5286AD3-CF74-4BD8-9EF5-F183A14868C4
MYSQL=/usr/bin
USER=loadcheck
PASSWORD=loadcheck
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'