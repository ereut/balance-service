Sql script for creating schema and test data for it located in resources *db-dev-initial-data.sql*

Application during compiling build docker image **ereut/balance-service-image:1.0**

To run this image in docker container put command **docker run -p 8082:8080 ereut/balance-service-image:1.0** in console

Get request on URL <http://localhost:8082/balance-service/clients> will return all clients from MySql database

 