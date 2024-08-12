package exceptions;


public class CampoEmBrancoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public CampoEmBrancoException(String msg) {
		super(msg);
	}
}