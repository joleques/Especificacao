package classes;

public class ValidadorNomePessoa extends Validador {
	
	public ValidadorNomePessoa(Pessoa pessoa) {
		validacaoEhParaSerFeitaEm(pessoa);
	}

	public boolean ehValido() {
		return !super.objetoAhValidar.equals("");
	}
}
