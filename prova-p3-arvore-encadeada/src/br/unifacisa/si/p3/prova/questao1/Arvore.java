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
	 * Met�do p�blico para inserir n�s a partir da raiz
	 * @param valor
	 */
	public void inserir(int valor) {
		inserir(this.raiz, valor);
	}

	/**
	 * M�todo para inserir n�s na �rvore
	 * @param node
	 * @param valor
	 */
	private void inserir(Node node, int valor) {

		// Se a raiz for nula, o n� inserido ser� a raiz
		if (this.raiz == null) {
			this.raiz = new Node(valor);
		} else {
			// insere no lado esquerdo da �rvore se o valor for menor que o n� atual
			if (valor < node.getValor()) {
				if (node.getEsquerda() != null) {
					inserir(node.getEsquerda(), valor);
				} else {
					node.setEsquerda(new Node(valor));
				}
			// insere no lado direito da �rvore se o valor for maior que o n� atual
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
	 * M�todo p�blico para contagem da quantidade de n�s da �rvore a partir da raiz
	 * @return quantidade de n�s da �rvore
	 */
	public int getQtdNos() {
		return getQtdNos(raiz);
	}

	/**
	 * M�todo para contagem dos n�s da �rvore
	 * @param raiz
	 * @return quantidade de n�s da �rvore
	 */
	private int getQtdNos(Node raiz) {

		//Se a raiz for nula, a �rvore est� vazia (n�o possui n�s)
		if (raiz == null) {
			return 0;
		}
		
		//Realiza a contagem de n�s do lado esquerdo e direito da �rvore (com recursividade)
		int qtdEsquerda = getQtdNos(raiz.getEsquerda());
		int qtdDireita = getQtdNos(raiz.getDireita());

		//� somado 1 para contar a raiz
		return qtdEsquerda + qtdDireita + 1;
	}

	
	
	/**
	 * M�todo p�blico para contar a quantidade de folhas a partir da raiz da �rvore
	 * @return Quantidade de folhas
	 */
	public int getQtdFolhas() {
		return getQtdFolhas(raiz);
	}

	/**
	 * M�todo para contar a quantidade das folhas da �rvore
	 * @param raiz
	 * @return Quantidade de folhas da �rvore
	 */
	private int getQtdFolhas(Node raiz) {
		
		//Se a raiz for nula, a �rvore est� vazia (n�o possui folhas)
		if (raiz == null) {
			return 0;
		}

		getQtdFolhas(raiz.getEsquerda());
		getQtdFolhas(raiz.getDireita());
		
		// Incrementa o contator quando o n� n�o possui filhos
		if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
			qtdFolhas++;
		}

		return qtdFolhas;
	}

	/**
	 * M�todo de percurso pr� ordem
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
	 * M�todo de percurso p�s ordem
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
	 * M�todo de percurso em ordem
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
