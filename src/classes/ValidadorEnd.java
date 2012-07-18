package classes;

public class ValidadorEnd extends Validador {

	Validador primeiroValidador;
	Validador segundoValidador;
	
	public ValidadorEnd(Validador primeiroValidador,
			Validador segundoValidador) {
		this.primeiroValidador = primeiroValidador;
		this.segundoValidador = segundoValidador;
	}

	@Override
	public boolean ehValido() {
		return primeiroValidador.ehValido() && segundoValidador.ehValido();
	}

}
