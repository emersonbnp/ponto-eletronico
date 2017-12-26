package pontoeletronico.exception;

public class PrivilegiosInsuficientesException extends ExcecaoInformativa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8898215660724347883L;

	public PrivilegiosInsuficientesException(Integer codigo, String mensagem) {
		super(codigo, mensagem);
	}

}
