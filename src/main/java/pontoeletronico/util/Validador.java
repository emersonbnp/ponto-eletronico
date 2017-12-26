package pontoeletronico.util;

public class Validador {
	
	public static boolean naoNullOuVazio (Object campo) {
		if (campo == null)
			return false;
		else if (campo instanceof String && ((String) campo).trim().equals(""))
			return false;
		else
			return true;
	}

}
