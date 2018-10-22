/**
 * 
 */
package br.unifacisa.si.p3.exercicios.estruturas.deque;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




/**
 * @author ted
 *
 */
class DequeTest {
	
	private Deque deque;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		deque = new Deque();
	}


	/**
	 * Teste da funcionalidade insertLast com quatro itens
	 */
	@Test
	public void inserirQuatroItensInsertFirstTest() {
		deque.insertFirst("Ted");
		deque.insertFirst("Eric");
		deque.insertFirst("Menta");
		deque.insertFirst("Clenildo");
		
		Assert.assertEquals(deque.getItem(0), "Clenildo");
	}
	
	/**
	 * Teste da funcionalidade insertFirst com um item
	 */
	@Test
	public void inserirUmItemInsertFirstTest() {
		deque.insertFirst("Ted");
		
		Assert.assertEquals(deque.getItem(0), "Ted");
	}
	
	/**
	 * Teste da funcionalidade insertLast com 4 itens
	 */
	@Test
	public void inserirQuatroItensInsertLastTest() {
		deque.insertLast("Ted");
		deque.insertLast("Eric");
		deque.insertLast("Menta");
		deque.insertLast("Clenildo");
		
		Assert.assertEquals(deque.getItem(3), "Clenildo");
	}
	
	/**
	 * Teste da funcionalidade insertLast com um item
	 */
	@Test
	public void inserirUmItemInsertLastTest() {
		deque.insertLast("Ted");
		
		Assert.assertEquals(deque.getItem(0), "Ted");
	}
	
	/**
	 * Teste da funcionalidade removeFirst
	 */
	@Test
	public void removeFirstDequeTresItensTest() {
		deque.insertLast("Ted");
		deque.insertLast("Eric");
		deque.insertLast("Menta");
		
		deque.removeFirst();
		
		Assert.assertEquals(deque.getItem(0), "Eric");
		Assert.assertNull(deque.getItem(2));
	}
	
	/**
	 * Teste da funcionalidade removeLast
	 */
	@Test
	public void removeLastDequeTresItensTest() {
		deque.insertLast("Ted");
		deque.insertLast("Eric");
		deque.insertLast("Menta");
		
		deque.removeLast();
		
		Assert.assertEquals(deque.getItem(0), "Ted");
		Assert.assertNull(deque.getItem(2));
	}
	
	/**
	 * Teste da funcionalidade isEmpty
	 */
	@Test
	public void removerTodosItensTest() {
		deque.insertLast("Ted");
		deque.insertFirst("Eric");
		deque.insertLast("Menta");
		
		deque.removeLast();
		deque.removeLast();
		deque.removeFirst();
		
		Assert.assertTrue(deque.isEmpty());
	}
	/**
	 * Teste das funcionalidades insertFirst e insertLast
	 */
	@Test
	public void InsertFirstLastTest() {
		deque.insertLast("Ted");
		deque.insertFirst("Eric");
		deque.insertFirst("Menta");
		deque.insertLast("Clenildo");
		
		Assert.assertEquals(deque.getItem(3), "Clenildo");
		Assert.assertEquals(deque.getItem(0), "Menta");
	}
	
	/**
	 * Teste da funcionalidade removeByValue
	 * @throws ItemNaoEncontradoException
	 */
	@Test
	public void removerItemPorValorTest() throws ItemNaoEncontradoException {
		deque.insertLast("Ted");
		deque.insertFirst("Eric");
		deque.insertFirst("Menta");
		deque.insertLast("Clenildo");
		
		deque.removeByValue("Menta");
		
		Assert.assertEquals(deque.getItem(2), "Clenildo");
		Assert.assertNull(deque.getItem(3));
	}
	
	/**
	 * Teste para verificar se a exception ItemNaoEncontradoException está sendo lançada ao passar uma posição inexistente no deque.
	 */
	@Test
	public void removerItemNaoExistenteTest() {
		
		Assertions.assertThrows(ItemNaoEncontradoException.class, () -> {
			deque.insertLast("Ted");
			deque.insertFirst("Eric");
			deque.removeByValue("Suricato");
		});
		
	}
	
	/**
	 * Teste da funcionalidade removeByIndex
	 * @throws PosicaoNaoEncontradaException
	 */
	@Test
	public void removerItemPorIndexTest() throws PosicaoNaoEncontradaException {
		deque.insertLast("Ted");
		deque.insertFirst("Eric");
		deque.insertFirst("Menta");
		deque.insertLast("Clenildo");
		
		deque.removeByIndex(2);
		
		Assert.assertEquals(deque.getItem(2), "Clenildo");
		Assert.assertNull(deque.getItem(3));
	}
	
	/**
	 * Teste para verificar se a exception PosicaoNaoEncontradaException está sendo lançada ao passar uma posição inexistente no deque.
	 */
	@Test
	public void removerPorPosicaoInexistenteTest() {
		
		Assertions.assertThrows(PosicaoNaoEncontradaException.class, () -> {
			deque.insertLast("Ted");
			deque.insertFirst("Eric");
			deque.removeByIndex(25);
		});
	}
	
	
}
