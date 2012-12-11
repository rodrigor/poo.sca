/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

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

	public Disciplina criarDisciplina(String nome, int codigo) throws SCAException {
		if(existeDisciplina(codigo)){
			throw new SCAException("Já existe uma disciplina com o código '"+codigo+"'");
		}
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
	
	private boolean existeDisciplina(int codigo){
		Iterator<Disciplina> it = getDisciplinasIterator();
		while(it.hasNext()){
			if(it.next().getCodigo() == codigo) return true;
		}
		return false;
	}

}