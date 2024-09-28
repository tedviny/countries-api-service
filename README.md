# Countries API Service

This project is a Spring Boot application that provides an API to access information about all countries in the world, including their names, capitals, flags, currencies, and more.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- Retrieve information about all countries.
- Information includes country name, capital, flag, currency, etc.
- Built with Spring Boot and Java.
- Uses Maven for dependency management.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11 or higher installed.
- Maven installed.
- An internet connection to download dependencies.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/countries-api-service.git
    cd countries-api-service
    ```

2. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
```

## API Endpoints

Get All Countries information
- URL: `/countries/all`
- Method: GET
- Description: Retrieves information about all countries, including their names, flags, currencies, and more.
- Response: A JSON array of country objects.
- Example Request: `curl -X GET http://localhost:8080/countries/all" -H "accept: application/json`


Get at least one country name matching information
- URL: `/country/name`
- Method: GET
- Description: Retrieves information about all countries names matching, including their names, flags, currencies, and more.
- Response: A JSON array of country objects.
- Example Request: `curl -X GET http://localhost:8080/country/france -H "accept: application/json"`

