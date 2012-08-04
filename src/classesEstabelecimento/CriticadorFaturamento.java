package classesEstabelecimento;

import validador.Criticador;

public class CriticadorFaturamento extends Criticador {

	public static final String CRITICA_FATURAMENTO = "O Faturamento está fora do permitido!";
	public static final String CRITICA_FATURAMENTO_INVALIDO = "O Faturamento não pode ser Zero!";

	public CriticadorFaturamento(Estabelecimento estabelecimento) {
		super.objetoAhValidar = estabelecimento;
	}

	@Override
	public boolean ehValido() {
		return faturamentoEhValido() & criticarFaturamento();

	}

	private boolean faturamentoEhValido() {
		boolean ehValidaAhCritica = ehDiferenteDeZero();
		super.criticar(!ehValidaAhCritica, CRITICA_FATURAMENTO_INVALIDO);
		return ehValidaAhCritica;
	}

	private boolean ehDiferenteDeZero() {
		return super.objetoAhValidarEhValido()
				&& ((Estabelecimento) super.objetoAhValidar).getFaturamento() != null
				&& (((Estabelecimento) super.objetoAhValidar).getFaturamento() != 0);
	}

	private boolean criticarFaturamento() {
		boolean ehValidaAhCritica = estaDentroDoLimite();
		super.criticar(!ehValidaAhCritica, CRITICA_FATURAMENTO);
		return ehValidaAhCritica;
	}

	private boolean estaDentroDoLimite() {
		return super.objetoAhValidarEhValido()
				&& ((Estabelecimento) super.objetoAhValidar).getFaturamento() != null
				&& (((Estabelecimento) super.objetoAhValidar).getFaturamento() > 50 && ((Estabelecimento) super.objetoAhValidar)
						.getFaturamento() < 100);
	}

}
