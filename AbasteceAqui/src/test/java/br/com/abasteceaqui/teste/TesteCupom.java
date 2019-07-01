package br.com.abasteceaqui.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.CupomController;
import br.com.abasteceaqui.model.controller.UsuarioController;
import br.com.abasteceaqui.model.controller.VendaController;
import br.com.abasteceaqui.model.entidades.Cupom;
import br.com.abasteceaqui.model.entidades.Usuario;
import br.com.abasteceaqui.model.entidades.Venda;

public class TesteCupom {

	private static int codigoCupons = 0;

	@BeforeClass
	public static void deveSalvarUmCupomTest() {

		Usuario usuario = new Usuario();
		usuario.setNome("Marcela");
		usuario.setCpfUsuario("22222222222");
		usuario.setFone("22222222");

		UsuarioController repUsuario = new UsuarioController();
		repUsuario.salvar(usuario);

		Venda venda = new Venda();
		venda.setLitragem(20);
		venda.setDesconto(5);
		venda.setData("10/01/2018");
		venda.setValor(new BigDecimal("100.00"));

		VendaController repVenda = new VendaController();
		repVenda.salvar(venda);

		Cupom cupom = new Cupom();
		cupom.setPontuacao(10);
		cupom.setValorDesconto(new BigDecimal("5"));
		cupom.setDataValidade("01/02/2017");
		cupom.setStatus("vencido");
		cupom.setUsuario(usuario);
		cupom.setVenda(venda);

		CupomController repCupom = new CupomController();
		repCupom.salvar(cupom);

		List<Cupom> cupons = repCupom.listarCupom();

		for (Cupom lista : cupons) {
			if (lista.getStatus().equals("vencido")) {
				codigoCupons = lista.getId();
			}
		}

		Cupom cupom2 = repCupom.buscarPorCodigo(codigoCupons);
		Assert.assertEquals("vencido", cupom2.getStatus());

	}

	@Test
	public void deveListaTodasCuponsTest() {
		CupomController repCupom = new CupomController();
		List<Cupom> lista = repCupom.listarCupom();

		boolean listou = lista.size() > 0;
		Assert.assertTrue(listou);
	}

	@Test
	public void deveBuscaCupomPorCodigoTest() {
		CupomController repCupom = new CupomController();
		Cupom cupom = repCupom.buscarPorCodigo(codigoCupons);

		boolean existe = cupom != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDoCupomTest() {
		CupomController repCupom = new CupomController();
		Cupom cupom = repCupom.buscarPorCodigo(codigoCupons);
		cupom.setStatus("valido");

		repCupom.alterar(cupom);

		Cupom alteracaoDoCupom = repCupom.buscarPorCodigo(codigoCupons);

		Assert.assertEquals("valido", alteracaoDoCupom.getStatus() );
	}

	@AfterClass
	public static void deveDeletarCupomTest() {
		CupomController repCupom = new CupomController();
		Cupom cupom = repCupom.buscarPorCodigo(codigoCupons);
		repCupom.deletar(cupom);
	}

}
