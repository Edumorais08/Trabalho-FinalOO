package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Disciplina;

public class CadastroDisciplina {
	int numDisciplina; 
	private List<Disciplina> disciplinas;
	
	public CadastroDisciplina() {
		numDisciplina = 0;
		disciplinas = new ArrayList<Disciplina>();
	}
	
	public int cadastrarDisciplina(Disciplina d) {
		boolean cadastrou = disciplinas.add(d);
		if (cadastrou) {
			numDisciplina = disciplinas.size();
		}
		return numDisciplina;
	}
	
	public Disciplina pesquisarDisciplina(String codigoDisciplina) {
		for (Disciplina d: disciplinas) {
			if (d.getCodigo().equalsIgnoreCase(codigoDisciplina)) {
				return d;
			}
		}
		return null;
	}
	
	public boolean removerDisciplina(Disciplina d) {
		boolean removeu = false; 
		if (disciplinas.contains(d)) {
			removeu = disciplinas.remove(d);
		}
		return removeu;
	}
	
	public boolean atualizarDisciplina(String codigo, Disciplina d) {
		boolean resposta = false;
		Disciplina remover = pesquisarDisciplina(codigo);
		if (remover != null) {
			disciplinas.remove(remover);
			resposta = disciplinas.add(d);
		}
		return resposta;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Disciplina d : disciplinas) {
			sb.append(d.toString() + "\n");
		}
		return sb.toString();
	}
}




