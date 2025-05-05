# RestAssured


# Quais são os principais tipos de teste de software?
A depender do contexto e da preferência do profissional ou da empresa, há diversos tipos de testes de software para serem executados:

- Teste da caixa branca – avalia a estrutura interna do código-fonte, por meio de testes dos caminhos de execução específicos, que garantem que todas as instruções sejam executadas corretamente. 
-  Teste da caixa preta – examina o software apenas com base em sua interface externa, sem considerar a sua estrutura interna. Os testes são fundamentados nos requisitos e nas funcionalidades esperadas pelo usuário.
-  Teste da caixa cinza – combina elementos do teste da caixa branca e da caixa preta, em que parte do conhecimento interno do sistema é utilizado, mas também se concentra na funcionalidade externa.
-  Teste de regressão – verifica se as alterações recentes no código afetaram negativamente o funcionamento das funcionalidades existentes. Geralmente, é automatizado para garantir que as correções ou novos recursos não insiram bugs no software existente.
-  Teste de unidade – estuda unidades individuais de código isoladamente para garantir que cada parte do software funcione conforme o esperado.
- Teste de integração – avalia a interação entre diferentes partes do sistema para garantir que elas funcionem em conjunto, de maneira integrada e sem problemas.
- Teste de carga – verifica o desempenho do software sob condições de carga máxima (ou o mais próximo disso), observando como ele se comporta quando submetido a um grande volume de dados ou usuários simultâneos.
- Teste de usabilidade – avalia a facilidade de uso e a experiência do usuário do software, garantindo que seja intuitiva e eficiente para os usuários finais.
- Teste de estresse –tests the limits of software by subjecting it to extreme conditions or conditions beyond normal specifications to assess its stability and resilience. testa os limites do software, submetendo-o a condições extremas ou além das especificações normais, para avaliar sua estabilidade e capacidade de recuperação.
# Testes de software: tipos, níveis e técnicas

![alt text](image.png)


 Para cada momento do ciclo de vida de um determinado produto de software, deve-se utilizar diferentes abordagens, o que inclui técnicas, ferramentas e pessoas

## Pirâmida de Testes 
A pirâmide de testes é uma ilustração que permite visualizar de forma simples os tipos de testes, seus níveis, velocidades, complexidades e “custos”.
![alt text](image-2.png)

![alt text](image-3.png)


# Testes de API 
  
  ### Tipos de Testes 
  - Funcional
  - Aceitação
  - Sanidade
  - Contrato
  - Saúde dos endpoints

  -  escolha dos testes automatizados candidatos, ou seja, os mais críticos, deve ser realizada com base no contexto do projeto de automação. No entanto, apesar de não existir uma categorização amplamente difundida, a experiência tem mostrado que os testes candidatos são normalmente agrupados em quatro áreas distintas:

Smoke Tests: Um conjunto mínimo de testes é selecionado com o objetivo de validar um Build ou liberação antes do início de um ciclo de testes;
Testes de Regressão: Os testes são selecionados com o objetivo de executar o re-teste de uma funcionalidade ou da aplicação inteira;
Funcionalidades Críticas: Os testes são selecionados com o objetivo de validar as funcionalidades críticas que podem trazer riscos ao negócio;
Tarefas Repetitivas: Os testes são selecionados com o objetivo de reduzir o envolvimento dos testadores em atividades manuais repetitivas e suscetíveis a erros, tais como cálculos matemáticos, simulações, processamentos, comparações de arquivos ou dados, etc.



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
