# language: pt
Funcionalidade: Operações com usuários do Sistema

    #  ---Post ---
  Cenário: Cadastrar usuário com dados válidos
    Dado que eu tenha nome, email e senha válidos
    Quando eu envio uma requisição POST para cadastrar o usuário
    Então o usuário é criado com sucesso

  Cenário: Cadastrar usuário com email inválido
    Dado que eu tenha um nome e senha válidos mas um email inválido
    Quando eu envio uma requisição POST para cadastrar o usuário
    Então a API deve retornar erro de validação

  Cenário: Cadastrar usuário com campos obrigatórios em branco
    Dado que eu envie nome, email e senha em branco
    Quando eu envio uma requisição POST para cadastrar o usuário
    Então a API deve retornar erro de validação

