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
Digite o número correspondente a opção desejada do menu, e prosiga no "ok"

![image](https://github.com/user-attachments/assets/e6e0cc25-a9f9-4cd0-abb1-0eb41b40e714)
![image](https://github.com/user-attachments/assets/00705066-900b-4fdc-ace6-daaf05386646)

Para o cadastro de alunos será necessário nome, CPF, email, matrícula e curso.
![image](https://github.com/user-attachments/assets/3bbc5118-b4b4-494d-b076-b84e13b7db63)
![image](https://github.com/user-attachments/assets/d766367d-3d0b-47a6-a8dd-3e7f8b0dfc91)
![image](https://github.com/user-attachments/assets/64cf2245-2de5-4f77-bb2c-9be13fceafbb)
![image](https://github.com/user-attachments/assets/d0794293-2199-45c1-9320-74008f12e89c)
![image](https://github.com/user-attachments/assets/7ad15371-55d9-4370-9bfc-0565efe24df7)

Apos o Cadastro do aluno é possivel acessar suas informações utilizando a função 2 do menu
![image](https://github.com/user-attachments/assets/5a374e46-abd4-437c-8140-d953527b919d)

Informe a matrícula do aluno desejado 

![image](https://github.com/user-attachments/assets/3b6615f3-5b1b-490c-bca4-fe723bb3d961)
![image](https://github.com/user-attachments/assets/8e839d08-0f75-44a0-b15e-135b4ef3f205)






