package br.cesed.si.p3.prova.laboratorio.questao2;

public abstract class SistemaDeVendas {
	
	private String nomeDoProduto;
	private int valorDoProduto;
	private double saldoLoja;
	private double saldoComprador;
	
	public SistemaDeVendas(String nomeDoProduto, int valorDoProduto, double saldoLoja, double saldoComprador) {
		super();
		this.nomeDoProduto = nomeDoProduto;
		this.valorDoProduto = valorDoProduto;
		this.saldoLoja = saldoLoja;
		this.saldoComprador = saldoComprador;
	}

	public SistemaDeVendas(double saldoLoja, double saldoComprador) {
		super();
		this.saldoLoja = saldoLoja;
		this.saldoComprador = saldoComprador;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public int getValorDoProduto() {
		return valorDoProduto;
	}

	public void setValorDoProduto(int valorDoProduto) {
		this.valorDoProduto = valorDoProduto;
	}

	public double getSaldoLoja() {
		return saldoLoja;
	}

	public void setSaldoLoja(double saldoLoja) {
		this.saldoLoja = saldoLoja;
	}

	public double getSaldoComprador() {
		return saldoComprador;
	}

	public void setSaldoComprador(double saldoComprador) {
		this.saldoComprador = saldoComprador;
	}
	
	public abstract void debitar();
	

}
