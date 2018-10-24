/**
 * 
 */
package br.cesed.si.p3.ed.encadeada.lista;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ted
 *
 */
class ListaEncadeadaTest {
	
	private ListaEncadeada lista;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		lista = new ListaEncadeada();
	}
	

	/**
	 * Validar a inclusão de um item na lista encadeada.
	 * @throws PosicaoInvalidaException 
	 */
	@Test
	public void AdicionarPrimeiroItemTest() throws PosicaoInvalidaException {
		Conta primeiraConta = new Conta(1,1,"Ted"); 
		lista.adicionar(primeiraConta);
		
		Assert.assertEquals(lista.get(lista.tamanho() - 1), primeiraConta);
	}
	
	/**
	 * Validar a inclusão de quatro itens na lista encadeada.
	 * @throws PosicaoInvalidaException 
	 */
	@Test
	public void AdicionarQuatroItensTest() throws PosicaoInvalidaException {
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.tamanho(), 4);
		Assert.assertNull(lista.get(3).getProximo());
	}
	
	/**
	 * Validar o último item da lista encadeada.
	 * @throws PosicaoInvalidaException 
	 */
	@Test
	public void ultimoItemListaTest() throws PosicaoInvalidaException {
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.get(lista.tamanho() - 1), quartaConta);
	}
	
	/**
	 * Validar o lançamento da exceção PosicaoInvalidaException no método get(int posicao). 
	 */
	@Test
	public void getPosicaoInvalidaTest() {
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			lista.adicionar(new Conta(1,1, "Ted"));
			lista.get(2);
		});
	}
	
	/**
	 * Validar método get(int posicao).
	 * @throws PosicaoInvalidaException 
	 */
	@Test
	public void getPosicoesEspecificasTest() throws PosicaoInvalidaException {
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.get(0), primeiraConta);
		Assert.assertEquals(lista.get(3), quartaConta);
	}
	
	/**
	 * Validar método remover retirando o primeiro item. 
	 * @throws PosicaoInvalidaException 
	 * @throws ContaNaoEncontradaException 
	 */
	@Test
	public void removerPrimeiroItemTest() throws PosicaoInvalidaException, ContaNaoEncontradaException {
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.get(0), primeiraConta);
		
		lista.remover(primeiraConta);
		
		Assert.assertEquals(lista.get(0), segundaConta);
	}
	
	/**
	 * Validar método remover retirando o último item. 
	 * @throws PosicaoInvalidaException 
	 * @throws ContaNaoEncontradaException 
	 */
	@Test
	public void removerUltimoItemTest() throws PosicaoInvalidaException, ContaNaoEncontradaException {
		
		int posicaoTestada = 3;
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.get(posicaoTestada), quartaConta);
		Assert.assertEquals(lista.tamanho(), 4);
		
		lista.remover(quartaConta);
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			lista.get(posicaoTestada);
		});
		
		Assert.assertEquals(lista.tamanho(), 3);
	}
	
	/**
	 * Validar método remover retirando o item da primeira posição. 
	 * @throws PosicaoInvalidaException 
	 * @throws ContaNaoEncontradaException 
	 */
	@Test
	public void removerPrimeiraPosicaoTest() throws PosicaoInvalidaException, ContaNaoEncontradaException {
		
		int posicaoTestada = 3;
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.get(posicaoTestada), quartaConta);
		Assert.assertEquals(lista.tamanho(), 4);
		
		Assert.assertEquals(lista.get(0), primeiraConta);
		
		lista.remover(0);
		
		Assert.assertEquals(lista.get(0), segundaConta);
	}
	
	/**
	 * Validar método remover retirando o item da ultima posição. 
	 * @throws PosicaoInvalidaException 
	 * @throws ContaNaoEncontradaException 
	 */
	@Test
	public void removerUltimaPosicaoTest() throws PosicaoInvalidaException, ContaNaoEncontradaException {
		
		int posicaoTestada = 3;
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assert.assertEquals(lista.get(posicaoTestada), quartaConta);
		Assert.assertEquals(lista.tamanho(), 4);
		
		Assert.assertEquals(lista.get(0), primeiraConta);
		
		lista.remover(posicaoTestada);
		
		Assert.assertEquals(lista.tamanho(), 3);
	}
	
	/**
	 * Validar se a exceção PosicaoInvalidaException Será lançada ao passar uma posição inexistente  
	 */
	@Test
	public void posicaoIvalidaTest() {
		
		int posicaoTestada = 29;
		
		Conta primeiraConta = new Conta(1,1,"Ted");
		Conta segundaConta = new Conta(1,2,"Helder");
		Conta terceiraConta = new Conta(1,3,"Gomes");
		Conta quartaConta = new Conta(1,4,"Suricato");
		
		lista.adicionar(primeiraConta);
		lista.adicionar(segundaConta);
		lista.adicionar(terceiraConta);
		lista.adicionar(quartaConta);
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			lista.remover(posicaoTestada);
		});
	}
}
