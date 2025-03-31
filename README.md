# Fintrack App

RESTful API de controle de gastos construída com Java 21 e Spring Boot 3.

## Principais Tecnologias 
- **Java 21**: Versão LTS do Java
- **Spring Boot 3**: Escolhi esse framework por ser autoconfigurável e o mais utilizado do mercado
- **Spring Data Jpa**: Integração simples e de fácil configuração com o banco de dados SQL;
- **OpenAPI (Swagger) 2.8.6**: Uma documentação de API fácil de entender com o Swagger.
- **Railway**: Fazendo meu primeiro DEPLOY utilizando uma ferramenta simples de CI/CD na nuvem.

Caso queira criar seu projeto do zero usando as mesmas dependencias:

[Spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.4.4&packaging=jar&jvmVersion=21&groupId=com.example.fintrack&artifactId=fintrack&name=fintrack&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.fintrack&dependencies=devtools,lombok,data-jpa,web)

## Diagramas de Classes (Domínio da API)

## Instrução de uso


## API Endpoints
A API possuí os principais endpoints:
```
POST /auth/register - Registra um novo usuário e retorna um TOKEN.
POST /auth/login - Login dos usuários na aplicação.
POST /expenses/new-expense - Registra um novo gasto do usuário.
GET /expenses - Retorna todos os gastos registrados do usuário. 
```
