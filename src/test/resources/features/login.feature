# language: pt
@login
Funcionalidade: Autenticação de usuários

  Cenário: Login com credenciais válidas
    Dado que eu possua um e-mail e senha válidos
    Quando eu envio uma requisição POST para o login
    Então a autenticação é realizada com sucesso

  Cenário: Login com senha incorreta
    Dado que eu possua um e-mail válido e uma senha incorreta
    Quando eu envio uma requisição POST para o login
    Então a API deve retornar erro de autenticação
