package view;

import app.Disciplina;
import app.Professor;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import exceptions.*;

import javax.swing.*;

public class MenuDisciplina {

    public static Disciplina dadosNovaDisciplina() throws CampoEmBrancoException {
        String nome = lerNome();
        String codigo = lerCodigo();
        int creditos = lerCreditos();
        int cargaHoraria = lerCargaHoraria();
        return new Disciplina(codigo, nome, cargaHoraria, creditos);
    }

    private static String lerNome() throws CampoEmBrancoException {
        String nome = JOptionPane.showInputDialog("Informe o nome da disciplina: ");
        if (nome == null || nome.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar o nome! ");
        }
        return nome;
    }

    private static int lerCargaHoraria() throws CampoEmBrancoException {
        String cargaHoraria = JOptionPane.showInputDialog("Informe a carga horária da discplina: ");
        if (cargaHoraria == null || cargaHoraria.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar a carga horária! ");
        }
        return Integer.parseInt(cargaHoraria);
    }

    private static int lerCreditos() throws CampoEmBrancoException {
        String creditos = JOptionPane.showInputDialog("Informe a quantidade de créditos da disciplina: ");
        if (creditos == null || creditos.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar os créditos! ");
        }
        return Integer.parseInt(creditos);
    }

    private static String lerCodigo() throws CampoEmBrancoException {
        String codigo = JOptionPane.showInputDialog("Informe o codigo da disciplina: ");
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new CampoEmBrancoException("Você esqueceu de colocar o codigo! ");
        }
        return codigo;
    }

    public static void menuDisciplina(CadastroDisciplina cadDisciplina) throws CampoEmBrancoException {
        String txt = """
                Informe a opção desejada:
                1 - Cadastrar Disciplina
                2 - Pesquisar Disciplina
                3 - Atualizar Disciplina
                4 - Remover Disciplina
                0 - Voltar para menu anterior
                """;

        int opcao = -1;
        do {
            try {
                String strOpcao = JOptionPane.showInputDialog(txt);
                opcao = Integer.parseInt(strOpcao);

                switch (opcao) {
                    case 1:
                        Disciplina novaDisciplina = dadosNovaDisciplina();
                        cadDisciplina.cadastrarDisciplina(novaDisciplina);
                        break;

                    case 2:
                        String codigo = lerCodigo();
                        Disciplina a = cadDisciplina.pesquisarDisciplina(codigo);
                        if (a != null)
                            JOptionPane.showMessageDialog(null, a.toString());
                        break;

                    case 3:
                        codigo = lerCodigo();
                        Disciplina novoCadastro = dadosNovaDisciplina();
                        boolean atualizado = cadDisciplina.atualizarDisciplina(codigo, novoCadastro);
                        if (atualizado) {
                            JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                        }
                        break;

                    case 4:
                        codigo = lerCodigo();
                        Disciplina remover = cadDisciplina.pesquisarDisciplina(codigo);
                        boolean removido = cadDisciplina.removerDisciplina(remover);
                        if (removido) {
                            JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
                            System.gc();
                        }

                    default:
                        break;
                }
            } catch (CampoEmBrancoException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() + " tente novamente!");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "A opção escolhida não é válida!");
                opcao = -1;
            }
        } while (opcao != 0);
        return;
    }
}
