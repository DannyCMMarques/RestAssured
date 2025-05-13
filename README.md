# 🧪 Testes Automatizados de API – CRUD Naruto com Rest Assured e Cucumber

Este projeto tem como objetivo testar e validar funcionalidades de uma API REST inspirada no universo Naruto. Os testes foram desenvolvidos utilizando **Rest Assured** para as requisições HTTP e **Cucumber** para escrita dos cenários BDD (Behavior Driven Development).

## 📌 Entenda o Projeto Antes de Rodar os Testes

Antes de executar os testes automatizados, é essencial conhecer a API alvo do desafio. A API que está sendo testada pode ser encontrada no repositório abaixo:

🔗 [CRUD Naruto - Documentação da API](https://github.com/DannyCMMarques/Crud-Desafio-Ninja)

Recomendamos revisar o funcionamento dos endpoints e entidades envolvidas  para compreender o propósito de cada teste.

---

## ✅ Funcionalidades Testadas

Foram automatizados cenários para as seguintes funcionalidades:

- **Funcionalidade: Operações com batalhas**
  - Criação de batalhas
  - Consulta de batalha por id

- **Funcionalidade: Operações com participantes em batalhas**
  - Cadastro de participantes em batalhas
  - Exclusão de participantes batalha
  - Exibição de participantes batalha

- **Funcionalidade: Operações com usuários do sistema**
  - Registro de novos usuários
  - Listagem dos Usuários
  - Exclusão de usuários
  -Busca por id

- **Funcionalidade: Autenticação de usuários**
  - Login com credenciais válidas
  - Validação de token JWT

- **Funcionalidade: Operações com personagens do sistema**
  - Criação
  -  Listagem dos personagens
  - Edição dos personagens
  - Busca de personagens por id
   - Exclusão de personagens.

Ao todo, foram cobertos **27 cenários de teste**, contemplando fluxos positivos e negativos para garantir robustez da API.

---

## 🚀 Como Executar os Testes

1. Clone o projeto principal da API (caso ainda não tenha):
   ```bash
   git clone https://github.com/DannyCMMarques/Crud-Desafio-Ninja.git
   cd demo
   docker-compose build
   docker-compose up
   ```

2. Clone este repositório de testes:
   ```bash
   git clone https://github.com/DannyCMMarques/RestAssured.git
   cd demo
   ```

3. Execute os testes com Maven:
   ```bash
   mvn test
   ```

4. Para executar testes específicos usando tags (exemplo com `@batalha`):
   ```bash
   mvn test -Dcucumber.filter.tags="@batalha"
   ```


---

📌 **Observação:** Os testes são executados diretamente sobre a API em funcionamento. Certifique-se de que o backend esteja ativo antes de iniciar os testes.
