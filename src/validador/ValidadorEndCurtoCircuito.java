package validador;


public class ValidadorEndCurtoCircuito extends ValidadorEnd{

	public ValidadorEndCurtoCircuito(Validador primeiroValidador,
			Validador segundoValidador) {
		super(primeiroValidador, segundoValidador);
	}

	@Override
	public boolean ehValido() {
		return primeiroValidador.ehValido() & segundoValidador.ehValido();
	}
}
