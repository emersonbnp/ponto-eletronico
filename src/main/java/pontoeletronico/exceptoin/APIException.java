package pontoeletronico.exceptoin;

public class APIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8773076273893731799L;
	private Integer codigo;
	private String mensagem;

	public APIException(Integer codigo, String mensagem) {
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
