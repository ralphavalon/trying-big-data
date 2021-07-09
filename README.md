# About The Project

## What you will need

* Docker
* Docker Compose

## What the project uses

* Java 11
* Spring Boot
* PostgreSQL
* RabbitMQ

## How It Works

![Architecture](architecture.png)

* The `Trying_IOT` application generates the following data from time to time:

```
{
  "value": {{random numbers}},
  "type": {{THERMOSTAT|HEART_RATE|CAR_FUEL}},
  "userId": {{generated uuid for that instance}},
  "createdAt": {{now}}
}
```

* Then, sends to `Trying_Big_Data` project through REST API. After that, the API sends to a RabbitMQ. For now, there's no transformation of data.
* Since there's no transformation, the application reads the message and saves on a PostgreSQL.
* The `Trying_Big_Data` application then reads the data from PostgreSQL and apply the operations (e.g. median, max, min)

<details>
<summary>PlantUML Code</summary>

```
@startuml
database MongoDB
node Trying_IOT
node Trying_Big_Data

Trying_IOT -> Trying_Big_Data
Trying_Big_Data -> [RabbitMQ]
[RabbitMQ] -> Trying_Big_Data
Trying_Big_Data -> [PostgreSQL]
Trying_Big_Data ..> REST : use

skinparam node {
    borderColor Green
    backgroundColor Yellow
    backgroundColor<<shared node>> Magenta
}

skinparam component {
    backgroundColor Aqua
}
@enduml
```

</details>

# How To Start

* Run this command

`docker-compose up`

* If you want to scale the application (more different users), just run:

`docker-compose up -d --scale iot=3`

* When the application starts, you can go to http://localhost:8080/ and try some requests using the Swagger.