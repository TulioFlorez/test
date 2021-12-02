# Rest Web Service TEST WEB project
------------------------------------------------------

This projects shows the basic configuration needed to start a Rest web service project test. 

## Install
```sh
mvn clean install
mvn install
````
or IDE
```sh 
 right-click on test>maven>update project 

right-click on test>Run as>Maven Install
````
### Run WS
```sh 
right-click on test>Run as >springBoot App 
````
## Docker usage
Build the project and the Docker image with
```
mvn clean install
```
Then run the container exposing port 8080
```
docker run -it -p 8080:8080 test:0.0.1-SNAPSHOT
```


### HTTP methods and actions
 
 you need to identify what actions you want to use according to the instructions of the test

* To retrieve a manefacturers or  beers, use GET.
  * GET http://localhost:8080/manufacturers  - Retrieves a list of manufacturers
  * GET http://localhost:8080/manufacturers/1  - Retrieves a specific manufacturer
  * GET http://localhost:8080/beers - Retrieves a list of beers(you can also search by any beer attribute, sort the collection or get pagination)
  * GET http://localhost:8080/beers/1 - Retrieves a specific beer (in case the beer does not exist in BBDD, it get the information from punkapi.com) 
* To create a resource on the server, use POST.
  * POST http://localhost:8080/manufacturers - Creates a new manufacturer, use the body to send manufacturer data in JSON format 
  * POST http://localhost:8080/beers - Creates a new beer, use the body to send manufacturer data in JSON format (you can not create Beer if it does not have the manufacturerid created in BBDD)
* To change the state of a resource or to update it, use PUT.
  * PUT http://localhost:8080/manufacturers/1  - Update manufacturer 1, use the body to send manufacturer data in JSON format 
  * PUT http://localhost:8080/beers/1- Update manufacturer 1, use the body to send manufacturer data in JSON format 
* To remove or delete a resource, use DELETE.
  * DELETE http://localhost:8080/manufacturers/1  - Delete manufacturer 1 
  * DELETE http://localhost:8080/beers/1  - Delete beer 1 

## Swagger API (API documentation)
ui
```sh
- http://localhost:8080/swagger-ui.html#
````
JSONFormat
```sh
- http://localhost:8080/v2/api-docs
````
## H2 Database Engine console
```sh
http://localhost:8080/h2-console/    (Database available at 'jdbc:h2:mem:testdb')
````

## Example Request POST 
### POST (Manufacturers)                                                                                                                 
	http://localhost:8080/manufacturers
 #### Requests
     {
        "name": "belgaAB",
        "nationality": "Mexico"
    }
### POST (Beers)                                                                                                                 
	http://localhost:8080/beers
 #### Requests
    {
        "description": "A light, crisp and bitter IPA brewed with English and American hops.",
        "manufactureId": 1,
        "name": "corona",
        "privategraduation": "normal",
        "type": "strong"
}
## Example Request PUT 
### PUT (Manufacturers)                                                                                                                 
