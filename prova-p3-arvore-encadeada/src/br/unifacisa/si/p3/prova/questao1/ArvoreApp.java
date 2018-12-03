package br.unifacisa.si.p3.prova.questao1;

public class ArvoreApp {
	
	public static void main(String[] args) {
		
		Arvore arvore = new Arvore();
		
		arvore.inserir(4);
		arvore.inserir(2);
		arvore.inserir(6);
		arvore.inserir(1);
		arvore.inserir(3);
		arvore.inserir(5);
		arvore.inserir(7);
		
		
		System.out.println(arvore.getQtdNos());
		System.out.println(arvore.getQtdFolhas());
		

	}
}
