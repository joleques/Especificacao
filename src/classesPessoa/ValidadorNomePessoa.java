package classesPessoa;

import validador.Validador;

public class ValidadorNomePessoa extends Validador {
	
	public ValidadorNomePessoa(Pessoa pessoa) {
		validacaoEhParaSerFeitaEm(pessoa);
	}

	public boolean ehValido() {
		return !super.objetoAhValidar.equals("");
	}
}
