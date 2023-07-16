# Agrotis-challenge

## Table of Contents

- [Dependencies](#dependencies)
- [How to use](#how-to-use-this-repository)

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


</details>

## How to use this repository

### Prerequisites

* Globally install Java 8
* Globally install Maven
* Globally install Docker

### Installation

1. Clone this repository.
2. Run the command "mvn install" on this repository's folder.
3. Run the command "docker-compose up" on this repository's folder in order to run the mysql docker image.
4. Run the command "mvn spring-boot:run" on this repository's folder in order to run the application.

### How to use
