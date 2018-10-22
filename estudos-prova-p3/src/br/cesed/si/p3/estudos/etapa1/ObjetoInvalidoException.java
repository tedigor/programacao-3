package br.cesed.si.p3.estudos.etapa1;

public class ObjetoInvalidoException extends Exception {
	public ObjetoInvalidoException() {
		super("O objeto não está na lista");
	}
}
