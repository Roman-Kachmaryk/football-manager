# football-manager

Project Description
-------------
This is a Spring Boot-based web application. It allows you to create, read, update, and delete data relating to football clubs and football players.

This app stores data about football clubs and football players in a H2 in-memory database. The database has already been initialized with data placed in the `data.sql` file in the `resources` directory.


Features
-------------
You can perform the following operations:

Get a list of all football clubs (`GET: /football-clubs`), add a football club (`POST: /football-clubs`), update a football club by id (`PUT: /football-clubs/{id}`), delete a football club by id (`DELETE: /football-club/{id}`).

Get a list of all football players (`GET: /football-players`), add a football player (`POST: /football-players`), update a football player by id (`PUT: /football-players/{id}`), delete a football player by id (`DELETE: /football-players/{id}`).

You can also make transfer transactions that allow a football player to sign for another football club (`POST: /transfer`).

This app consists of repositories, services, and controllers as well as models, dto-classes and mappers.

Technology Stack
-------------
- Java 11
- Spring Boot
- Hibernate
- Maven

Getting Started
-------------
1. Clone this project.
2. Open it in your IDE.
3. Run the project.
4. Use Postman or any other software to send HTTP-requests and receive HTTP-responses.
5. You can also use this [Postman collection](https://go.postman.co/workspace/Team-Workspace~07c3f2a7-1f61-4805-87b5-7c3ff96574dc/collection/21520132-d8a63c56-ab8a-45c2-81fd-f211808f1125?action=share&creator=21520132) to send various HTTP-requests.
