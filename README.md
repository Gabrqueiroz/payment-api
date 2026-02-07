# payment-api
Payment API — Digital Banking Backend

API REST desenvolvida em Java + Spring Boot que simula operações essenciais de um banco digital, incluindo criação de usuários, contas bancárias e transferências financeiras entre contas.

O projeto foi construído com foco em boas práticas de backend, regras de negócio financeiras e organização arquitetural, servindo como demonstração técnica de um sistema transacional.

🧠 Conceitos e Boas Práticas Demonstradas

✔ Arquitetura em camadas (Controller → Service → Repository)
✔ Modelagem relacional com JPA
✔ Regras de negócio para validação de saldo
✔ Controle transacional em transferências
✔ Tratamento de exceções e logs
✔ API REST seguindo padrões HTTP
✔ Organização de DTOs para entrada e saída de dados

🗺️ Modelagem de Dados

O sistema possui três entidades principais:
<img width="646" height="495" alt="image" src="https://github.com/user-attachments/assets/e3504b2a-883d-449b-894c-9e6314de337e" />

⚙️ Como Rodar o Projeto
✅ Pré-requisitos

Antes de iniciar, você precisa ter instalado:
Java 17 ou superior
Maven 3.8+
Git

📥 Clonar o Repositório
git clone https://github.com/Gabrqueiroz/payment-api.git
cd payment-api

▶️ Executar a Aplicação
./mvnw spring-boot:run

ou

mvn spring-boot:run


A API estará disponível em:

http://localhost:8080

🗄️ Banco de Dados (H2 Console)

Este projeto utiliza banco em memória para facilitar testes.

Acesse:

http://localhost:8080/h2-console


Use as seguintes configurações:

Campo	Valor
JDBC URL	jdbc:h2:mem:paymentdb
User	sa
Password	(em branco)

Swagger do projeto : http://localhost:8080/swagger-ui/index.html#/

📈 Próximas Evoluções

Autenticação com JWT
Extrato bancário por conta
Testes unitários (JUnit + Mockito)
Deploy em nuvem (AWS / Render)

Obs: Por enquanto está apenas na branch de develop

👨‍💻 Autor
Gabriel Queiroz
Backend Developer — Java & Spring Boot
