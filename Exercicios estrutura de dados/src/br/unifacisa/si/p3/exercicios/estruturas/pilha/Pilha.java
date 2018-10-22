package br.unifacisa.si.p3.exercicios.estruturas.pilha;

public class Pilha {

	public static final int ALOCACAO_INICIAL = 3;
	
	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];
	
	private int inseridos;
	
	public void push(Object objeto) throws EstadoInvalidoException {
		
		if(objeto == null) {
			throw new EstadoInvalidoException("O objeto não pode ser nulo");
		}

		if(inseridos == arrayInterno.length) {
			
			Object[] novoArray = new Object[arrayInterno.length * 2];
			
			for (int i = 0; i < arrayInterno.length; i++) {
				novoArray[i] = arrayInterno[i];
			}
			
			arrayInterno = novoArray;
		}
		
		arrayInterno[inseridos] = objeto;
		inseridos++;
	}
	
	public Object pop() throws PilhaVaziaException {
		if(inseridos == 0) {
			throw new PilhaVaziaException("Erro: a pilha está vazia");
		}

		Object retorno = arrayInterno[inseridos - 1];
		arrayInterno[inseridos - 1] = null;
		inseridos--;
		
		return retorno;
	}
	
	public Object top() throws PilhaVaziaException {
		if(inseridos == 0) {
			throw new PilhaVaziaException("Erro: a pilha está vazia");
		}
		return arrayInterno[inseridos - 1];
	}
	
	public int tamanho() {
		return inseridos;
	}
	
}
