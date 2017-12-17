package pontoeletronico.entity.enums;

public enum SimNaoEnum {
	
	SIM(true),
	NAO(false);
	
	private boolean simNao;
	
	private SimNaoEnum (boolean bool) {
		this.simNao = bool;
	}
	
	public boolean isSim () {
		return this.simNao == true;
	}

	public boolean isNao () {
		return this.simNao == false;
	}

}
