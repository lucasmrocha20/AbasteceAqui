package br.com.abasteceaqui.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.PostoController;

import br.com.abasteceaqui.model.entidades.Cliente;
import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.entidades.Posto;

public class TestePosto {

	private static int codigoPosto = 0;

	@BeforeClass
	public static void deveSalvarUmPostoTest() {
		Cliente cliente = new Cliente();
		cliente.setCnpjCliente("111111111111");
		cliente.setRazaoSocial("Cardoso Marcela LTDA");
		cliente.setFone("11111111");

		Posto posto = new Posto();
		posto.setCnpj("11111111111111");
		posto.setNomeFantasia("Posto modelo");
		posto.setPrecoAlcool(new BigDecimal("3.50"));
		posto.setPrecoGasolina(new BigDecimal("3.50"));
		posto.setDistribuidora("Ipiranga");
		posto.setFone("111111111");

		Endereco endereco = new Endereco();
		endereco.setRua("Av Caruaru");
		endereco.setNumero("50");
		endereco.setBairro("Vila do Quartel");
		endereco.setCidade("Garanhuns");
		endereco.setCep("casa");

		posto.setEndereco(endereco);

		PostoController repPosto = new PostoController();
		repPosto.salvar(posto);

		List<Posto> postos = repPosto.listarPosto();

		for (Posto lista : postos) {
			if (lista.getCnpj().equals("11111111111111")) {
				codigoPosto = lista.getId();
			}
		}
		Posto posto2 = repPosto.buscarPorCodigo(codigoPosto);
		Assert.assertEquals("11111111111111", posto2.getCnpj());
	}

	@Test
	public void deveBuscaPostoPorCodigoTest() {
		PostoController repPosto = new PostoController();
		Posto posto = repPosto.buscarPorCodigo(codigoPosto);

		boolean existe = posto != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDaPostoTest() {
		PostoController repPosto = new PostoController();
		Posto posto = repPosto.buscarPorCodigo(codigoPosto);
		posto.setNomeFantasia("Posto Modelo2");

		repPosto.alterar(posto);

		Posto alteracaoDoPosto = repPosto.buscarPorCodigo(codigoPosto);

		Assert.assertEquals("Posto Modelo2", alteracaoDoPosto.getNomeFantasia());
	}

	@AfterClass
	public static void deveDeletarPostoTest() {
		PostoController repPosto = new PostoController();
		Posto posto = repPosto.buscarPorCodigo(codigoPosto);
		repPosto.deletar(posto);
	}

}
