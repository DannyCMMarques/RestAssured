# language: pt
@personagem @sucesso
Funcionalidade: Operações com personagens do sistema

  @post
  Cenário: Criar personagem com dados válidos
    Dado que eu possua um nome, idade, aldeia e especialidade para o personagem
    Quando eu envio uma requisição POST para criar o personagem
    Então o personagem é criado com sucesso

  @get
  Cenário: Buscar personagem por ID existente
    Dado que exista um personagem salvo com ID 1
    Quando eu envio uma requisição GET com esse ID
    Então o personagem correspondente é retornado

  @put
  Cenário: Atualizar um personagem existente com dados válidos
    Dado que exista um personagem salvo que eu queira atualizar personagem
    Quando eu envio uma requisição PUT com o ID e os dados atualizados
    Então o personagem é atualizado com sucesso

  @delete
  Cenário: Deletar um personagem existente
    Dado que exista um personagem salvo para exclusão
    Quando eu envio uma requisição DELETE com esse ID
    Então o personagem é removido com sucesso

  @get
  Cenário: Listar todos os personagens cadastrados
    Dado que existam personagens salvos no sistema
    Quando eu envio uma requisição GET para listar os personagens
    Então a API deve retornar a lista de personagens com sucesso
