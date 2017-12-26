package pontoeletronico.util;

public class UtilAvisos {
	
	public static final String AVISO_PRODUTO_JA_EXISTE = "Um produto com este nome já existe!";
	public static final String ERRO_NAO_TRATADO = "Erro não tratado!";
	public static final String PARAMETROS_INVALIDOS = "Não foram passados todos os parâmetros obrigatórios!";
	public static final String SUCESSO = "Operação realizada com sucesso!";
	public static final String PRIVILEGIOS_INSUFICIENTES = "Privilégios insuficientes!";
	public static final String CPF_JA_CADASTRADO = "Já existe uma pessoa cadastrada com esse CPF!";
	
	public static String eUmCampoObrigatorio (String nomeCampo) {
		return nomeCampo.toUpperCase() + " é um campo obrigatório!";
	}

}
