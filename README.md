# TaskManager

Projeto para gerenciar tarefas,  aplicação permite que você crie tarefas, mude o status e exclua.

## Rotas

- Salvar Task: POST http://localhost:8080/task
- Buscar todas as Tasks: GET http://localhost:8080/task
- Buscar Task por id: GET http://localhost:8080/task/{id}
- Trocar status da Task por id: PUT http://localhost:8080/task/{id}
- Excluir Task: DELETE http://localhost:8080/task/{id}
- Excluir todas as tasks :DELETE http://localhost:8080/task

## Properties
spring.datasource.url=jdbc:mysql://localhost:3306/NomeDoSchema
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
