package br.cesed.si.p3.ed.encadeada.lista;

public class ListaEncadeada {

	private Conta primeiroElemento; //cabe�a
	
	private int inseridos;
	
	public void adicionar(Conta c) {

		if(primeiroElemento == null) {
			primeiroElemento = c;
		} else {

			Conta temp = primeiroElemento;
			
			while(temp.getProximo() != null) {
				temp = temp.getProximo();
			}
			
			//chegou at� o fim da lista
			temp.setProximo(c);
		}
		
		inseridos++;
	}

	public Conta get(int posicao) {
		Conta temp = primeiroElemento;
		
		for (int i = 0; i < posicao; i++) {
			temp = temp.getProximo();
		}
		
		return temp;
	}

	public void remover(Conta c) throws ContaNaoEncontradaException {
		Conta temp = primeiroElemento;
		
		while (temp.getProximo() != c) {
			if (temp.getProximo() == null) {
				throw new ContaNaoEncontradaException("Conta n�o encontrada");
			}
			temp = temp.getProximo();
		}
		
		if(c.getProximo() == null) {
			temp.setProximo(null);
		}else {
			temp.setProximo(c.getProximo());
		}
		
		inseridos--;

	}

	public void remover(int pos) throws PosicaoInvalidaException {
		Conta temp = primeiroElemento;
		
		for (int i = 0; i < pos; i++) {
			if (temp.getProximo() == null) {
				throw new PosicaoInvalidaException("A posi��o informada n�o existe");
			}
			temp = temp.getProximo();
		}
		
		if(temp.getProximo() == null) {
			temp.setProximo(null);
		}else {
			temp.setProximo(temp.getProximo().getProximo());			
		}
		
		inseridos--;
	}
	
	public int tamanho() {
		return inseridos;
	}
	
}
