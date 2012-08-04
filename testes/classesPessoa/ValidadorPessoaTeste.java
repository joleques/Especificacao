package classesPessoa;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import classesPessoa.Pessoa;
import classesPessoa.ValidadorCpfPessoa;
import classesPessoa.ValidadorNomePessoa;

import validador.Validador;

public class ValidadorPessoaTeste {
	
	Pessoa pessoa;

	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa();
		pessoa.setCpf(123456789);
		pessoa.setNome("Jorge Oleques");
	}

	@After
	public void tearDown() throws Exception {
		pessoa = null;
	}
	
	@Test
	public void validarNomePessoaSucesso(){
		Validador nome = new ValidadorNomePessoa(pessoa);
		Assert.assertTrue(nome.ehValido());
	}

	@Test
	public void validarNomePessoaNegacaoSucesso(){
		Validador nome = new ValidadorNomePessoa(pessoa);
		Assert.assertFalse(nome.nao().ehValido());
	}

	@Test
	public void validarCpfPessoaSucesso(){
		ValidadorCpfPessoa cpf = new ValidadorCpfPessoa(pessoa);
		Assert.assertTrue(cpf.ehValido());
	}

	@Test
	public void validarCpfENomePessoaSucesso(){
		Validador nome = new ValidadorNomePessoa(pessoa);		
		Validador nomeEcpf = nome.and(new ValidadorCpfPessoa(pessoa));		
		Assert.assertTrue(nomeEcpf.ehValido());
	}

	@Test
	public void validarCpfOUNomePessoaSucesso(){
		pessoa.setCpf(null);
		Validador nome = new ValidadorNomePessoa(pessoa);		
		Validador nomeOucpf = nome.ou(new ValidadorCpfPessoa(pessoa));		
		Assert.assertTrue(nomeOucpf.ehValido());
	}
	

}
