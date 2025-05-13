# language: pt
@participante-batalha
Funcionalidade: Operações com participantes em batalhas

  Cenário: Cadastrar participante com dados válidos
    Dado que eu tenha os dados corretos de um participante em uma batalha existente
    Quando eu envio uma requisição POST para cadastrar o participante
    Então o participante da batalha é registrado com sucesso

  Cenário: Cadastrar participante com batalha inexistente
    Dado que eu informe um ID de batalha que não existe
    Quando eu envio uma requisição POST para cadastrar o participante
    Então a API deve retornar erro de batalha informada não encontrado

  Cenário: Cadastrar participante com dados ausentes
    Dado que eu envie uma requisição com campos obrigatórios em branco ou nulos
    Quando eu envio uma requisição POST para cadastrar o participante
    Então a API deve retornar erro de validação dos participantes da batalha


  @get-participante
  Cenário: Buscar participante por ID existente
    Dado que exista um participante previamente cadastrado
    Quando eu envio uma requisição GET para buscar o participante por ID
    Então os dados do participante são retornados com sucesso

  Cenário: Buscar participante por ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum participante
    Quando eu envio uma requisição GET para buscar o participante por ID
    Então a API deve retornar erro de participante não encontrado


  @delete-participante
  Cenário: Excluir participante por ID existente
    Dado que exista um participante previamente cadastrado
    Quando eu envio uma requisição DELETE para excluir o participante
    Então o participante é excluído com sucesso

  Cenário: Excluir participante por ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum participante
    Quando eu envio uma requisição DELETE para excluir o participante
    Então a API deve retornar erro de participante não encontrado