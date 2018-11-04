
# Database

## Local

docker run --name demo_db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

## Development

docker run --name demo_db_dev -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

## Production

docker run --name demo_db_prod -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

# Build

## Development

./mvnw clean package -Pdev

## Production

./mvnw clean package -Pprod

# Run

## Local

./mvnw spring-boot:run

# Test

./mvnw test

# Docker image

## Build application for specific env, push image to the docker hub

./mvnw dockerfile: push -P${env}
