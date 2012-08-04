package classesEstabelecimento;

import validador.Criticador;

public class CriticadorCNPJ extends Criticador {

	public static final String CRITICA_CNPJ = "O CNPJ esta invalido!";

	public CriticadorCNPJ(Estabelecimento estabelecimento) {
		super.objetoAhValidar = estabelecimento;
	}

	@Override
	public boolean ehValido() {
		boolean ehValidaAhCritica = criticarCNPJ();
		super.criticar(!ehValidaAhCritica, CRITICA_CNPJ);
		return ehValidaAhCritica;
	}

	private boolean criticarCNPJ() {
		return super.objetoAhValidarEhValido()
				&& ((Estabelecimento) super.objetoAhValidar).getCnpj() != null
				&& ((Estabelecimento) super.objetoAhValidar).getCnpj().length() == 14;
	}

}
