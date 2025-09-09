# Specialist on Spring Rest
Project will simulate the application the IFood, with objective academic in studying the Spring Rest API's

## Technologies
- JavaSE 11
- Spring Boot v2.2.4
- Docker
- Postgresql 15

## Run database
To run the database, we can install PostgreSQL on the machine, or we can run it in the Docker container.

To install PostgreSQL on the machine, follow the tutorial
- [Installing Postgres](https://github.com/rafaelcostab/tutoriais/blob/main/database/postgresql.md)

### In Docker
To run the database in Docker, you will need to install [Docker Desktop](https://docs.docker.com/desktop/setup/install/mac-install/).

Start Docker desktop.

### Run Docker compose
We will use Docker Compose to run the database.

Navigate to the root of the project where the `docker-compose.yml` file is located and run the command.

```sh
docker compose up --build -d
```

### Recreate the image
If you need to recreate the image from scratch, use the command
```sh
docker compose down -v
docker compose up --build -d
```

With the database running in the container, simply start the application and it will connect.
