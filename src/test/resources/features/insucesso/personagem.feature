# language: pt
@personagem @insucesso
Funcionalidade: Operações com personagens do sistema
  # -- POST --

  @post
  Cenário: Tentar criar personagem com dados inválidos
    Dado que eu envie dados ausentes, malformados ou não permitidos para o personagem
    Quando eu envio uma requisição POST para criar o personagem
    Então a API deve retornar erro de validação
#    --GET--

  @get
  Cenário: Buscar personagem com ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum personagem
    Quando eu envio uma requisição GET com esse ID
    Então a API deve retornar erro de não encontrado
# --PUT--

  @put
  Cenário: Tentar atualizar um personagem com ID inexistente
    Dado que eu tenha dados válidos para atualizar um personagem inexistente
    Quando eu tento atualizar um personagem com ID inexistente
    Então a API deve retornar erro de não encontrado ao atualizar
   # --DELETE --

  @delete
  Cenário: Tentar deletar um personagem com ID inexistente
    Dado que o ID 9999 não esteja associado a nenhum personagem
    Quando eu tento excluir um personagem com ID inexistente
    Então a API deve retornar erro de não encontrado ao excluir
# -- GET/ LISTAR TODOS --
# @get
#   Cenário: Listar personagens quando não há registros
#     Dado que não exista nenhum personagem salvo no sistema
#     Quando eu envio uma requisição GET para listar os personagens
#     Então a API deve retornar uma resposta vazia
