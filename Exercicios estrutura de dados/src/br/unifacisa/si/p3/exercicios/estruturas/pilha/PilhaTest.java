package br.unifacisa.si.p3.exercicios.estruturas.pilha;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaTest {

	private Pilha pilha;

	@BeforeEach
	public void setUp() throws Exception {
		pilha = new Pilha();
	}

	@Test
	public void testeTamanhoPilhaVazia() {
		Assert.assertEquals(0, pilha.tamanho());
	}

	@Test
	public void testeTamanhoAdicionarUmElementoPilha() throws EstadoInvalidoException {
		pilha.push("Elemento 1");
		Assert.assertEquals(1, pilha.tamanho());
	}

	@Test
	public void testeTamanhoAdicionarQuatroElementosPilha() throws EstadoInvalidoException {
		pilha.push("Elemento 1");
		pilha.push("Elemento 2");
		pilha.push("Elemento 3");
		pilha.push("Elemento 4");
		Assert.assertEquals(4, pilha.tamanho());
	}

	@Test
	public void testePopAdicionarUmElementoPilha() throws PilhaVaziaException, EstadoInvalidoException {
		pilha.push("Elemento 1");
		Assert.assertEquals("Elemento 1", pilha.pop());
	}

	@Test
	public void testePopAdicionarQuatroElementosPilha() throws EstadoInvalidoException, PilhaVaziaException {
		pilha.push("Elemento 1");
		pilha.push("Elemento 2");
		pilha.push("Elemento 3");
		pilha.push("Elemento 4");
		Assert.assertEquals("Elemento 4", pilha.pop());
	}
	
	@Test
	public void popEmPilhaVaziaTest() {
		Assertions.assertThrows(PilhaVaziaException.class, () -> {
			pilha.pop();
		});
	}
	
	@Test
	public void topEmPilhaVaziaTest() {
		Assertions.assertThrows(PilhaVaziaException.class, () -> {
			pilha.top();
		});
	}
	
	@Test
	public void addItemNullTest() {
		Assertions.assertThrows(EstadoInvalidoException.class, () -> {
			pilha.push(null);
		});
	}
}
