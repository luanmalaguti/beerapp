# beerapp

> Simple web app that displays details about a random beer

The project is divided into client and server, each one runs separately.

## Usage

### Client
AngularJS project using Bootstrap

* Requirements
  - Node installed - npm as a PATH variable 
  - Git installed - git as PATH variable

```console
$ git clone https://github.com/luanmalaguti/beerapp.git
$ cd beer-client
$ npm start
```
The application will be running on http://localhost:8000

### Server
Spring Boot-based project who provides REST services to be consumed by the client

* Requirements
  - Java 8

```console
$ git clone https://github.com/luanmalaguti/beerapp.git
$ cd beer-rest-server

# Executable JAR
$ java -jar beer-rest-service-1.0.0.jar

# Run the source as Java project
$ eclipse > file > Import Existing Maven Projects > beer-rest-service
$ ie.donedeal.beerapp.app.BeerApp.java > Run as Java Application
```
The application will be running on http://localhost:8080
