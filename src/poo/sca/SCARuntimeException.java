/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca;

import poo.sca.io.SCAPersistenciaException;

public class SCARuntimeException extends RuntimeException {

	public SCARuntimeException(SCAPersistenciaException e) {
		super(e);
	}
	
	public SCARuntimeException(String msg){
		super(msg);
	}

}
