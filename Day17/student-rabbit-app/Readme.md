## RabbitMq application

### Build application

    mvn clean install

### Running Application

#### Start docker compose

    docker-comnpose up

#### Start producer to send message

    mvn spring-boot:run

#### Send message to producer using rest

    curl --location 'http://localhost:8082/send?msg=Hi'

    curl --location 'http://localhost:8082/employee' \
    --header 'Content-Type: application/json' \
    --data '{
    "name": "emp1",
    "empid": "id1",
    "age":25
    }
    '
### View the data on rabbit console

    http://localhost:15672/
    username: guest
    password:guest

    visulise message in queue getMessage

### Run rabbit consumer

    mvn spring-boot:run

### Stop application
    
    stop consumer
    stop producer
    docker-compose down


