package validador;

public class ValidadorNot extends Validador {

	Validador validador;
	
	public ValidadorNot(Validador validador) {
		this.validador = validador;
	}

	@Override
	public boolean ehValido() {
		return !validador.ehValido();
	}

}
