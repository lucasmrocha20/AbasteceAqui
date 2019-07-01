package br.com.abasteceaqui.teste;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.AvaliacaoController;
import br.com.abasteceaqui.model.controller.FrentistaController;
import br.com.abasteceaqui.model.controller.UsuarioController;
import br.com.abasteceaqui.model.entidades.Avaliacao;
import br.com.abasteceaqui.model.entidades.Frentista;
import br.com.abasteceaqui.model.entidades.Usuario;

public class TesteAvaliacao {
	private static int codigoAvaliacao = 0;

	@BeforeClass
    public static void deveSalvarNoBancoDadosTest() {
    	Frentista frentista = new Frentista();
    	frentista.setCpfFrentista("55555555555");
		frentista.setMatricula(5555);
		frentista.setNome("Joao Pedro");
		frentista.setFone("55555555");
		frentista.setEndereco(null);
		
		FrentistaController repFrentista = new FrentistaController();
		repFrentista.salvar(frentista);
		
		Usuario usuario = new Usuario();
        usuario.setNome("Marcela");
        usuario.setCpfUsuario("22222222222");
        usuario.setFone("22222222");
        usuario.setEndereco(null);
        
        UsuarioController repUsuario = new UsuarioController();
        repUsuario.salvar(usuario);
    	
    	Avaliacao avaliacao = new Avaliacao();
    	avaliacao.setComentario("Frentista muito atencioso");
    	avaliacao.setAvaliacao("Otimo");
    	avaliacao.setData("27/10/2018");
    	avaliacao.setFrentista(frentista);
    	avaliacao.setUsuario(usuario);
           
    	AvaliacaoController repAvaliacao = new AvaliacaoController();
        repAvaliacao.salvar(avaliacao);
        
        List<Avaliacao> aval = repAvaliacao.listarAvaliacao();
        
        for (Avaliacao busca : aval) {
			if(busca.getFrentista().getNome().equals("Joao Pedro")) {
				codigoAvaliacao = busca.getId();
			}
		}
        
        Avaliacao avalicaoDoUsuario = repAvaliacao.buscarPorCodigo(codigoAvaliacao);
        Assert.assertEquals("Frentista muito atencioso", avalicaoDoUsuario.getComentario());
    }
	
	@Test
	public void deveListaTodasAvaliacoesTest() {
		AvaliacaoController repAvaliacao = new AvaliacaoController();
		List<Avaliacao> lista = repAvaliacao.listarAvaliacao();
		
		boolean listou = lista.size() > 0; 
		Assert.assertTrue(listou);
	}
	
	@Test
	public void deveBuscaAvaliacaoPorCodigoTest() {
		AvaliacaoController repAvaliacao = new AvaliacaoController();
		Avaliacao avaliacao = repAvaliacao.buscarPorCodigo(codigoAvaliacao);
		
		boolean existe = avaliacao != null ? true : false;
		Assert.assertTrue(existe);
	}
	
	@Test
	public void deveAlterarDadosDaAvaliacaoTest() {
		AvaliacaoController repAvaliacao = new AvaliacaoController();
		Avaliacao avaliacao = repAvaliacao.buscarPorCodigo(codigoAvaliacao);
    	avaliacao.setComentario("Frentista pouco atencioso");
    	
    	repAvaliacao.alterar(avaliacao);
    	
    	Avaliacao alteracaoDaAvaliacao = repAvaliacao.buscarPorCodigo(codigoAvaliacao);
    	
    	Assert.assertEquals("Frentista pouco atencioso", alteracaoDaAvaliacao.getComentario());
	}
	
	@AfterClass
	public static void deveDeletarAvaliacaoTest() {
		AvaliacaoController repAvaliacao = new AvaliacaoController();
		Avaliacao avaliacao = repAvaliacao.buscarPorCodigo(codigoAvaliacao);
		repAvaliacao.deletar(avaliacao);
	}

}
