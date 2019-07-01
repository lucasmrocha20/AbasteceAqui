package br.com.abasteceaqui.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.FrentistaController;

import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.entidades.Posto;

public class TesteFrentista {

	private static int codigoFrentista = 0;

	@BeforeClass
	public static void deveSalvarUmFrentistaTest() {
		Posto posto = new Posto();
		posto.setCnpj("3333333");
		posto.setNomeFantasia("Posto Esperanca");
		posto.setPrecoAlcool(new BigDecimal("2.99"));
		posto.setPrecoGasolina(new BigDecimal("4.59"));
		posto.setDistribuidora("Casulinha");
		posto.setFone("33333");

		Frentista frentista = new Frentista();
		frentista.setCpfFrentista("55555555555");
		frentista.setMatricula(5555);
		frentista.setNome("Jaoao");
		frentista.setFone("55555555");

		Endereco endereco = new Endereco();
		endereco.setRua("Av Caruaru");
		endereco.setNumero("50");
		endereco.setBairro("Vila do Quartel");
		endereco.setCidade("Garanhuns");
		endereco.setCep("casa");

		frentista.setEndereco(endereco);
		frentista.setPosto(posto);

		FrentistaController repFrentista = new FrentistaController();
		repFrentista.salvar(frentista);

		List<Frentista> fren = repFrentista.listarFrentista();

		for (Frentista busca : fren) {
			if (busca.getCpfFrentista().equals("55555555555"))
				;
			codigoFrentista = busca.getId();

		}

		Frentista frentista2 = repFrentista.buscarPorCodigo(codigoFrentista);
		Assert.assertEquals("55555555555", frentista2.getCpfFrentista());
	}

	@Test
	public void deveListaTodasFrentistasTest() {
		FrentistaController repFrentista = new FrentistaController();
		List<Frentista> lista = repFrentista.listarFrentista();

		boolean listou = lista.size() > 0;
		Assert.assertTrue(listou);
	}

	@Test
	public void deveBuscaFrentistaPorCodigoTest() {
		FrentistaController repFrentista = new FrentistaController();
		Frentista frentista = repFrentista.buscarPorCodigo(codigoFrentista);

		boolean existe = frentista != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDoFrentistaTest() {
		FrentistaController repFrentista = new FrentistaController();
		Frentista frentista = repFrentista.buscarPorCodigo(codigoFrentista);
		frentista.setCpfFrentista("66666666666");

		repFrentista.alterar(frentista);

		Frentista alteracaoDoFrentista = repFrentista.buscarPorCodigo(codigoFrentista);

		Assert.assertEquals("66666666666", alteracaoDoFrentista.getCpfFrentista());
	}

	@AfterClass
	public static void deveDeletarFrentistaTest() {
		FrentistaController repFrentista = new FrentistaController();
		Frentista frentista = repFrentista.buscarPorCodigo(codigoFrentista);
		repFrentista.deletar(frentista);
	}

}
