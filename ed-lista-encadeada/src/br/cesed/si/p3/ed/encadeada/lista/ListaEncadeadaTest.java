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
	 * Validar a inclus�o de um item na lista encadeada.
	 * @throws PosicaoInvalidaException 
	 */
	@Test
	public void AdicionarPrimeiroItemTest() throws PosicaoInvalidaException {
		Conta primeiraConta = new Conta(1,1,"Ted"); 
		lista.adicionar(primeiraConta);
		
		Assert.assertEquals(lista.get(lista.tamanho() - 1), primeiraConta);
	}
	
	/**
	 * Validar a inclus�o de quatro itens na lista encadeada.
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
	 * Validar o �ltimo item da lista encadeada.
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
	 * Validar o lan�amento da exce��o PosicaoInvalidaException no m�todo get(int posicao). 
	 */
	@Test
	public void getPosicaoInvalidaTest() {
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			lista.adicionar(new Conta(1,1, "Ted"));
			lista.get(2);
		});
	}
	
	/**
	 * Validar m�todo get(int posicao).
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
	 * Validar m�todo remover retirando o primeiro item. 
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
	 * Validar m�todo remover retirando o �ltimo item. 
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
	 * Validar m�todo remover retirando o item da primeira posi��o. 
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
	 * Validar m�todo remover retirando o item da ultima posi��o. 
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
	 * Validar se a exce��o PosicaoInvalidaException Ser� lan�ada ao passar uma posi��o inexistente  
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
