package app;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    String codigo,
            diaHora,
            semestre;
    int numVagas;
    
    Professor professor;
    Disciplina disciplina;
    private List<Aluno>  alunos;

    public Turma() {
    }
    public Turma(String codigo, String diaHora, String semestre, int numVagas, Professor professor, Disciplina disciplina, List<Aluno> alunos) {
        this.codigo = codigo;
        this.diaHora = diaHora;
        this.semestre = semestre;
        this.numVagas = numVagas;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<Aluno>();
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDiaHora() {
        return diaHora;
    }
    public String getSemestre() {
        return semestre;
    }
    public int getNumVagas() {
        return numVagas;
    }

    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}

    // lista de chamada!
    public String toString() {
        String resposta = "TURMA: " + disciplina + "-" + codigo + " - VAGAS: " + numVagas + '\n';
        resposta += "PROFESSOR: " + professor + '\n';
        resposta += "HORÁRIO: " + diaHora + " SEMESTRE: " + semestre + '\n';

        for (Aluno a : alunos) {
            int i = 1;
            resposta += i + " - " + a.getNome() + '\n';
        }
        return resposta;
    }
}
