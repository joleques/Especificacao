package classesEstabelecimento;

import validador.Criticador;

public class CriticadorRazaoSocial extends Criticador {

	public static final String CRITICA_RAZAO_SOCIAL = "A Razão Social é Invalida!";

	public CriticadorRazaoSocial(Estabelecimento estabelecimento) {
		super.objetoAhValidar = estabelecimento;
	}

	@Override
	public boolean ehValido() {
		boolean ehValidaAhCritica = validar();
		criticar(!ehValidaAhCritica, CRITICA_RAZAO_SOCIAL);
		return ehValidaAhCritica;

	}

	private boolean validar() {
		return super.objetoAhValidarEhValido()
				&& ((Estabelecimento) super.objetoAhValidar).getRazaoSocial() != null
				&& !"".equals(((Estabelecimento) super.objetoAhValidar)
						.getRazaoSocial());
	}
}
