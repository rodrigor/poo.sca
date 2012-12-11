package poo.sca;

import poo.sca.io.SCAPersistenciaException;

public class SCARuntimeError extends RuntimeException {

	public SCARuntimeError(SCAPersistenciaException e) {
		super(e);
	}

}
