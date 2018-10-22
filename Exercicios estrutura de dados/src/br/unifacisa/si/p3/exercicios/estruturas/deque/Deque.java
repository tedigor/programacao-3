/**
 * 
 */
package br.unifacisa.si.p3.exercicios.estruturas.deque;

/**
 * @author ted
 *
 */
public class Deque {
	
	private static final int TAMANHO_INICIAL = 3;
	private Object[] deque = new Object[TAMANHO_INICIAL];
	private int inseridos;
	
	/**
	 * Inserir elementos no inicio do deque
	 * @param obj objeto a ser inserido
	 */
	public void insertFirst(Object obj) {
		if (inseridos == deque.length) {
			aumentarArray();
		}
		if(inseridos > 0) {
			int aux = inseridos;
			for (int i = 0; i < inseridos; i++) {
				deque[aux] = deque[aux - 1];
				aux--;
			}
		}
		deque[0] = obj;
		inseridos++;
	}
	
	/**
	 * Método para inserir objeto na última posição do array 
	 * @param obj objeto a ser inserido
	 */
	public void insertLast(Object obj) {
		if (inseridos == deque.length) {
			aumentarArray();
		}
		deque[inseridos] = obj;
		inseridos++;
	}
	
	/**
	 * Remove o primeiro item do deque
	 */
	public void removeFirst() {
		for (int i = 0; i < inseridos - 1; i++) {
			deque[i] = deque[i + 1];
		}
		deque[inseridos - 1] = null;
		inseridos--;
	}
	
	/**
	 * Remove o último item do deque
	 */
	public void removeLast() {
		deque[inseridos - 1] = null;
		inseridos--;
	}

	/**
	 * Remove um item do deque através do obj passado por parâmetro
	 * @param obj
	 * @throws ItemNaoEncontradoException
	 */
	public void removeByValue(Object obj) throws ItemNaoEncontradoException {

		boolean removeu = false; 
		for (int i = 0; i < deque.length - 1; i++) {
			if(deque[i] == obj && !removeu) {
				deque[i] = null;
				removeu = true;
			}
			if(removeu) {
				deque[i] = deque[i + 1];
			}
		}
		if(!removeu) {
			throw new ItemNaoEncontradoException("Elemento não presente no deque");			
		} 
		deque[inseridos - 1] = null;
		inseridos--;
	}
	
	/**
	 * Remove um item do deque através do obj passado por parâmetro
	 * @param obj
	 * @throws ItemNaoEncontradoException
	 */
	public void removeByIndex(int index) throws PosicaoNaoEncontradaException {

		boolean removeu = false; 
		for (int i = 0; i < deque.length - 1; i++) {
			if(i == index && !removeu) {
				deque[i] = null;
				removeu = true;
			}
			if(removeu) {
				deque[i] = deque[i + 1];
			}
		}
		if(!removeu) {
			throw new PosicaoNaoEncontradaException("Posição não presente no deque");			
		} 
		deque[inseridos - 1] = null;
		inseridos--;
	}
	
	/**
	 * Aumenta o tamanho do deque para o dobro do atual  
	 */
	private void aumentarArray() {
		Object[] novoArray = new Object[deque.length * 2];
		for (int i = 0; i < deque.length; i++) {
			novoArray[i] = deque[i];
		}
		deque = novoArray;
	}
	
	
	/**
	 * @return a quantidade de elementos presentes no deque
	 */
	public int size() {
		return inseridos;
	}
	
	/**
	 * @return Se o deque não possui itens inseridos
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
	
	/**
	 * @param posicao 
	 * @return o objeto do deque referente a posição informada como parâmetro
	 */
	public Object getItem(int posicao) {
		return deque[posicao];
	}
	
}
