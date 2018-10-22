package br.cesed.si.p3.prova.laboratorio.questao2;

public final class CompraParcelada extends SistemaDeVendas {

	public int parcelas;
	
	public CompraParcelada(String nomeDoProduto, int valorDoProduto, double saldoLoja, double saldoComprador) {
		super(nomeDoProduto, valorDoProduto, saldoLoja, saldoComprador);
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	
	public double valorDaParcela() {
		return getValorDoProduto()/this.parcelas; 
	}
	
	
	@Override
	public void debitar() {
		double novoSaldoLoja = getSaldoLoja() + valorDaParcela();
		double novoSaldoComprador = getSaldoComprador() - valorDaParcela();
 		setSaldoLoja(novoSaldoLoja);
 		setSaldoComprador(novoSaldoComprador); 
	}
}
