package view;

import app.*;
import cadastros.*;
import exceptions.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MenuTurma {

    private static CadastroProfessor cadastroProfessor;
    private static CadastroAluno cadastroAluno;
    private static CadastroDisciplina cadastroDisciplina;


    public static void setCadastros(CadastroProfessor cadProf, CadastroAluno cadAluno, CadastroDisciplina cadDisciplina) {
        cadastroProfessor = cadProf;
        cadastroAluno = cadAluno;
        cadastroDisciplina = cadDisciplina;
    }


    public static Turma dadosNovaTurma() throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        String diaHora = lerNome();
        String codigo = lerCodigo();
        String semestre = lerSemestre();
        int numVagas = lerNumVagas();
        Professor professor = lerProfessor();
        Disciplina disciplina = lerDisciplina();
        List<Aluno> alunos = lerAluno(numVagas);
        return new Turma(codigo, diaHora, semestre, numVagas, professor, disciplina, alunos);
    }

    private static String lerCodigo() throws CampoEmBrancoException {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        if (codigo.isEmpty()) {
            throw new CampoEmBrancoException("ERRO AO LER O CODIGO");
        }
        return codigo;
    }

    private static int lerNumVagas() throws CampoEmBrancoException {
        String numVagas = JOptionPane.showInputDialog("Informe o número de vagas da turma: ");
        if (numVagas.isEmpty()) {
            throw new CampoEmBrancoException("ERRO AO LER O NUMERO DE VAGAS. ");
        }
        return Integer.parseInt(numVagas);
    }

    private static String lerSemestre() throws CampoEmBrancoException{
        String semestre = JOptionPane.showInputDialog("Informe o semestre da turma: ");
        if (semestre.isEmpty()) {
            throw new CampoEmBrancoException("ERRO AO LER O SEMESTRE. ");
        }
        return semestre;
    }

    private static String lerNome() throws CampoEmBrancoException {
        String nome = JOptionPane.showInputDialog("Informe o dia/Hora da turma: ");
        if (nome.isEmpty()) {
            throw new CampoEmBrancoException("ERRO AO LER O NOME. ");
        }
        return nome;
    }

    //exception professornaoatribuido
    private static Professor lerProfessor() throws ProfessorNaoAtribuidoException {
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrículaFUB do professor da turma: ");
        Professor p = cadastroProfessor.pesquisarProfessor(matriculaFUB);
        if (p == null) {
            throw new ProfessorNaoAtribuidoException("PROFESSOR NAO CADASTRADO. ");
        }
        return p;
    }

    //exception disciplinaonao atrib
    private static Disciplina lerDisciplina() throws DisciplinaNaoAtribuidaException {
        String codigo = JOptionPane.showInputDialog("Informe o código da disciplina da turma: ");
        Disciplina d = cadastroDisciplina.pesquisarDisciplina(codigo);
        if (d == null) {
            throw new DisciplinaNaoAtribuidaException("DISCIPLINA NAO EXISTENTE. ");
        }
        return d;
    }


    private static List<Aluno> lerAluno(int numVagas) {
        List<Aluno> alunos = new ArrayList<>();
        //int vagasRestantes = numVagas;
        for (int i = 0;i < numVagas; i++) {
            String matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno para adicionar na turma: ");

            if (matricula.isEmpty()) {
                break;
            }
            Aluno aluno = cadastroAluno.pesquisarAluno(matricula);
            if (aluno == null) {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                i--;
            } else if (alunos.contains(aluno)) {
                JOptionPane.showMessageDialog(null, "Aluno já cadastrado. ");
                i--;
            } else {
                alunos.add(aluno);
                //vagasRestantes--;
            }
        }
        return alunos;
    }



    public static void menuDisciplina(CadastroTurma cadTurma) throws CampoEmBrancoException, ProfessorNaoAtribuidoException, DisciplinaNaoAtribuidaException {
        String txt = """
                Informe a opção desejada:
                1 - Cadastrar Turma
                2 - Pesquisar Turma
                3 - Atualizar Turma
                4 - Remover Turma
                5 - Imprimir lista de presença
                0 - Voltar para menu anterior
                """;

        int opcao = -1;
        do {
            try {
                String strOpcao = JOptionPane.showInputDialog(txt);
                opcao = Integer.parseInt(strOpcao);

                switch (opcao) {
                    case 1:
                        Turma novaTurma = dadosNovaTurma();
                        cadTurma.cadastrarTurma(novaTurma);
                        break;

                    case 2:
                        String codigo = lerCodigo();
                        Turma t = cadTurma.pesquisarTurma(codigo);
                        if (t != null)
                            JOptionPane.showMessageDialog(null, t.toString());
                        break;

                    case 3:
                        codigo = lerCodigo();
                        Turma novoCadastro = dadosNovaTurma();
                        boolean atualizado = cadTurma.atualizarTurma(codigo, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        }
                        break;

                    case 4:
                        codigo = lerCodigo();
                        Turma remover = cadTurma.pesquisarTurma(codigo);
                        boolean removido = cadTurma.removerTurma(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                            System.gc();
                        }
                    case 5:
                        codigo = lerCodigo();
                        cadTurma.imprimirListaPresenca(codigo);
                    default:
                        break;
                }
            } catch (ProfessorNaoAtribuidoException e) {
                JOptionPane.showMessageDialog(null, "Nenhum Professor associado a essa turma! ");
                //} catch (DisciplinaNaoAtribuidaException) {
                //    JOptionPane.showMessageDialog(null, "Nenhuma Disciplina associada a essa turma! ");
            }  catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null,
                        "Opção em branco:\nCampo " + e.getMessage() + " esta em branco, tente novamente novamente");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção invalida");
                opcao = -1;
            }
        } while (opcao != 0);
        return;
    }
}