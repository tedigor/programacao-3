package br.cesed.si.p3.prova.laboratorio.questao2;

public final class CompraAvista extends SistemaDeVendas {
	
	public static final double TAXA_DE_DESCONTO = 0.2;
	
	public CompraAvista(String nomeDoProduto, int valorDoProduto, double saldoLoja, double saldoComprador) {
		super(nomeDoProduto, valorDoProduto, saldoLoja, saldoComprador);
	}

	
	public double valorComDesconto() {
		return getValorDoProduto() - (getValorDoProduto() * TAXA_DE_DESCONTO);
	}
	
	@Override
	public void debitar() {
		double novoSaldoLoja = getSaldoLoja() + valorComDesconto();
		double novoSaldoComprador = getSaldoComprador() - valorComDesconto();
 		setSaldoLoja(novoSaldoLoja);
 		setSaldoComprador(novoSaldoComprador);
	}

}
