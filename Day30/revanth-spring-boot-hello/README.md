# revanth-spring-boot-hello
ci cd repository for springboot

## Create seprate repository in git hub

## Clone the project

## Create springboot application

## Build Project

    mvn clean install

## Run the project

    mvn spring-boot:run

## Dockerize the application

    docker build -t revanth-spring-boot-hello .

## List docker image

    docker images

## Run and verify the docker images

    docker run -p 8080:8080 revanth-spring-boot-hello:latest
    http://localhost:8080/hello
    http://localhost:8080/actuator/health

## Create ECR for Spring app
```Bash
    aws cloudformation deploy --template-file ecr-template.yml --stack-name revanth-spring-ecr-repo 
```
## Create Code build pipe
    provide the github url
    update the access token and verify its connected
    checkbox for buildspec.yml
    copy the role and keep it seprately

## Trigger the Build

## If it fails

    update the policy with folloing inline
    AmazonEC2ContainerRegistryFullAccess
    AmazonEC2ContainerRegistryPowerUser
## Re build
    Success
## Tagging if not using build-$(echo $CODEBUILD_BUILD_ID | awk -F":" '{print $2}') the update with below
    docker tag revanth-spring-boot-hello:latest 975050323630.dkr.ecr.us-east-1.amazonaws.com/revanth-spring-boot-hello:latest

## Create ECS Service and Task infra
```Bash
    aws cloudformation deploy --template-file ecs-farget-cluster.yml  --stack-name revanth-cluster-hello --capabilities CAPABILITY_NAMED_IAM 
```