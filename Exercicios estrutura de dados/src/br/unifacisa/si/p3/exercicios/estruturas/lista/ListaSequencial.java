package br.unifacisa.si.p3.exercicios.estruturas.lista;

public class ListaSequencial {

	private static final int ALOCACAO_INICIAL = 3;

	private Object[] arrayInterno = new Object[ALOCACAO_INICIAL];

	private int inseridos;

	public void adicionar(Object item) throws EstadoInvalidoException {

		if (inseridos == arrayInterno.length) {

			Object[] novo = new Object[arrayInterno.length * 2];

			for (int i = 0; i < arrayInterno.length; i++) {
				novo[i] = arrayInterno[i];
			}

			arrayInterno = novo;
		}

		arrayInterno[inseridos] = item;
		inseridos++;
	}

	public void adicionar(Object item, int posicao) throws EstadoInvalidoException {

	}

	public Object obter(int indice) {
		return arrayInterno[indice];
	}

	public void remover(Object item) throws PosicaoInvalidaException {

		int posicaoEncontrada = -1;

		if (item != null) {

			for (int i = 0; i < arrayInterno.length; i++) {
				if (item.equals(arrayInterno[i])) {
					posicaoEncontrada = i;
					break;
				}
			}

			if(posicaoEncontrada != -1) {
				remover(posicaoEncontrada);
			}
		}
	}

	public void remover(int posicao) throws PosicaoInvalidaException {

		if (posicao < 0 || posicao >= inseridos) {
			throw new PosicaoInvalidaException("Posi��o inv�lida");
		}

		for (int i = posicao; i < inseridos - 1; i++) {
			arrayInterno[i] = arrayInterno[i + 1];
		}

		arrayInterno[inseridos - 1] = null;
		inseridos--;
	}

	public boolean isEmpty() {
		return inseridos == 0;
	}

	public void limpar() {
		arrayInterno = new Object[ALOCACAO_INICIAL];
	}

	public int tamanho() {
		return inseridos;
	}
}
