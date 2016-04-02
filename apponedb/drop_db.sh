




echo $PATH
DB_PATH=/tmp/applifire/db/W3GTR6N48DKVF5AKY0TZQ/A5286AD3-CF74-4BD8-9EF5-F183A14868C4
MYSQL=/usr/bin
USER=algo
PASSWORD=algo
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'