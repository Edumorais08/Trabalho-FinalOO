package view;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import cadastros.CadastroAluno;
import cadastros.CadastroProfessor;
import exceptions.CampoEmBrancoException;

import javax.swing.*;

public class MenuProfessor {

    public static Professor dadosNovoprofessor() throws CampoEmBrancoException {
        String nome = lerNome();
        String cpf = lerCPF();
        String email = lerEmail();
        String matriculaFUB = lerMatriculaFUB();
        String areaFormacao = lerAreaFormacao();
        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB);
    }

    private static String lerNome() throws CampoEmBrancoException {
        String nome = JOptionPane.showInputDialog("Informe o nome do professor: ");
        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar o nome!");
        }
        return nome;
    }

    private static String lerAreaFormacao() throws CampoEmBrancoException {
        String areaFormacao = JOptionPane.showInputDialog("Informe a área de formação do professor: ");
        if (areaFormacao == null || areaFormacao.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar a área de formação!");
        }
        return areaFormacao;
    }

    private static String lerEmail() throws CampoEmBrancoException {
        String email = JOptionPane.showInputDialog("Informe o Email do professor: ");
        if (email == null || email.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar o Email!");
        }
        return email;
    }

    private static String lerCPF() throws CampoEmBrancoException {
        String cpf = JOptionPane.showInputDialog("Informe o CPF do professor: ");
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar o CPF!");
        }
        return cpf;
    }


    private static String lerMatriculaFUB() throws CampoEmBrancoException {
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrículaFUB do professor: ");
        if (matriculaFUB == null || matriculaFUB.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar a matrículaFUB!");
        }
        return matriculaFUB;
    }

    public static void menuProfessor(CadastroProfessor cadProfessor) throws CampoEmBrancoException {
        String txt = """
                Informe a opção desejada:
                1 - Cadastrar professor
                2 - Pesquisar professor
                3 - Atualizar professor
                4 - Remover professor
                0 - Voltar para menu anterior
                """;

        int opcao = -1;
        do {
            try {
                String strOpcao = JOptionPane.showInputDialog(txt);
                opcao = Integer.parseInt(strOpcao);

                switch (opcao) {
                    case 0:
                        return;
                    case 1:
                        Professor novoProfessor = dadosNovoprofessor();
                        cadProfessor.cadastrarProfessor(novoProfessor);
                        break;

                    case 2:
                        String matriculaFUB = lerMatriculaFUB();
                        Professor p = cadProfessor.pesquisarProfessor(matriculaFUB);
                        if (p != null) {
                            JOptionPane.showMessageDialog(null, p.toString());
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "essa matrículaFUB não existe ou está errada!");
                            break;
                        }

                    case 3:
                        matriculaFUB = lerMatriculaFUB();
                        Professor prof = cadProfessor.pesquisarProfessor(matriculaFUB);
                        if (prof == null) {
                            JOptionPane.showMessageDialog(null, "Essa matrículaFUB não existe ou está errada!");
                            break;
                        }
                        Professor novoCadastro = dadosNovoprofessor();
                        boolean atualizado = cadProfessor.atualizarProfessor(matriculaFUB, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        }
                        break;

                    case 4:
                        matriculaFUB = lerMatriculaFUB();
                        Professor remover = cadProfessor.pesquisarProfessor(matriculaFUB);
                        boolean removido = cadProfessor.removerProfessor(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Professor removido do cadastro!");
                            System.gc();
                            break;
                        }

                    default:
                        JOptionPane.showMessageDialog(null, "A opção escolhida não é válida!");
                        break;
                }
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " tente novamente!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "A opção escolhida não é válida!");
                opcao = -1;
            }
        } while (opcao != 0) ;
        return;
    }
}
