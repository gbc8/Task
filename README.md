# Task
A aplicação é um sistema no qual é possível cadastrar e concluir tarefas em uma interface web.

O projeto foi desenvolvido utilizando a abordagem de arquitetura em camadas. Apesar de ser um exagero para um projeto CRUD, ela foi adota baseado na hipótese de uma futura necessidade extensão da aplicação. Dessa forma, poderia-se aproveitar das vantagens dessa abordagem, como a possibilidade de modificar uma camada sem inteferir nas outras.

##### Requisitos atendidos:
 Spring Boot \
 Hibernate\
 REST \
 MySQL\
 React\
 Ant Design\
 
##### Requisitos não atendidos:
 Upload de imagem\
 Redux\
 Redux-Saga\
 Jackson 

## Instruções de execução
### Docker

Execute `docker-compose up` no diretório do projeto

### Manual

##### Pré-requisitos:
Banco de dados MySQL executando com os seguintes parâmentros:\
URL: localhost\
Porta: 3306\
Nome de usuário: root\
Senha: MyPassword1\
Nome do banco: taskdb

OBS: Esses parâmetros podem ser alterados no arquivo `properties.yml` dentro do diretório `task-backend` ou passados como variáveis de ambiente (DB_HOST,DB_PORT,DB_NAME,DB_USERNAME,DB_PASSWORD).

##### Comandos:
Execute `mvn spring-boot:run` dentro do diretório `task-backend`.\
Execute `npm install` detro do diretório `task-frontend`.


##### Portas utilizadas:
Backend: 8082\
frontend: 3000