package pontoeletronico.exception;

public class ErroInternoException extends ExcecaoInformativa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 694812274094957396L;

	public ErroInternoException(Integer codigo, String mensagem) {
		super(codigo, mensagem);
	}

}
