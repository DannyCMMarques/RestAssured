# language: pt
Funcionalidade: Operações com batalhas
    # ---POST ---

  Cenário: Cadastrar uma nova batalha com sucesso
    Dado que o sistema é responsável por preencher os dados da batalha
    Quando eu envio uma requisição POST vazia para o cadastro de batalha
    Então a batalha é registrada automaticamente com sucessoso

  Cenário: Tentar cadastrar uma batalha com dados inválidos
    Dado que eu envie dados não permitidos ou malformados no corpo da requisição
    Quando eu envio uma requisição POST para cadastrar a batalha
    Então a API deve retornar erro de validação
