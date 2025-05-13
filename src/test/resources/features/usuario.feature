# language: pt
@usuario
Funcionalidade: Operações com usuários do Sistema

  @post
  Cenário: Cadastrar usuário com dados válidos
    Dado que eu tenha nome, email e senha válidos
    Quando eu envio uma requisição POST para cadastrar o usuário
    Então o usuário é criado com sucesso

  @get
  Cenário: Buscar usuário por ID com sucesso
    Dado que exista um usuário previamente registrado
    Quando eu envio uma requisição GET para buscar o usuário por ID
    Então os dados do usuário são retornados com sucesso

  @delete
  Cenário: Deletar um usuário por ID com sucesso
    Dado que exista um usuário previamente registrado
    Quando eu envio uma requisição DELETE para excluir o usuário
    Então o usuário é excluído com sucesso

  @get
  Cenário: Tentar buscar usuário com ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum usuário
    Quando eu envio uma requisição GET para buscar o usuário por ID
    Então a API deve retornar erro de não encontrado para o usuário

  @delete
  Cenário: Tentar deletar usuário com ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum usuário
    Quando eu envio uma requisição DELETE para excluir o usuário inexistente
    Então a API deve retornar erro de não encontrado para o usuário

  @list
  Cenário: Tentar listar usuários com parâmetros inválidos
    Quando eu envio uma requisição GET para listar os usuários com parâmetros inválidos
    Então a API usuário deve retornar erro de requisição inválida
