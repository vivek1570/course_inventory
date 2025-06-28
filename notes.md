mysql root password:
MyNewPass

javasql database:
mydb
javauser
javapass

If logged in as javauser:

You may only see mydb, or whatever databases javauser has permission to access.

If you want javauser to see/use another DB, you must:

GRANT ALL ON your_db_name.\* TO 'javauser'@'localhost';
FLUSH PRIVILEGES;

(Only root can do this)

- how can enter into the table and how to acces it:
  mysql -u root -p

**how to run the sql based java by linking the connector**

vivek@pop-os:~/java_pro/java_sql$ javac -cp .:mysql-connector-j-9.3.0.jar MySQLConnect.java
^[[Avivek@pop-os:~/java_pro/java_sjava -cp .:mysql-connector-j-9.3.0.jar MySQLConnect
