# football-api ⚽

A football api which will be used in a personal project.
This api will simply expose for the moment, all team in all main soccer leagues.
And in a second time I will expose all planned games. 
This project will help me to upskill on front end technologies. 
I will develop a react app which will consume datas from this api. 
Why football? Because I'm a big fan ⚽ 🇫🇷 ★★ ︎😀 

## Technical stack
- JAVA 11
- Spring Boot 2.1
- Swagger 2
- Mapstruct
- Maven
- ....to be completed

## Start the PostgreSQL database
`docker run --name football-api-db -p 5432:5432 -e "POSTGRES_USER=footballapi" -e "POSTGRES_PASSWORD=footballapi" -e "POSTGRES_DB=football-db" -d postgres:9.6`

## Swagger Access
Swagger can be accessed in localhost at http://localhost:8080/swagger-ui.html
