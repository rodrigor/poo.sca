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
