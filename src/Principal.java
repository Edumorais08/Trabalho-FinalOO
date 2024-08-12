import javax.swing.JOptionPane;

import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;

import org.w3c.dom.ls.LSOutput;
import view.MenuAluno;
import view.MenuDisciplina;
import view.MenuPrincipal;
import view.MenuProfessor;

public class Principal {

	static CadastroAluno cadAluno;
	static CadastroProfessor cadProfessor;
	static CadastroDisciplina cadDisciplina;
	static CadastroTurma cadTurma;
	
	public static void main(String[] args) throws CampoEmBrancoException {
		cadAluno = new CadastroAluno();
		cadProfessor = new CadastroProfessor();
		cadDisciplina = new CadastroDisciplina();
		
		int opcao = 0; 
		
		do {
			try {
			opcao = MenuPrincipal.menuOpcoes();

			switch (opcao) {
				case 1:
					MenuAluno.menuAluno(cadAluno);
					break;
				case 2:
					MenuProfessor.menuProfessor(cadProfessor);
					break;
				case 3:
					MenuDisciplina.menuDisciplina(cadDisciplina);
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Cadastro de turmas a ser implementado");
					break;
				case 0:
					break;
				default:
					JOptionPane.showMessageDialog(null, "A Opção escolhida não é válida");
					opcao = -1;
					break;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "A Opção escolhida não é válida");
				opcao = 0;
			}
		} while (opcao != 0);
		return;
	}




}