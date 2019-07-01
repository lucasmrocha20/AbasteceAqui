package br.com.abasteceaqui.teste;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.UsuarioController;
import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.entidades.Usuario;

public class TesteUsuario {

	private static int codigoUsuario = 0;

	@BeforeClass
	public static void deveSalvarUmUsuarioTest() {

		Usuario usuario = new Usuario();
		usuario.setNome("Marcela");
		usuario.setCpfUsuario("22222222222");
		usuario.setFone("22222222");

		Endereco endereco = new Endereco();
		endereco.setRua("Av Caruaru");
		endereco.setNumero("50");
		endereco.setBairro("Vila do Quartel");
		endereco.setCidade("Garanhuns");
		endereco.setCep("casa");

		usuario.setEndereco(endereco);

		UsuarioController repUsuario = new UsuarioController();
		repUsuario.salvar(usuario);

		List<Usuario> usuarios = repUsuario.listarUsuario();

		for (Usuario lista : usuarios) {
			if (lista.getNome().equals("Marcela")) {
				codigoUsuario = lista.getId();
			}
		}

		Usuario usuario2 = repUsuario.buscarPorCodigo(codigoUsuario);
		Assert.assertEquals("Marcela", usuario2.getNome());
	}

	@Test
	public void deveBuscaUsuarioPorCodigoTest() {
		UsuarioController repUsuario = new UsuarioController();
		Usuario usuario = repUsuario.buscarPorCodigo(codigoUsuario);

		boolean existe = usuario != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDaUsuarioTest() {
		UsuarioController repUsuario = new UsuarioController();
		Usuario usuario = repUsuario.buscarPorCodigo(codigoUsuario);
		usuario.setNome("Marcelo");

		repUsuario.alterar(usuario);

		Usuario alteracaoDoUsuario = repUsuario.buscarPorCodigo(codigoUsuario);

		Assert.assertEquals("Marcelo", alteracaoDoUsuario.getNome());
	}

	@AfterClass
	public static void deveDeletarUsuarioTest() {
		UsuarioController repUsuario = new UsuarioController();
		Usuario usuario = repUsuario.buscarPorCodigo(codigoUsuario);
		repUsuario.deletar(usuario);
	}

}
