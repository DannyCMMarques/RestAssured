# language: pt
Funcionalidade: Operações com personagens do sistema

  # -- POST --

  Cenário: Criar personagem com dados válidos
    Dado que eu possua um nome, idade, aldeia e especialidade para o personagem
    Quando eu envio uma requisição POST para criar o personagem
    Então o personagem é criado com sucesso

  Cenário: Tentar criar personagem com dados inválidos
    Dado que eu envie dados ausentes, malformados ou não permitidos para o personagem
    Quando eu envio uma requisição POST para criar o personagem
    Então a API deve retornar erro de validação

#    --GET--
  Cenário: Buscar personagem por ID existente
    Dado que exista um personagem salvo com ID 1
    Quando eu envio uma requisição GET com esse ID
    Então o personagem correspondente é retornado

  Cenário: Buscar personagem com ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum personagem
    Quando eu envio uma requisição GET com esse ID
    Então a API deve retornar erro de não encontrado

