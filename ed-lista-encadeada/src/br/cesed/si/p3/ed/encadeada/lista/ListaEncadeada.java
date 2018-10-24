package br.cesed.si.p3.ed.encadeada.lista;

public class ListaEncadeada {

	private Conta primeiroElemento; //cabeça
	
	private int inseridos;
	
	/**
	 * Adiciona um item à lista encadeada
	 * @param c
	 */
	public void adicionar(Conta c) {

		if(primeiroElemento == null) {
			primeiroElemento = c;
		} else {

			Conta temp = primeiroElemento;
			
			while(temp.getProximo() != null) {
				temp = temp.getProximo();
			}
			
			//chegou até o fim da lista
			temp.setProximo(c);
		}
		
		inseridos++;
	}

	/**
	 * @param posicao
	 * @return O objeto da posição passada como parâmetro
	 * @throws PosicaoInvalidaException
	 */
	public Conta get(int posicao) throws PosicaoInvalidaException {
		Conta temp = primeiroElemento;
		
		
		
		for (int i = 0; i < posicao; i++) {
			if (temp.getProximo() == null) {
				throw new PosicaoInvalidaException("A posição informada não existe");
			}
			temp = temp.getProximo();
		}
		
		return temp;
	}

	/**
	 * Remove o objeto passado como parametro da lista encadeada.
	 * @param c
	 * @throws ContaNaoEncontradaException
	 */
	public void remover(Conta c) throws ContaNaoEncontradaException {
		Conta temp = primeiroElemento;
		
		if(c.equals(temp)) {
			primeiroElemento = temp.getProximo();
		}else {
			while (!temp.getProximo().equals(c)) {
				if (temp.getProximo() == null) {
					throw new ContaNaoEncontradaException("Conta não encontrada");
				}
				temp = temp.getProximo();
			}
			if(c.getProximo() == null) {
				temp.setProximo(null);
			}else {
				temp.setProximo(c.getProximo());
			}
		}
		inseridos--;
	}

	/**
	 * Remover item da lista encadeada por posição
	 * @param pos
	 * @throws PosicaoInvalidaException
	 */
	public void remover(int pos) throws PosicaoInvalidaException {
		Conta temp = primeiroElemento;
		
		if(pos == 0) {
			primeiroElemento = temp.getProximo();
		}else {
			for (int i = 0; i < pos; i++) {
				if (pos > inseridos - 1 || pos < 0) {
					throw new PosicaoInvalidaException("A posição informada não existe");
				}
				temp = temp.getProximo();
			}
			
			if(temp.getProximo() == null) {
				temp.setProximo(null);
			}else {
				temp.setProximo(temp.getProximo().getProximo());			
			}		
		}
		inseridos--;
	}
	
	/**
	 * @return Tamanho da lista encadeada
	 */
	public int tamanho() {
		return inseridos;
	}
	
}
