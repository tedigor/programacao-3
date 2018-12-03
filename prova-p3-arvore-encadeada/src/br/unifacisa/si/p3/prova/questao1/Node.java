package br.unifacisa.si.p3.prova.questao1;

public class Node {

	private Node esquerda;
	private Node direita;
	private int valor;

	/**
	 * @param esquerda
	 * @param direita
	 * @param valor
	 */
	public Node(int valor) {
		this.esquerda = null;
		this.direita = null;
		this.valor = valor;
	}

	/**
	 * @param esquerda
	 * @param direita
	 * @param valor
	 */
	public Node(Node esquerda, Node direita, int valor) {
		this.esquerda = esquerda;
		this.direita = direita;
		this.valor = valor;
	}

	public void setNull() {
		valor = 0;
		esquerda = null;
		direita = null;
	}

	public Node getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}

	public Node getDireita() {
		return direita;
	}

	public void setDireita(Node direita) {
		this.direita = direita;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
