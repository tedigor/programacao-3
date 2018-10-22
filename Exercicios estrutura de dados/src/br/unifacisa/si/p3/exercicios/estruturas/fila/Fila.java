package br.unifacisa.si.p3.exercicios.estruturas.fila;

public class Fila {

	private int inseridos;

	private static final int ALOCACAO_INICIAL = 3;

	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];

	public void enqueue(Object item) throws EstadoInvalidoException {

		if(item == null) {
			throw new EstadoInvalidoException("O item não pode ser nulo");
		}
		
		if (inseridos == arrayInterno.length) {

			aumentarArray();
		}

		arrayInterno[inseridos] = item;
		inseridos++;
	}

	/**
	 * Aumenta o arrayInterno
	 */
	private void aumentarArray() {
		Object[] novo = new Object[arrayInterno.length * 2];

		for (int i = 0; i < arrayInterno.length; i++) {
			novo[i] = arrayInterno[i];
		}

		arrayInterno = novo;
	}

	public Object dequeue() throws FilaVaziaException {
		
		if(inseridos == 0) {
			throw new FilaVaziaException("Lista vazia, adicione um objeto para realizar a ação");
		}

		Object retorno = arrayInterno[0];

		if (inseridos > 0) {

			for (int i = 0; i < inseridos - 1; i++) {
				arrayInterno[i] = arrayInterno[i + 1];
			}

			inseridos--;
			arrayInterno[inseridos] = null;
		}

		return retorno;
	}

	public Object front() throws FilaVaziaException {
		
		if(inseridos == 0) {
			throw new FilaVaziaException("Lista vazia, adicione um objeto para realizar a ação");
		}
		return arrayInterno[0];
	}

	public int tamanho() {
		return inseridos;
	}

	public boolean isEmpty() {
		return inseridos == 0;
	}

}
