# SimpleBoardApp
This is Simple Bulletin Board using Spring framework
<ul>
<li>More Information you want, visit my blog, www.donkunny.com</li>
<li>Demo test app is uploaded here, <a href="http://www.donkunny.com:8080/SimpleBoardApp/list">SimpleBoardApp</a></li>
<li>Any commands are fine. Thank you</li>
</ul>
## Tutorial
###### If you don't have Tomcat and mysql, install them in your server or localhost.
##### 1) Download file and import it into STS(or Eclipse)<br>
##### 2) Make property file in WEB-INF/properties/db.properties<br>
##### 3) Copy it as follows
```
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/board?useUnicode=true&characterEncoding=utf8
jdbc.username={your user name}
jdbc.password={your password}
```
##### 4) Make database and table in mysql
```
# Log in mysql with your id and pwd
mysql> mysql -u {id} -p

# Create db and table
mysql> CREATE DATABASE board;
mysql> use board;
mysql> CREATE TABLE BOARD IF NOT EXISTS (
            seq INT PRIMARY KEY AUTO_INCREMENT,
            title VARCHAR(255) NOT NULL,
            content VARCHAR(1000) NOT NULL,
            writer VARCHAR(10) NOT NULL,
            password INT NOT NULL,
            regDate TIMESTAMP,
            cnt INT NOT NULL );
 
# Check the field name and type
mysql> desc BOARD;
```
##### 5) Check previleges your database
```
# If your id doesn't have previleges to your db, Server cannot access your db.
# please check it
mysql> SHOW GRANTS FOR 'your id'@'localhost';
Grants for {your id}@localhost
GRANT ALL PRIVILEGES ON `board`.* TO 'your id'@'localhost'

# If your id doesn't have privileges, grant them.
mysql> GRANT ALL PRIVILEGES ON {DB Name}.* TO {your id}@localhost IDENTIFIED BY 'password' WITH GRANT OPTION;
```
##### 6) Check utf-8
```
mysql>status;
or
mysql>show variables like 'char%';

# If values are not utf8, you shoud change it to utf8
[root ~]$ sudo vi /etc/my.cnf

# Copy it
[mysqld]
# set utf-8
init_connect=SET collation_connection = utf8_general_ci
init_connect=SET NAMES utf8
collation-server = utf8_general_ci
character-set-server = utf8
[client]
character-sets-dir=utf8
```

### reference: 스프링 입문을 위한 자바 객체 지향의 원리와 이해(김종민 저, 위키북스)
