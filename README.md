
## Local Setup

### Database

docker run --name demo_db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

### Run

./mvnw spring-boot:run

### Test

./mvnw test

## Build

### Development

./mvnw clean package -Pdev

### Production

./mvnw clean package -Pprod

## Deploy docker image

./mvnw dockerfile: push -P${env}
