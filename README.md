# 🧪 Testes Automatizados de API – CRUD Naruto com Rest Assured e Cucumber

Este projeto tem como objetivo validar as funcionalidades de uma API REST  do universo Naruto, utilizando **Rest Assured** para interações HTTP e **Cucumber** para testes BDD.

## 📚 Tecnologias Utilizadas

- [Rest Assured](https://rest-assured.io/) – Testes de APIs REST em Java
- [Cucumber](https://cucumber.io/) – BDD (Behavior Driven Development)
- [JUnit](https://junit.org/) – Executor de testes
- [Maven](https://maven.apache.org/) – Gerenciador de dependências

## 🧭 Fluxo dos Testes Automatizado

Este projeto segue um fluxo dividido em etapas para garantir testes organizados e eficientes usando Cucumber + Rest Assured.

---

### ✅ 1. Entender o que a API faz e o que o negócio espera

> Esta etapa já foi concluída e documentada na seção principal do projeto.

🔗 Consulte os detalhes da API aqui: [CRUD Naruto - Documentação da API](https://github.com/DannyCMMarques/Crud-Desafio-Ninja)

---

### ✅ 2. Listar funcionalidades e aplicar a priorização de testes (Pirâmide)

Abaixo estão listadas as principais funcionalidades da API com seus respectivos tipos de teste e prioridades definidas com base no impacto e criticidade:

| Categoria           | Funcionalidade                           | Tipo de Teste | Prioridade | Justificativa                                                                                             |
|---------------------|-------------------------------------------|----------------|------------|-----------------------------------------------------------------------------------------------------------|
| Personagens         | Criar personagem (POST)                   |                | Média       | Fluxo não essencial, pois o usuário ainda pode utilizar personagens previamente cadastrados.              |
| Personagens         | Listar personagens (GET)                  |                | Alta        | Essencial para exibir todos os personagens e permitir ao usuário escolher um para utilizar em batalha.    |
| Batalha             | Cadastrar batalha (POST)                  |                | Alta        | Operação chave do sistema de combate.                                                                     |
| ParticipanteBatalha | Cadastrar participante (POST)             |                | Alta        | O participante é peça central para que uma batalha aconteça.                                              |
| Usuários            | Cadastrar usuário (POST /usuarios/registro)|                | Alta        | A criação de contas é essencial para permitir novos acessos ao sistema.                                   |
| Login               | Autenticar usuário (POST /login)          |                | Alta        | A autenticação é obrigatória para o acesso ao sistema.                                                    |


---

> Próximo passo: criação dos arquivos `.feature` com os cenários de teste.

