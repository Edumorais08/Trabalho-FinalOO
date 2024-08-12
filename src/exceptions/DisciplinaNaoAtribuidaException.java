package exceptions;

public class DisciplinaNaoAtribuidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public DisciplinaNaoAtribuidaException(String msg) {
		super(msg);
	}
}