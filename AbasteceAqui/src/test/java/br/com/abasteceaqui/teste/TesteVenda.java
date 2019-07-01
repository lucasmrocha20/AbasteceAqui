package br.com.abasteceaqui.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.VendaController;
import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.entidades.Posto;
import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.entidades.Venda;

public class TesteVenda {

	private static int codigoVenda = 0;

	@BeforeClass
	public static void deveSalvarUmaVendaTest() {

		Posto posto = new Posto();
		posto.setCnpj("3333333");
		posto.setNomeFantasia("Posto Esperanca");
		posto.setPrecoAlcool(new BigDecimal("3.50"));
		posto.setPrecoGasolina(new BigDecimal("4.00"));
		posto.setDistribuidora("Casulinha");
		posto.setFone("33333");

		Usuario usuario = new Usuario();
		usuario.setNome("Marcela");
		usuario.setCpfUsuario("22222222222");
		usuario.setFone("22222222");

		Frentista frentista = new Frentista();
		frentista.setCpfFrentista("55555555555");
		frentista.setMatricula(5555);
		frentista.setNome("Jaoao");
		frentista.setFone("55555555");

		Venda venda = new Venda();
		venda.setLitragem(20);
		venda.setDesconto(5);
		venda.setData("10/01/2018");
		venda.setValor(new BigDecimal("10.00"));
		venda.setPosto(posto);
		venda.setUsuario(usuario);
		venda.setFrentista(frentista);

		VendaController repVenda = new VendaController();
		repVenda.salvar(venda);

		List<Venda> vend = repVenda.listarVenda();

		for (Venda busca : vend) {
			if (busca.getPosto().getCnpj().equals("3333333")) {
				codigoVenda = busca.getId();
			}
			Venda venda2 = repVenda.buscarPorCodigo(codigoVenda);
			Assert.assertEquals("3333333", venda2.getPosto().getCnpj());
		}
	}

	@Test
	public void deveListaTodasVendasTest() {
		VendaController repVenda = new VendaController();
		List<Venda> lista = repVenda.listarVenda();

		boolean listou = lista.size() > 0;
		Assert.assertTrue(listou);
	}

	@Test
	public void deveBuscaVendaPorCodigoTest() {
		VendaController repVenda = new VendaController();
		Venda venda = repVenda.buscarPorCodigo(codigoVenda);

		boolean existe = venda != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDaVendaTest() {
		VendaController repVenda = new VendaController();
		Venda venda = repVenda.buscarPorCodigo(codigoVenda);
		venda.setData("29/10/2018");
		
		repVenda.alterar(venda);

		Venda alteracaoDoPosto = repVenda.buscarPorCodigo(codigoVenda);

		Assert.assertEquals("29/10/2018", alteracaoDoPosto.getData());
	}

	@AfterClass
	public static void deveDeletarVendaTest() {
		VendaController repVenda = new VendaController();
		Venda venda = repVenda.buscarPorCodigo(codigoVenda);
		repVenda.deletar(venda);
	}

}
