# language: pt
Funcionalidade: Operações com participantes em batalhas


#  --POST--
  Cenário: Cadastrar participante com dados válidos
    Dado que eu tenha os dados corretos de um participante em uma batalha existente
    Quando eu envio uma requisição POST para cadastrar o participante
    Então o participante é registrado com sucesso

  Cenário: Cadastrar participante com batalha inexistente
    Dado que eu informe um ID de batalha que não existe
    Quando eu envio uma requisição POST para cadastrar o participante
    Então a API deve retornar erro de não encontrado

  Cenário: Cadastrar participante com dados ausentes
    Dado que eu envie uma requisição com campos obrigatórios em branco ou nulos
    Quando eu envio uma requisição POST para cadastrar o participante
    Então a API deve retornar erro de validação
