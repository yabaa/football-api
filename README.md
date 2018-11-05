# football-api

## Start the PostgreSQL database
`docker run --name football-api-db -p 5432:5432 -e "POSTGRES_USER=footballapi" -e "POSTGRES_PASSWORD=footballapi" -e "POSTGRES_DB=football-db" -d postgres:9.6`
