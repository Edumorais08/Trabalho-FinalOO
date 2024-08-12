package view;

import javax.swing.JOptionPane;

import app.Aluno;
import cadastros.CadastroAluno;
import exceptions.CampoEmBrancoException;

public class MenuAluno {

	public static Aluno dadosNovoAluno() throws CampoEmBrancoException {
		String nome = lerNome();
		String cpf = lerCPF();
		String email = lerEmail();
		String matricula = lerMatricula();
		String curso = lerCurso();
		return new Aluno(nome, cpf, email, matricula, curso);
	}

	private static String lerNome() throws CampoEmBrancoException {
		String nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
		if (nome == null || nome.trim().isEmpty()) {
			throw new CampoEmBrancoException("Você esqueceu de colocar o nome!");
		}
		return nome;
	}

	private static String lerCurso() throws CampoEmBrancoException {
		String curso = JOptionPane.showInputDialog("Informe o curso do aluno: ");
		if (curso == null || curso.trim().isEmpty()) {
			throw new CampoEmBrancoException("Você esqueceu de colocar o curso!");
		}
		return curso;
	}

	private static String lerEmail() throws CampoEmBrancoException {
		String email = JOptionPane.showInputDialog("Informe o Email do aluno: ");
		if (email == null || email.trim().isEmpty()) {
			throw new CampoEmBrancoException("Você esqueceu de colocar o Email!");
		}
		return email;
	}

	private static String lerCPF() throws CampoEmBrancoException {
		String cpf = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
		if (cpf == null || cpf.trim().isEmpty()) {
			throw new CampoEmBrancoException("Você esqueceu de colocar o CPF!");
		}
		return cpf;
	}

	private static String lerMatricula() throws CampoEmBrancoException {
		String matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno: ");
		if (matricula == null || matricula.trim().isEmpty()) {
			throw new CampoEmBrancoException("Você esqueceu de colocar a matrícula!");
		}
		return matricula;
	}

	public static void menuAluno(CadastroAluno cadAluno) throws CampoEmBrancoException {
		String txt = "Informe a opção que você quer escolher: \n"
				+ "1 - Cadastrar aluno\n"
				+ "2 - Pesquisar aluno\n"
				+ "3 - Atualizar aluno\n"
				+ "4 - Remover aluno\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			try {

				String strOpcao = JOptionPane.showInputDialog(txt);
				opcao = Integer.parseInt(strOpcao);

				switch (opcao) {
					case 0:
						return;

					case 1:
						Aluno novoAluno = dadosNovoAluno();
						cadAluno.cadastrarAluno(novoAluno);
						break;

					case 2:
						String matricula = lerMatricula();
						Aluno a = cadAluno.pesquisarAluno(matricula);
						if (a != null) {
							JOptionPane.showMessageDialog(null, a.toString());
						} else {
							JOptionPane.showMessageDialog(null, "essa matrícula não existe ou está errada!");
						}
						break;

					case 3:
						matricula = lerMatricula();
						Aluno novoCadastro = dadosNovoAluno();
						boolean atualizado = cadAluno.atualizarAluno(matricula, novoCadastro);
						if (atualizado) {
							JOptionPane.showMessageDialog(null, "O Cadastro do aluno foi atualizado.");
						}
						break;

					case 4:
						matricula = lerMatricula();
						Aluno remover = cadAluno.pesquisarAluno(matricula);
						boolean removido = cadAluno.removerAluno(remover);
						if (removido) {
							JOptionPane.showMessageDialog(null, "o Aluno foi removido com sucesso!");
							System.gc();
						}

					default:
						JOptionPane.showMessageDialog(null, "A opção escolhida não é válida!");
						break;
				}
			} catch (CampoEmBrancoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage() + " tente novamente!" );
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "A opção escolhida não é válida!");
			}
		} while (opcao != 0);
		return;
	}


}