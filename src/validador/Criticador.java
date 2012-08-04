package validador;

import java.util.ArrayList;

public abstract class Criticador extends Validador{

	public static ArrayList<String> listaCritica = new ArrayList<String>();

	protected void criticar(boolean ehValidaAhCritica, String mensagem) {
		if (ehValidaAhCritica) {
			Criticador.listaCritica.add(mensagem);
		}
	}
}
