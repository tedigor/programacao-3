package br.cesed.si.p3.prova.laboratorio.questao1;

public class ListaSequencial {

	private static final int TAMANHO_INICIAL = 3;
	private static final int FATOR_DE_SOMA = 8;
	private static final int VALOR_MAXIMO = 80;
	private static final int TAMANHO_LIMITE = 100;
	private Object[] lista = new Object[TAMANHO_INICIAL];
	int inseridos;

	public void addItem(Object item) throws ListaLotadaException {
		if (lista.length == 100) {
			throw new ListaLotadaException();
		}

		if (inseridos == lista.length) {
			if (lista.length == VALOR_MAXIMO) {

				Object[] novoArray = new Object[TAMANHO_LIMITE];
				for (int i = 0; i < lista.length; i++) {
					novoArray[i] = lista[i];
				}
				lista = novoArray;
			} else {

				Object[] novoArray = new Object[(lista.length * 2) + FATOR_DE_SOMA];
				for (int i = 0; i < lista.length; i++) {
					novoArray[i] = lista[i];
				}
				lista = novoArray;
			}
		}

		lista[inseridos] = item;
		inseridos++;
	}
}
