package pontoeletronico.exception;

public class CampoObrigatorioException extends ExcecaoInformativa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 694812274094957396L;

	public CampoObrigatorioException(Integer codigo, String mensagem) {
		super(codigo, mensagem);
	}

}
