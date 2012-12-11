/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca.ui;

public class EntradaInvalidaException extends RuntimeException {
	
	public EntradaInvalidaException(){
		super();
	}
	
	public EntradaInvalidaException(String msg){
		super(msg);
	}

	public EntradaInvalidaException(Throwable e) {
		super(e);
	}

	public EntradaInvalidaException(String entrada, Throwable e) {
		super(entrada,e);
	}

}
