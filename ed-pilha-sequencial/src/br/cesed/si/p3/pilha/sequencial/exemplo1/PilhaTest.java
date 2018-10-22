package br.cesed.si.p3.pilha.sequencial.exemplo1;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaTest {
	
	private Pilha pilha;

	@BeforeEach
	void setUp() throws Exception {
		
		pilha = new Pilha();
	}


	@Test
	public void emptyPillTest() {
		Assert.assertEquals(0, pilha.tamanho());
	}
	
	@Test
	public void pushOneItemTest() {
		pilha.push("Ted");
		
		Assert.assertEquals(1, pilha.tamanho());
	}
	
	@Test
	public void pushFourItemsTest() {
		pilha.push("Ted");
		pilha.push("Eric");
		pilha.push("Clenildo");
		pilha.push("Menta");
		
		Assert.assertEquals(4, pilha.tamanho());
	}
	
	@Test
	public void popWithOneItemPushedTest() {
		pilha.push("Ted");
		
		Assert.assertEquals("Ted", pilha.pop());
	}
	
	@Test
	public void popWithFourItemsPushedTest() {
		pilha.push("Ted");
		pilha.push("Eric");
		pilha.push("Clenildo");
		pilha.push("Menta");
		
		Assert.assertEquals("Menta", pilha.pop());
	}
	
	@Test
	public void positionEmptyAfterPopTest() {
		
		pilha.push("Ted");
		pilha.push("Eric");
		pilha.push("Clenildo");
		pilha.push("Menta");
		
		pilha.pop();
		
		
		Assert.assertEquals(3, pilha.tamanho());
	}
	
	@Test
	public void topWithOneItemPushedTest() {
		pilha.push("Ted");
		
		Assert.assertEquals("Ted", pilha.top());
	}
	
	@Test
	public void topWithFourItemsPushedTest() {
		pilha.push("Ted");
		pilha.push("Eric");
		pilha.push("Clenildo");
		pilha.push("Menta");
		
		Assert.assertEquals("Menta", pilha.top());
	}
	
	@Test
	public void positionNotEmptyAfterTopTest() {
		
		pilha.push("Ted");
		pilha.push("Eric");
		pilha.push("Clenildo");
		pilha.push("Menta");
		
		pilha.top();
		
		Assert.assertEquals(4, pilha.tamanho());
	}
}
