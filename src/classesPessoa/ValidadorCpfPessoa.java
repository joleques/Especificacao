package classesPessoa;

import validador.Validador;

public class ValidadorCpfPessoa extends Validador  {
		
	public ValidadorCpfPessoa(Pessoa pessoa) {
		validacaoEhParaSerFeitaEm(pessoa);
	}

	public boolean ehValido() {
		return ((Pessoa) super.objetoAhValidar).getCpf() != null;
	}


}
