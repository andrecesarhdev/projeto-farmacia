Projeto Farmácia (CRUD Spring Boot + MySQL)
# Projeto Farmácia

## O que é este projeto?
Este é um sistema simples para gerenciar produtos de uma farmácia.  
Você pode **adicionar, listar, atualizar e deletar produtos** usando uma API REST.  
Ele foi feito com **Java Spring Boot** e **MySQL**.

---

## Funcionalidades
- Listar todos os produtos
- Cadastrar um novo produto
- Atualizar um produto existente
- Deletar um produto
- Visualizar a API pelo Swagger

---

## Tecnologias usadas
- Java 17
- Spring Boot
- MySQL
- Maven
- Swagger (OpenAPI) para documentação da API

---

## Como configurar o banco de dados
1. Abra o MySQL e crie o banco e usuário:
```sql
CREATE DATABASE farmacia_db;
CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'senha';
GRANT ALL PRIVILEGES ON farmacia_db.* TO 'usuario'@'localhost';
FLUSH PRIVILEGES;


Abra o arquivo application.properties e configure:

spring.datasource.url=jdbc:mysql://localhost:3306/farmacia_db
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Como rodar o projeto

Abra o terminal na pasta do projeto

Rode o comando:

mvn spring-boot:run


Acesse a API pelo navegador ou Postman:

http://localhost:8080/api/products


Veja a documentação no Swagger:

http://localhost:8080/swagger-ui/index.html
