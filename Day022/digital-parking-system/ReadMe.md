## Build Application

    mvn clean install

## Start localstack docker 

    docker-compose up

## Running Local Profiles

    mvn spring-boot:run -Dspring-boot.run.profiles=local

## Check the Actuator Health Endpoint
    curl -X GET "http://localhost:8080/actuator/health"

## Start Parking

    curl -X POST "http://localhost:8080/parking/start?parkingNo=12345" \
     -H "Content-Type: application/json" \
     -d '{
          "ownerName": "John Doe",
          "regNo": "KA-01-AB-1234",
          "model": "Tesla Model 3",
          "type": "Electric"
        }'

## End Parking
    curl -X POST "http://localhost:8080/parking/end?regNo=KA-01-AB-1234"


## Dockerization

    docker build -t parking-app .

## List docker images

    docker images

## Start and run both container same time

    docker-compose up

## Stop docker container
    
    docker-compose down
