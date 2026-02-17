💳 Payment API — Backend de Banco Digital

API REST em Java + Spring Boot que simula operações essenciais de um banco digital: criação de usuários, contas bancárias e transferências financeiras entre contas.

O projeto foi desenvolvido como demonstração técnica, focando em boas práticas de backend, regras de negócio financeiras e organização arquitetural.

🧠 Conceitos e Boas Práticas Demonstradas

Arquitetura em camadas: Controller → Service → Repository

Modelagem relacional com JPA/Hibernate

Regras de negócio para validação de saldo

Controle transacional em transferências

Tratamento de exceções e logs estruturados

API REST seguindo padrões HTTP

DTOs para entrada e saída de dados, mantendo a separação de camadas

Integração com RabbitMQ para processamento assíncrono de transferências

🗺️ Modelagem de Dados

O sistema possui três entidades principais:

<img width="646" height="495" alt="Modelo de dados Payment API" src="https://github.com/user-attachments/assets/e3504b2a-883d-449b-894c-9e6314de337e" />
⚙️ Como Rodar o Projeto
✅ Pré-requisitos

Java 17 ou superior

Maven 3.8+

Git

📥 Clonar o Repositório
git clone https://github.com/Gabrqueiroz/payment-api.git
cd payment-api

▶️ Executar a Aplicação
./mvnw spring-boot:run
# ou
mvn spring-boot:run


A API estará disponível em:
http://localhost:8080

🗄️ Banco de Dados (H2 Console)

Banco em memória para facilitar testes:

URL: jdbc:h2:mem:paymentdb

Usuário: sa

Senha: (em branco)

Acesse o console:
http://localhost:8080/h2-console

📝 Documentação da API

Swagger UI disponível em:
http://localhost:8080/swagger-ui/index.html#/

📈 Próximas Evoluções

Autenticação com JWT + Keycloak

Histórico/Extrato bancário por conta

Testes unitários e integração (JUnit + Mockito)

Deploy em nuvem (AWS, Render ou Railway)

Melhorias em mensageria e logs assíncronos

👨‍💻 Autor

Gabriel Queiroz — Backend Developer (Java & Spring Boot)
