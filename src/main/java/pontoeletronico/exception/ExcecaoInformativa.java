package pontoeletronico.exception;

public abstract class ExcecaoInformativa extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5886536860097899938L;
	private Integer codigo;
	private String mensagem;

	public ExcecaoInformativa(Integer codigo, String mensagem) {
		super();
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
