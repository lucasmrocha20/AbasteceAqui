package br.com.abasteceaqui.teste;

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.ClienteController;
import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.entidades.Cliente;

public class TesteCliente {

	private static int codigoCliente = 0;

	@BeforeClass
	public static void deveSalvarUmClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = new Cliente();
		cliente.setCnpjCliente("111111111111");
		cliente.setRazaoSocial("Cardoso Marcela LTDA");
		cliente.setFone("11111111");

		Endereco endereco = new Endereco();
		endereco.setRua("Orestes Barbosa");
		endereco.setNumero("100");
		endereco.setBairro("Heliopolis");
		endereco.setCidade("Garanhuns");
		endereco.setCep("55290000");

		cliente.setEndereco(endereco);

		// Cliente c = criarCliente();

		repCliente.salvar(cliente);

		List<Cliente> clientes = repCliente.listarCliente();

		for (Cliente lista : clientes) {
			if (lista.getRazaoSocial().equals("Cardoso Marcela LTDA")) {
				codigoCliente = lista.getId();
			}
		}

		// Incluso por Luciano e Adrielly em 27/11/2018
		Assert.assertNotNull(clientes);
		//

		// Marcela, qualquer coisa voce pode apagar essas 2 linhas de codigos que estão
		// abaixo.
		Cliente cliente2 = repCliente.buscarPorCodigo(codigoCliente);
		Assert.assertEquals("Cardoso Marcela LTDA", cliente2.getRazaoSocial());

	}

	// Alterei o nome do método de "TodasClientes" para "TodosClientes"
	@Test
	public void deveListaTodosClientesTest() {
		ClienteController repCliente = new ClienteController();
		List<Cliente> lista = repCliente.listarCliente();

		// boolean listou = lista.size() > 0;
		// Assert.assertTrue(listou);

		// Incluso por Luciano e Adrielly em 27/11/2018
		int contAux = 0;
		for (Cliente l : lista) {
			System.out.println(l);
			contAux++;
		}

		Assert.assertEquals(contAux, lista.size());

	}

	@Test
	public void deveBuscaClientePorNomeTest() {
		ClienteController repCliente = new ClienteController();
		List<Cliente> listCliente = repCliente.listarCliente();

		for (Cliente cliente : listCliente) {
			System.out.println("TESTAAAAAAAAAAAAAAANDO" + cliente);
		}

		// Incluso por Luciano e Adrielly em 27/11/2018
		boolean flag = false;

		//Caso não funcione com o Scanner, altera para uma variável String e atribuir algum valor.
		Scanner sc = new Scanner(System.in);
		String resp = sc.next();
		sc.close();

		for (Cliente l : listCliente) {
			if (l.getRazaoSocial().equals(resp)) {
				flag = true;
				System.out.println("Nome achado: " + l.getRazaoSocial());
			}
		}

		Assert.assertNotNull(flag);

	}

	@Test
	public void deveAlterarDadosDaClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);

		cliente.setRazaoSocial("teste");

		repCliente.alterar(cliente);

		// Cliente alteracaoDaCliente = repCliente.buscarPorCodigo(codigoCliente);

		Cliente resp = repCliente.buscarPorCodigo(codigoCliente);

		Assert.assertEquals(resp, cliente);
	}

	@AfterClass
	public static void deveDeletarClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		// repCliente.deletar(cliente);

		// Incluso por Luciano e Adrielly em 27/11/2018
		List<Cliente> lista = repCliente.listarCliente();

		Cliente temporario = cliente;
		repCliente.deletar(cliente);

		boolean flag = false;

		for (Cliente l : lista) {
			if (l.getRazaoSocial().equals(temporario.getRazaoSocial())) {
				flag = true;
			}
		}

		Assert.assertNotNull(flag);

	}

}
