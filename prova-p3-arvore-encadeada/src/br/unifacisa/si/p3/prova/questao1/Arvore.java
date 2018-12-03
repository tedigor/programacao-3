/**
 * 
 */
package br.unifacisa.si.p3.prova.questao1;

/**
 * @author Ted(aluno)
 *
 */
public class Arvore {

	private Node raiz;
	private int qtdFolhas;

	/**
	 * Metódo público para inserir nós a partir da raiz
	 * @param valor
	 */
	public void inserir(int valor) {
		inserir(this.raiz, valor);
	}

	/**
	 * Método para inserir nós na árvore
	 * @param node
	 * @param valor
	 */
	private void inserir(Node node, int valor) {

		// Se a raiz for nula, o nó inserido será a raiz
		if (this.raiz == null) {
			this.raiz = new Node(valor);
		} else {
			// insere no lado esquerdo da árvore se o valor for menor que o nó atual
			if (valor < node.getValor()) {
				if (node.getEsquerda() != null) {
					inserir(node.getEsquerda(), valor);
				} else {
					node.setEsquerda(new Node(valor));
				}
			// insere no lado direito da árvore se o valor for maior que o nó atual
			} else if (valor > node.getValor()) {
				if (node.getDireita() != null) {
					inserir(node.getDireita(), valor);
				} else {

					node.setDireita(new Node(valor));
				}
			}
		}
	}

	/**
	 * Método público para contagem da quantidade de nós da árvore a partir da raiz
	 * @return quantidade de nós da árvore
	 */
	public int getQtdNos() {
		return getQtdNos(raiz);
	}

	/**
	 * Método para contagem dos nós da árvore
	 * @param raiz
	 * @return quantidade de nós da árvore
	 */
	private int getQtdNos(Node raiz) {

		//Se a raiz for nula, a árvore está vazia (não possui nós)
		if (raiz == null) {
			return 0;
		}
		
		//Realiza a contagem de nós do lado esquerdo e direito da árvore (com recursividade)
		int qtdEsquerda = getQtdNos(raiz.getEsquerda());
		int qtdDireita = getQtdNos(raiz.getDireita());

		//É somado 1 para contar a raiz
		return qtdEsquerda + qtdDireita + 1;
	}

	
	
	/**
	 * Método público para contar a quantidade de folhas a partir da raiz da árvore
	 * @return Quantidade de folhas
	 */
	public int getQtdFolhas() {
		return getQtdFolhas(raiz);
	}

	/**
	 * Método para contar a quantidade das folhas da árvore
	 * @param raiz
	 * @return Quantidade de folhas da árvore
	 */
	private int getQtdFolhas(Node raiz) {
		
		//Se a raiz for nula, a árvore está vazia (não possui folhas)
		if (raiz == null) {
			return 0;
		}

		getQtdFolhas(raiz.getEsquerda());
		getQtdFolhas(raiz.getDireita());
		
		// Incrementa o contator quando o nó não possui filhos
		if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
			qtdFolhas++;
		}

		return qtdFolhas;
	}

	/**
	 * Método de percurso pré ordem
	 * @param raiz
	 */
	public void preOrdem(Node raiz) {
		if (raiz != null) {
			System.out.println(raiz.getValor());
			preOrdem(raiz.getEsquerda());
			preOrdem(raiz.getDireita());
		}
	}

	/**
	 * Método de percurso pós ordem
	 * @param raiz
	 */
	public void emOrdem(Node raiz) {
		if (raiz != null) {
			emOrdem(raiz.getEsquerda());
			System.out.println(raiz.getValor());
			emOrdem(raiz.getDireita());
		}
	}

	/**
	 * Método de percurso em ordem
	 * @param raiz
	 */
	public void posOrdem(Node raiz) {
		if (raiz != null) {
			posOrdem(raiz.getEsquerda());
			posOrdem(raiz.getDireita());
			System.out.println(raiz.getValor());
		}
	}

}
