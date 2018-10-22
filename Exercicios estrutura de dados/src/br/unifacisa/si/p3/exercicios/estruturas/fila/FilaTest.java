/**
 * 
 */
package br.unifacisa.si.p3.exercicios.estruturas.fila;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.unifacisa.si.p3.exercicios.estruturas.lista.EstadoInvalidoException;

/**
 * @author ted
 *
 */
class FilaTest {

	
	private Fila fila;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		fila = new Fila();
	}

	

	/**
	 * Teste para validar que a fila está vazia
	 */
	@Test
	public void listaVaziaTest() {
		
		Assert.assertTrue(fila.isEmpty());
	}
	
	/**
	 * Teste para validar o método enqueue com um item
	 * @throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException 
	 *  
	 * 
	 */
	@Test
	public void enqueueUmItemTeste() throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException {
		
		fila.enqueue("Ted");
		
		Assert.assertEquals(1, fila.tamanho());
	}
	
	/**
	 * Teste para validar o método enqueue com quatro itens
	 * @throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException 
	 */
	@Test
	public void enqueueQuatroItensTeste() throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException {
		
		fila.enqueue("Ted");
		fila.enqueue("Eric");
		fila.enqueue("Menta");
		fila.enqueue("Clenildo");
		
		Assert.assertEquals(4, fila.tamanho());
	}
	
	/**
	 * Teste para validar o lançamento da exception EstadoInvalidoException no método dequeue
	 */
	@Test
	public void enqueueItemNullTeste(){
		
		Assertions.assertThrows(br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException.class, () -> {
			fila.enqueue(null);
		});
	}
	
	/**
	 * Teste para validar o método dequeue com uma fila de um item
	 * @throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException 
	 */
	@Test
	public void dequeueUmItemTeste() throws FilaVaziaException, br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException {
		
		fila.enqueue("Ted");
		
		fila.dequeue();
		
		Assert.assertTrue(fila.isEmpty());
	}
	
	/**
	 * Teste para validar o método dequeue com uma fila de quatro itens
	 * @throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException 
	 */
	@Test
	public void dequeueQuatroItensTeste() throws FilaVaziaException, br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException {
		
		fila.enqueue("Ted");
		fila.enqueue("Eric");
		fila.enqueue("Menta");
		fila.enqueue("Clenildo");
		
		fila.dequeue();		
		
		Assert.assertEquals(3, fila.tamanho());
	}
	
	/**
	 * Teste para validar o lançamento da exception FilaVaziaException no método dequeue
	 */
	@Test
	public void dequeueFilaVaziaTeste() {
		
		Assertions.assertThrows(FilaVaziaException.class, () -> {
			fila.dequeue();
		});
	}
	
	/**
	 * Teste para validar o método front
	 * @throws br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException 
	 */
	@Test
	public void frontTeste() throws FilaVaziaException, br.unifacisa.si.p3.exercicios.estruturas.fila.EstadoInvalidoException {
		
		fila.enqueue("Ted");
		fila.enqueue("Eric");
		fila.enqueue("Menta");
		fila.enqueue("Clenildo");		
		
		Assert.assertEquals("Ted", fila.front());
	}
	
	/**
	 * Teste para validar o lançamento da exception FilaVaziaException no método front
	 */
	@Test
	public void frontFilaVaziaTeste() {
		
		Assertions.assertThrows(FilaVaziaException.class, () -> {
			fila.front();
		});
	}
	
	
	
	
	
	

}
