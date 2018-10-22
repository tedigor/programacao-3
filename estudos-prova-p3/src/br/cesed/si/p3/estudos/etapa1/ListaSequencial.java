/**
 * 
 */
package br.cesed.si.p3.estudos.etapa1;

/**
 * @author ted
 *
 */
public class ListaSequencial {

	private static final int TAMANHO_INICIAL = 3;

	private Object[] lista = new Object[TAMANHO_INICIAL];

	private int inseridos;

	/**
	 * 
	 * @param item
	 */
	public void adicionarItens(Object item) throws EstadoIvalidoException {

		if (item == null) {
			throw new EstadoIvalidoException();
		}

		if (inseridos == lista.length) {
			aumentarLista();
		}

		lista[inseridos] = item;
		inseridos++;
	}

	/**
	 * Aumenta tamanho da lista inicial
	 */
	public void aumentarLista() {
		Object[] novoArray = new Object[lista.length * 2];
		for (int i = 0; i < lista.length; i++) {
			novoArray[i] = lista[i];
		}
		lista = novoArray;
	}

	public void adicionarItens(Object item, int posicao) throws EstadoIvalidoException, PosicaoInvalidaException {

		if (item == null) {
			throw new EstadoIvalidoException();
		}

		if (posicao < 0 || posicao > lista.length - 1) {
			throw new PosicaoInvalidaException();
		}

		if (inseridos == lista.length || posicao == lista.length - 1) {
			aumentarLista();
		}

		if (lista[posicao] != null) {
			for (int i = inseridos - 1; i >= posicao; i--) {
				lista[i + 1] = lista[i];
			}

		}

		lista[posicao] = item;
		inseridos++;
	}

	public void remover(int posicao) throws PosicaoInvalidaException {
		if (posicao < 0 || posicao >= inseridos) {
			throw new PosicaoInvalidaException();
		}

		for (int i = posicao; i < inseridos - 1; i++) {
			lista[i] = lista[i + 1];
		}

		lista[inseridos - 1] = null;
		inseridos--;
	}

	public void remover(Object item) throws PosicaoInvalidaException, ObjetoInvalidoException {

		int posicaoEncontrada = -1;

		if (item != null) {

			for (int i = 0; i < lista.length; i++) {
				if (item.equals(lista[i])) {
					posicaoEncontrada = i;
					break;
				}
			}

			if (posicaoEncontrada != -1) {
				remover(posicaoEncontrada);
			}
		}
	}

	public Object obter(int posicao) {
		return lista[posicao];
	}

	public void limpar() {
		lista = new Object[TAMANHO_INICIAL];
	}
	
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
	public int tamanho() {
		return inseridos;
	}
}
