package classesEstabelecimento;


import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import validador.Criticador;

public class CriticadorEstabelecimentoTeste {

	private Estabelecimento estabelecimento;
	
	@Before
	public void setUp() throws Exception {
		estabelecimento = new Estabelecimento();
	}

	@After
	public void tearDown() throws Exception {
		estabelecimento = null;
		Criticador.listaCritica = new ArrayList<String>();
	}
	
	@Test
	public void criticarEstabelecimentoComFaturamentoForadoPermitidoERazaoSocialVazia(){
		//DADO QUE
		estabelecimento.setCnpj("12345678901234");
		estabelecimento.setFaturamento(45.0);
		estabelecimento.setRazaoSocial("");
		
		//QUANDO
		CriticadorCNPJ cnpj = new CriticadorCNPJ(estabelecimento);
		CriticadorFaturamento faturamento = new CriticadorFaturamento(estabelecimento);
		CriticadorRazaoSocial razaoSocial = new CriticadorRazaoSocial(estabelecimento);
		
		//ENTÃO
		Assert.assertFalse(cnpj.andCC(faturamento).andCC(razaoSocial).ehValido());
		Assert.assertTrue(Criticador.listaCritica.size() > 0);
		
		Assert.assertEquals(Criticador.listaCritica.get(0),CriticadorFaturamento.CRITICA_FATURAMENTO);
		Assert.assertEquals(Criticador.listaCritica.get(1),CriticadorRazaoSocial.CRITICA_RAZAO_SOCIAL);
	}

	@Test
	public void criticarEstabelecimentotTodosCamposInvalidos(){
		//DADO QUE
		estabelecimento.setCnpj("123456789012345");
		estabelecimento.setFaturamento(45.0);
		estabelecimento.setRazaoSocial("");
		
		//QUANDO
		CriticadorCNPJ cnpj = new CriticadorCNPJ(estabelecimento);
		CriticadorFaturamento faturamento = new CriticadorFaturamento(estabelecimento);
		CriticadorRazaoSocial razaoSocial = new CriticadorRazaoSocial(estabelecimento);
		
		//ENTÃO
		Assert.assertFalse(cnpj.andCC(faturamento).andCC(razaoSocial).ehValido());
		Assert.assertTrue(Criticador.listaCritica.size() > 0);
		Assert.assertEquals(Criticador.listaCritica.get(0),CriticadorCNPJ.CRITICA_CNPJ);
		Assert.assertEquals(Criticador.listaCritica.get(1),CriticadorFaturamento.CRITICA_FATURAMENTO);
		Assert.assertEquals(Criticador.listaCritica.get(2),CriticadorRazaoSocial.CRITICA_RAZAO_SOCIAL);
	}

	@Test
	public void criticarEstabelecimentoComCNPJInvalidos(){
		//DADO QUE
		estabelecimento.setCnpj("123456789012345");
		estabelecimento.setFaturamento(70.0);
		estabelecimento.setRazaoSocial("Teste");
		
		//QUANDO
		CriticadorCNPJ cnpj = new CriticadorCNPJ(estabelecimento);
		CriticadorFaturamento faturamento = new CriticadorFaturamento(estabelecimento);
		CriticadorRazaoSocial razaoSocial = new CriticadorRazaoSocial(estabelecimento);
		
		//ENTÃO
		Assert.assertFalse(cnpj.andCC(faturamento).andCC(razaoSocial).ehValido());
		Assert.assertTrue(Criticador.listaCritica.size() == 1);
		Assert.assertEquals(Criticador.listaCritica.get(0),CriticadorCNPJ.CRITICA_CNPJ);
	}

	@Test
	public void criticarEstabelecimentoComFaturamentoAcimaDoPermitido(){
		//DADO QUE
		estabelecimento.setCnpj("12345678901234");
		estabelecimento.setFaturamento(170.0);
		estabelecimento.setRazaoSocial("Teste");
		
		//QUANDO
		CriticadorCNPJ cnpj = new CriticadorCNPJ(estabelecimento);
		CriticadorFaturamento faturamento = new CriticadorFaturamento(estabelecimento);
		CriticadorRazaoSocial razaoSocial = new CriticadorRazaoSocial(estabelecimento);
		
		//ENTÃO
		Assert.assertFalse(cnpj.andCC(faturamento).andCC(razaoSocial).ehValido());
		Assert.assertTrue(Criticador.listaCritica.size() == 1);
		Assert.assertEquals(Criticador.listaCritica.get(0),CriticadorFaturamento.CRITICA_FATURAMENTO);
	}

	@Test
	public void criticarEstabelecimentoComFaturamentoInvalidos(){
		//DADO QUE
		estabelecimento.setCnpj("12345678901234");
		estabelecimento.setFaturamento(0.0);
		estabelecimento.setRazaoSocial("Teste");
		
		//QUANDO
		CriticadorCNPJ cnpj = new CriticadorCNPJ(estabelecimento);
		CriticadorFaturamento faturamento = new CriticadorFaturamento(estabelecimento);
		CriticadorRazaoSocial razaoSocial = new CriticadorRazaoSocial(estabelecimento);
		
		//ENTÃO
		Assert.assertFalse(cnpj.andCC(faturamento).andCC(razaoSocial).ehValido());
		Assert.assertTrue(Criticador.listaCritica.size() == 2);
		Assert.assertEquals(Criticador.listaCritica.get(0),CriticadorFaturamento.CRITICA_FATURAMENTO_INVALIDO);
		Assert.assertEquals(Criticador.listaCritica.get(1),CriticadorFaturamento.CRITICA_FATURAMENTO);
	}
}
