package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Professor;

public class CadastroProfessor {
	int numProfessor; 
	private List<Professor> professores;
	
	public CadastroProfessor() {
		numProfessor = 0;
		professores = new ArrayList<Professor>();
	}
	
	public int cadastrarProfessor(Professor p) {
		boolean cadastrou = professores.add(p);
		if (cadastrou) {
			numProfessor = professores.size();
		}
		return numProfessor;
	}
	
	public Professor pesquisarProfessor(String matriculaFUBProfessor) {
		for (Professor p: professores) {
			if (p.getMatriculaFUB().equalsIgnoreCase(matriculaFUBProfessor)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean removerProfessor(Professor p) {
		boolean removeu = false; 
		if (professores.contains(p)) {
			removeu = professores.remove(p);
		}
		return removeu;
	}
	
	public boolean atualizarProfessor(String matriculaFUB, Professor p) {
		boolean resposta = false;
		Professor remover = pesquisarProfessor(matriculaFUB);
		if (remover != null) {
			professores.remove(remover);
			resposta = professores.add(p);
		}
		return resposta;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Professor p : professores) {
			sb.append(p.toString() + "\n");
		}
		return sb.toString();
	}
}











