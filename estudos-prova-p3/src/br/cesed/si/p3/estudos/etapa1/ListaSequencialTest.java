/**
 * 
 */
package br.cesed.si.p3.estudos.etapa1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


/**
 * @author ted
 *
 */
public class ListaSequencialTest {

	
	private ListaSequencial listaSequencial = new ListaSequencial();

	@BeforeEach
	void setUp() throws Exception {
		listaSequencial.limpar();
	}

	@Test
	public void AdicionarPorPosicaoTest() throws EstadoIvalidoException, PosicaoInvalidaException {
		listaSequencial.adicionarItens("ted");
		listaSequencial.adicionarItens("helder");
		listaSequencial.adicionarItens("lucas");
		listaSequencial.adicionarItens("eric", 1);
		
		Assert.assertEquals("ted", listaSequencial.obter(0));
		Assert.assertEquals("eric", listaSequencial.obter(1));
		Assert.assertEquals("helder", listaSequencial.obter(2));
		Assert.assertEquals("lucas", listaSequencial.obter(3));
	}
	
	@Test
	public void AdicionarPorPosicaoVaziaTest() throws EstadoIvalidoException, PosicaoInvalidaException {
		listaSequencial.adicionarItens("ted");
		listaSequencial.adicionarItens("eric", 2);
		
		Assert.assertEquals("ted", listaSequencial.obter(0));
		Assert.assertEquals("eric", listaSequencial.obter(2));
	}
	
	@Test
	public void removerPorPosicaoTest() throws EstadoIvalidoException, PosicaoInvalidaException {
		listaSequencial.adicionarItens("ted");
		listaSequencial.adicionarItens("eric");
		listaSequencial.adicionarItens("clenildo");
		
		listaSequencial.remover(1);
		
		Assert.assertEquals("clenildo", listaSequencial.obter(1));
	}
	
	@Test
	public void removerPorObjetoTest() throws EstadoIvalidoException, PosicaoInvalidaException, ObjetoInvalidoException {
		listaSequencial.adicionarItens("ted");
		listaSequencial.adicionarItens("eric");
		listaSequencial.adicionarItens("clenildo");
		
		listaSequencial.remover("eric");
		
		Assert.assertEquals("clenildo", listaSequencial.obter(1));
	}
	
	@Test
	public void addEmPosicaoInvalidaTest() {
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			listaSequencial.adicionarItens("ted", -1);
		});
	}
	
	@Test
	public void addObjetoInvalidoTeste() {
		Assertions.assertThrows(EstadoIvalidoException.class, () -> {
			listaSequencial.adicionarItens(null);
		});
	}
}
