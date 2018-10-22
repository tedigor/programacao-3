package br.cesed.si.p3.pilha.sequencial.exemplo1;

public class Pilha {
	
	private static final int ALOCACAO_INICIAL = 3;
	private Object[] pilha = new Object[ALOCACAO_INICIAL];
	private int inseridos;
	
	
	public void push(Object item) {
		if (inseridos == pilha.length) {
			aumentarArray();
		}
		pilha[inseridos] = item;
		inseridos++;
		
	}

	private void aumentarArray() {
		Object[] novoArray = new Object[pilha.length * 2];
		for (int i = 0; i < pilha.length; i++) {
			novoArray[i] = pilha[i];
		}
		pilha = novoArray;
	}
	
	public Object pop() {
		Object pop = top();
		pilha[inseridos - 1] = null;
		inseridos--;
		return pop;
	}
	
	public Object top() {
		return pilha[inseridos - 1];
	}
	
	public int tamanho() {
		return inseridos;
	}
}
