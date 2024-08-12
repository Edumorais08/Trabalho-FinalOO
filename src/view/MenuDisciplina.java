package view;

import app.Disciplina;
import app.Professor;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;

import javax.swing.*;

public class MenuDisciplina {

    public static Disciplina dadosNovaDisciplina() {
        String nome = lerNome();
        String codigo = lerCodigo();
        int creditos = lerCreditos();
        int cargaHoraria = lerCargaHoraria();
        return new Disciplina(codigo, nome, cargaHoraria, creditos);
    }

    private static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
    }

    private static int lerCargaHoraria() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a carga horária da discplina: "));
    }

    private static int lerCreditos() {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de créditos da disciplina: "));
    }

    private static String lerCodigo() {
        return JOptionPane.showInputDialog("Informe o código da disciplina: ");
    }

    public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
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
        } while (opcao != 0);
        return;
    }
}
