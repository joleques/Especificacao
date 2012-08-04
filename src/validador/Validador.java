package validador;

import classesPessoa.ValidadorCpfPessoa;

public abstract class Validador {
		
	protected Object objetoAhValidar;
	
	protected void validacaoEhParaSerFeitaEm(Object objetoAhValidar){
		this.objetoAhValidar = objetoAhValidar;
	}
	
	public abstract boolean ehValido();

	public Validador and(Validador segundoValidador) {
		return new ValidadorEnd(this,segundoValidador);
	}
	
	public Validador andCC(Validador segundoValidador) {
		return new ValidadorEndCurtoCircuito(this,segundoValidador);
	}

	public Validador ou(ValidadorCpfPessoa segundoValidador) {
		return new ValidadorOr(this,segundoValidador);
	}

	public Validador nao() {
		return new ValidadorNot(this);
	}
	
	protected boolean objetoAhValidarEhValido(){
		return objetoAhValidar != null;
	}

}
