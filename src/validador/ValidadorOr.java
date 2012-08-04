package validador;

import classesPessoa.ValidadorCpfPessoa;

public class ValidadorOr extends Validador {
	
	private Validador primeiroValidador;
	private Validador segundoValidador;

	public ValidadorOr(Validador primeiroValidador, ValidadorCpfPessoa segundoValidador) {
		this.primeiroValidador = primeiroValidador;
		this.segundoValidador = segundoValidador;
	}

	@Override
	public boolean ehValido() {
		return primeiroValidador.ehValido() || segundoValidador.ehValido();
	}

}
