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
	 * M�todo para inserir objeto na �ltima posi��o do array 
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
	 * Remove o �ltimo item do deque
	 */
	public void removeLast() {
		deque[inseridos - 1] = null;
		inseridos--;
	}

	/**
	 * Remove um item do deque atrav�s do obj passado por par�metro
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
			throw new ItemNaoEncontradoException("Elemento n�o presente no deque");			
		} 
		deque[inseridos - 1] = null;
		inseridos--;
	}
	
	/**
	 * Remove um item do deque atrav�s do obj passado por par�metro
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
			throw new PosicaoNaoEncontradaException("Posi��o n�o presente no deque");			
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
	 * @return Se o deque n�o possui itens inseridos
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
	
	/**
	 * @param posicao 
	 * @return o objeto do deque referente a posi��o informada como par�metro
	 */
	public Object getItem(int posicao) {
		return deque[posicao];
	}
	
}
