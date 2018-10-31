
# Setup Mysql database using docker

## Local

docker run --name demo_db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

## Development

docker run --name demo_db_dev -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

## Production

docker run --name demo_db_prod -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

# Build and Test

## Local

./mvnw clean package

## Development

./mvnw clean package -Pdev

## Production

./mvnw clean package -Pprod

# Run

## Local

./mvnw spring-boot:run

## Development

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev

## Production

./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
