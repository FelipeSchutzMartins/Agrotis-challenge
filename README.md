# Agrotis-challenge

## Dependencies

<details>
<summary>Click to expand!</summary>

| **Dependency**      | **Version** |
|---------------------|:-----------:|
| Spring Boot         |    3.1.1    |
| Spring Data JPA     |    3.1.0    |
| MySQL               |     8.x     |
| Lombok              |   1.18.26   |
| Java Validation API |    3.0.6    |
| Flyway-core         |    9.16.3   |
| Flyway-mysql        |    9.20.1   |
| H2 database         |   2.1.210   |


</details>

## How to use this repository

### Prerequisites

* Globally install Java
* Globally install Maven
* Globally install Docker

### Installation

1. Clone this repository.
2. Run the command "docker-compose up" on this repository's folder in order to run Docker's Mysql image.
3. Run the command "mvn install" on this repository's folder.
4. Run the command "mvn spring-boot:run" on this repository's folder in order to run the application.

### Tests

1. Run the command "mvn test" on this repository's folder.

### Endpoints
|  **Method** | **Route** |
|-------------|:---------:|
|    GET      | /laboratory/show/{id} |
|    GET      | /laboratory/findAll |
|    POST     | /laboratory/create  |
|    PUT      | /laboratory/update  |
|    DELETE   | /laboratory/delete/{ids} |
|||
|    GET      | /property/show/{id} |
|    GET      | /property/findAll |
|    POST      | /property/create  |
|    PUT     | /property/update  |
|    DELETE   | /property/delete/{ids} |
|||
|    GET      | /propertyOwner/show/{id} |
|    GET      | /propertyOwner/findAll |
|    POST      | /propertyOwner/create  |
|    PUT     | /propertyOwner/update  |
|    DELETE   | /propertyOwner/delete/{ids} |

### Delete endpoint examples
#### /Laboratory/delete/1,2
#### /property/delete/1,2
#### /propertyOwner/delete/1,2

### Request body examples
#### POST /Laboratory/create
```
{
	"name": "Agro Skynet"
}
```
#### PUT /Laboratory/update
```
{
	"id": 1,
	"name": "Agro Skynet"
}
```
#### POST /property/create
```
{
	"name": "Agrotis 1",
	"cnpj": "08562685000171"
}
```
#### PUT /property/update
```
{
        "id": 1,
	"name": "Agrotis 1",
	"cnpj": "08562685000171"
}
```

#### POST /propertyOwner/create
```
{
	"name": "Jon doe",
	"startDate": "2022-02-02",
	"endDate": "2022-02-02",
	"observations": "Observacao exemplo de teste",
	"propertyId": "2",
	"laboratoryId": "2"
}
```
#### PUT /propertyOwner/update
```
{
        "id": 1,
	"name": "Jon doe",
	"startDate": "2022-02-02",
	"endDate": "2022-02-02",
	"observations": "Observacao exemplo de teste",
	"propertyId": "2",
	"laboratoryId": "2"
}
```
