package cadastros;

import app.Disciplina;
import app.Professor;
import app.Turma;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroTurma {

    int numTurmas;
    private List<Turma> turmas;

    public CadastroTurma() {
        numTurmas = 0;
        turmas = new ArrayList<Turma>();
    }

    public int cadastrarTurma(Turma t) {
        boolean cadastrou = turmas.add(t);
        if (cadastrou) {
            numTurmas = turmas.size();
        }
        return numTurmas;
    }

    public Turma pesquisarTurma(String codigoTurma) {
        for (Turma t: turmas) {
            if (t.getCodigo().equalsIgnoreCase(codigoTurma)) {
                return t;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma t) {
        boolean removeu = false;
        if (turmas.contains(t)) {
            removeu = turmas.remove(t);
        }
        return removeu;
    }

    public boolean atualizarTurma(String codigo, Turma t) {
        boolean resposta = false;
        Turma remover = pesquisarTurma(codigo);
        if (remover != null) {
            turmas.remove(remover);
            resposta = turmas.add(t);
        }
        return resposta;
    }

    public void imprimirListaPresenca (String codigo) {
        Turma t = pesquisarTurma(codigo);
        if (t != null) {
            JOptionPane.showMessageDialog(null, t);
        }
    }

    @Override
    public String toString() {
        StringBuilder resposta = new StringBuilder();
        for (Turma t : turmas) {
            resposta.append(t.toString()).append("\n");
        }
        return resposta.toString();
    }
    
}
