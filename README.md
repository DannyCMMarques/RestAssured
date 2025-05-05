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














![alt text](image.png)


 Para cada momento do ciclo de vida de um determinado produto de software, deve-se utilizar diferentes abordagens, o que inclui técnicas, ferramentas e pessoas

## Pirâmida de Testes 
A pirâmide de testes é uma ilustração que permite visualizar de forma simples os tipos de testes, seus níveis, velocidades, complexidades e “custos”.
![alt text](image-2.png)

![alt text](image-3.png)



#BDD

![image](https://github.com/user-attachments/assets/c45a75a5-bc70-41fc-802d-91b3d611d8fa)
Behavior Driven Development (Desenvolvimento Orientado a Comportamento)
É uma abordagem de desenvolvimento e testes que:
![image](https://github.com/user-attachments/assets/aee8a05c-9002-4e77-af43-c56d7f13a2ec)

✅ Foca no comportamento esperado do sistema, do ponto de vista do usuário (não da implementação técnica)
✅ Usa uma linguagem comum entre desenvolvedores, testers e área de negócio
✅ Permite que os testes sejam escritos como exemplos de uso real
✅ Promove colaboração e clareza nos requisitos


Vantagens:

-Testes de aceitação
-especificação executáveis 

## CUCUMBER
![image](https://github.com/user-attachments/assets/e8f2b157-0a28-4304-b986-42180a34a088)
![image](https://github.com/user-attachments/assets/a1162d82-0abc-40d2-91da-f468e59d85e2)


##Cenários 

- O cenário é um exemplo concreto de uma regra de negócios
- Um cenário usa exemplos concretos para explicar ideias abstratas

  ### Formatos:

    -Dado(pre-condição)
    -Quando(ação)
  -Então(resultado esperado)

### 
![image](https://github.com/user-attachments/assets/d3cf498c-f096-4fc2-8a0a-ceb7e73162c8)

### Gherkin 
  ![image](https://github.com/user-attachments/assets/1c305914-28ba-4ef8-b4be-ea1f76dea190)
![image](https://github.com/user-attachments/assets/783a4459-dff0-4a79-8472-14d55bcb58a7)
![image](https://github.com/user-attachments/assets/bb0e5842-7a03-46af-ada7-71406bd0d7f7)
![image](https://github.com/user-attachments/assets/e8eb0498-c214-4012-ab67-bfbebc144010)
![image](https://github.com/user-attachments/assets/f2564ed5-5481-4fd3-b251-37afdd43b118)
![image](https://github.com/user-attachments/assets/4eaf9482-c215-45c9-8dd8-a1a122c8785a)
![image](https://github.com/user-attachments/assets/29c450ce-ea73-47e6-8a63-71830c9a18ac)
![image](https://github.com/user-attachments/assets/40a29cb9-67d1-44eb-bb77-59b4f9159547)
![image](https://github.com/user-attachments/assets/de051a78-553f-4f6f-88e1-95bbdc3421ba)
![image](https://github.com/user-attachments/assets/fd74841d-3712-4483-add3-cd392e10caa6)
![image](https://github.com/user-attachments/assets/cca051df-0e5c-442b-9167-1116262a4285)


-Linguagem Natural com algumas funcionalidades 
-Pessoas técnicas e não técnicas podem entender ou descrever cenários 
-Permite que os testes sejam executados, se tornando assim uma documentação viva
  #### Palavras chaves
   -![image](https://github.com/user-attachments/assets/a2dc2e47-35b4-4089-b240-824ce98e0b93)
-Funcionalidades: 
Referências:
https://medium.com/opanehtech/gherkin-e-cucumber-mapeando-os-testes-automatizados-53232bf26e79
https://cucumber.io/docs/cucumber/api/?lang=java#tags
https://blog.onedaytesting.com.br/piramide-de-teses/
