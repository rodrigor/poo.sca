<<<<<<< HEAD
package poo.sca;

import java.util.Iterator;

import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;
import poo.sca.io.SCAPersistenciaException;

public class SCAFacade {
	
	private SCAPersistencia persistencia;
	
	public SCAFacade(){
		persistencia = new SCAPersistenciaArquivo();
	}

	public Disciplina criarDisciplina(String nome, int codigo) {
		Disciplina disciplina = new Disciplina(nome,codigo);
		try {
			persistencia.salvar(disciplina);
		} catch (SCAPersistenciaException e) {
			throw new SCARuntimeException(e);
		}
		return disciplina;
	}

	public Iterator<Disciplina> getDisciplinasIterator() {
		try {
			return persistencia.recuperarDisciplinas().iterator();
		} catch (SCAPersistenciaException e) {
			throw new SCARuntimeException(e);
		}
		
	}

}
=======
package poo.sca; //Pacote

public class SCAFacade {
	
	private SCAPersistencia persistencia;
	
	public SCAFacade(){
		persistencia = new SCAPersistenciaMemoria();
	}

	public Disciplina criarDisciplina(String nome, int codigo) {
		Disciplina disciplina = new Disciplina(nome,codigo);
		persistencia.salvar(disciplina);
		return disciplina;
	}

}
>>>>>>> 11a7c3055c4c9d199312cfbbd6ae3a6f0ea522fa
