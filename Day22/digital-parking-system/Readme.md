## Build Application

    mvn clean install

## Start localstack docker

    docker-compose up

## Start Parking

    curl -X POST "http://localhost:8080/parking/start?parkingNumber=12345" \
     -H "Content-Type: application/json" \
     -d '{
          "ownerName": "John Doe",
          "registrationNumber": "KA-01-AB-1234",
          "modelNumber": "Tesla Model 3",
          "fuelType": "Electric"
        }'


##  End Parking 

    curl -X POST "http://localhost:8080/parking/end?registrationNumber=KA-01-AB-1234"


## check queues in Rabbit MQ  - 

    http://localhost:15672/#/queues
 
## run and check data in mysql

    docker exec -it <container id> bash

    mysql -u user -p

## password
    password

    show databases;
    use parking;

    select * from car;
    select * from parking_start;
    select * from parking_end;

## Dockerization

    docker build -t digital-parking-system .

## List docker images

    docker images

## Start and run both container same time

    docker-compose up

## Stop docker container

    docker-compose down


