# ***Rest-API***
-----------------------------------
-----------------------------------
# ***Stack используемых технологий:***
-----------------------------------
- Spring Boot
- Spring Data
- Spring MVC
- PostgreSQL
- Hibernate ORM
- JPA
- Maven
***
# ***Приложение использует базу данных PostgreSql перед сборкой исходника необходимо:***
-----------------------------------
### 1. ввести свои настройки бд в файле: \src\main\resources\application.properties 

Connection url for the database "postgres" spring.datasource.url=jdbc:postgresql://localhost:5432/postgres

Username and password spring.datasource.username=”username” spring.datasource.password=”password”

### 2. Ветка master собирает war file 
В консоли для сборки исходника необходимо ввести команду mvn clean install

### 3. Запуск осуществляйте либо в среде разработки,либо через TomCat. 
Если возникают проблемы с кодировкой,то не забывайте указать путь к системной переменной JAVA_OPTS="-Dfile.encoding=utf-8"

### 4. Приложение стартует на порту 8080 example: 
***
http://localhost:8080/RestApi/banks
***
http://localhost:8080/RestApi/clients
***
http://localhost:8080/RestApi/contributions
***
# ***Инструкция по работе с контроллером через http запросы:***
-----------------------------------
Используйте Postman или другие сервисы для работы с запросами.
***

# ***Работа с основной таблицей "contributions":***
-----------------------------------
### Вывести все записи из таблицы "contributions"
GET запрос : http://localhost:8080/contributions
### Вывести запись из таблицы "contributions" по id
GET запрос : http://localhost:8080/contributions/{id}
### Добавить запись в таблицу " contributions " 
POST запрос : http://localhost:8080/contributions/add
 ***
JSON пример : {
 "client_id":1,
 "bank_id":1,
 "open_date":"2020-20-20 20:20:20.000000",
 "persent":13.22,
 "term_in_months":11
 }
 ***
### Обновить запись в таблице " contributions "  по id
POST запрос : http://localhost:8080/contributions/update
 ***
JSON пример : {
 "id":6,
 "client_id":1,
 "bank_id":1,
 "open_date":"2020-20-20 20:20:20.000000",
 "persent":13.22,
 "term_in_months":11
 }
 ***
### Удалить запись в таблице " contributions "  по id
DELETE запрос : http://localhost:8080/contributions/{id}
***
# ***Работа с таблицей "banks"***
-----------------------------------
### Вывести все записи из таблицы "banks"
GET запрос : http://localhost:8080/banks
### Вывести запись из таблицы "banks" по id
GET запрос : http://localhost:8080/banks/{id}
### Добавить запись в таблицу "banks"
POST запрос : http://localhost:8080/banks/add
 ***
JSON пример : {
 "name":"ВТБ-94",
 "bik":256543232356456
 }
 ***
### Обновить запись в таблице "banks" по id
POST запрос : http://localhost:8080/banks/update
 ***
JSON пример : {
 "id":1,"name":"ВТБ-94",
 "bik":256543232356456
 }
 ***
# ***Работа с таблицей "clients"***
-----------------------------------
### Вывести все записи из таблицы "clients"
GET запрос : http://localhost:8080/clients
### Вывести запись из таблицы "clients"по id
GET запрос : http://localhost:8080/clients/{id}
### Добавить запись в таблицу "clients"
POST запрос : http://localhost:8080/clients/add
 ***
JSON пример : {
 "name":"Иванов Иван Иванович",
 "shortName":"Иванов И.И.",
 "address":"Ивановская д.35 кв.21 "
 }
 ***
### Обновить запись в таблице "clients"  по id
POST запрос : http://localhost:8080/clients/update
 ***
JSON пример : {
 "id":1,"name":"Иванов Иван Иванович",
 "shortName":"Иванов И.И.",
 "address":"Ивановская д.3 кв.21 "}
 ***
 
