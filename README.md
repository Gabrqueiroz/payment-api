💳 Payment API — Digital Banking Backend

API REST desenvolvida em Java + Spring Boot que simula as principais operações de um banco digital:

Criação de usuários

Abertura de contas bancárias

Transferências financeiras entre contas

Processamento assíncrono via mensageria

O projeto foi desenvolvido como simulação realista de um core bancário simplificado, com foco em:

Boas práticas de arquitetura

Regras de negócio financeiras

Consistência transacional

Separação de responsabilidades

Escalabilidade futura

🏗️ Arquitetura

O projeto segue arquitetura em camadas:

Controller → Service → Repository

Com separação clara entre:

Camada de entrada (API)

Regras de negócio

Persistência

Mensageria

DTOs para isolamento de domínio

🧠 Conceitos e Boas Práticas Demonstradas

✔️ Arquitetura em camadas bem definida
✔️ Modelagem relacional com JPA/Hibernate
✔️ Controle transacional com @Transactional
✔️ Validação de regras de negócio (saldo, transferências inválidas)
✔️ Tratamento global de exceções
✔️ Logs estruturados
✔️ DTOs para desacoplamento da camada de domínio
✔️ Integração com RabbitMQ para processamento assíncrono
✔️ Testes unitários com JUnit e Mockito

🗂️ Modelagem de Dados

O sistema possui três entidades principais:

User → Representa o cliente do banco

Account → Conta bancária vinculada ao usuário

Transaction → Registro de transferências realizadas

Relacionamentos:

Um usuário pode possuir múltiplas contas

Uma conta pode possuir múltiplas transações

🔁 Fluxo de Transferência

Validação das contas (origem e destino)

Verificação de saldo suficiente

Débito da conta origem

Crédito da conta destino

Persistência da transação

Publicação de evento via RabbitMQ

Confirmação transacional

Garantindo:

Consistência

Atomicidade

Integridade financeira

⚙️ Tecnologias Utilizadas

Java 17

Spring Boot

Spring Data JPA

Hibernate

H2 Database

RabbitMQ

JUnit 5

Mockito

Swagger (OpenAPI)

🚀 Como Executar o Projeto
✅ Pré-requisitos

Java 17+

Maven 3.8+

Git

📥 Clonar o Repositório
git clone https://github.com/Gabrqueiroz/payment-api.git
cd payment-api
▶️ Executar a Aplicação
./mvnw spring-boot:run

ou

mvn spring-boot:run

A aplicação estará disponível em:

http://localhost:8081
🗄️ Banco de Dados (H2)

Banco em memória configurado para facilitar testes e demonstração.

JDBC URL: jdbc:h2:mem:paymentdb

Usuário: sa

Senha: (em branco)

Console disponível em:

http://localhost:8081/h2-console

📘 Documentação da API

Swagger UI disponível em:

http://localhost:8081/swagger-ui/index.html

Permite testar todos os endpoints diretamente pela interface web.

🧪 Testes

O projeto possui testes unitários utilizando:

JUnit 5

Mockito

Focados na validação das regras de negócio da camada de Service.

📈 Próximas Evoluções

Autenticação com JWT

Integração com Keycloak

Extrato detalhado por período

Testes de integração

Banco PostgreSQL

Deploy em nuvem (AWS / Render / Railway)

Dockerização

Monitoramento com Actuator

Observabilidade (logs estruturados + tracing)

👨‍💻 Autor

Gabriel Queiroz

Backend Developer — Java & Spring Boot
