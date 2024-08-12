# Trabalho_OO

## Integrantes
Arthur Sismene Carvalho - 231011892

Eduardo de Almeida Morais - 231011275

Heitor Fernandes Estevam - 231011453

Lucas Tavares Drumond - 231011650

## Instituição
Universidade de Brasília - campus Gama (FGA)

## Professor
André Luiz Peron Martins Lanna

## Descrição
Este é o projeto final da disciplina "Orientação a objetos". Desenvolvido em Java, este sistema permite o cadastro e gerenciamento de alunos, professores, disciplinas e turmas. O sistema inclui funcionalidades para imprimir listas de presença, além de lançar e tratar exceções específicas, garantindo robustez e integridade dos dados.

## Diagrama de classes
![Unknown](https://github.com/user-attachments/assets/f880ff53-3bcc-4312-94cb-08354de7b7d8)


## Funcionalidades Principais
- **Cadastro de Alunos:** Permite o cadastro, pesquisa, atualização e remoção de alunos no sistema.
- **Cadastro de Professores:** Permite o cadastro, pesquisa, atualização e remoção de professores.
- **Cadastro de Disciplinas:** Gerenciamento das disciplinas oferecidas pela instituição.
- **Cadastro de Turmas:** Criação de turmas com associação de professores e disciplinas, além da matrícula de alunos.
- **Impressão de Lista de Presença:** Geração de uma lista de presença detalhada para cada turma.
- **Tratamento de Exceções Personalizadas:** Lança exceções quando campos obrigatórios não são preenchidos ou quando uma turma não tem um professor ou disciplina atribuídos.

## Cenário
Um sistema de gestão acadêmica é responsável por realizar o cadastro de todos os elementos pertencentes ao domínio de uma universidade. Por exemplo, o sistema é responsável por cadastrar todos os alunos e professores, todas as disciplinas, todas as turmas de cada disciplina e, por fim, todas as salas de aulas.

Esse sistema deve também ser capaz de criar turmas para cada disciplina e, para cada turma, deve ser capaz de associar um professor e matricular os alunos, ambos já existentes no cadastro. Para cada turma, o sistema deverá ser capaz de imprimir a lista de presença que contenha, obrigatoriamente, o nome da disciplina, o nome do professor daquela turma, o código da turma e a lista de alunos (matrícula e nome) matriculados.

O sistema deverá ainda ser capaz de impedir o cadastro de elementos do domínio que tenham valores em branco para qualquer um de seus atributos. Nesses casos deverá lançar uma exceção do tipo "CampoEmBrancoException", em que na mensagem do objeto de exceção seja informado qual o campo que ficou em branco. Com relação às turmas, essas não poderão ser cadastradas se não tiver uma disciplina e/ou um professor associado. Nesses casos deverão ser lançadas as exceções "DisciplinaNaoAtribuidaException" e "ProfessorNaoAtribuidoException", respectivamente.

## Como usar
![image](https://github.com/user-attachments/assets/e6e0cc25-a9f9-4cd0-abb1-0eb41b40e714)

