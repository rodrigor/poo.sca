/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca;

import java.util.List;
import java.util.LinkedList;

import poo.sca.io.SCAPersistencia;

public class SCAPersistenciaMemoria implements SCAPersistencia {

	private List<Disciplina> disciplinas;
	
	public SCAPersistenciaMemoria(){
		this.disciplinas = new LinkedList<Disciplina>();
	}
	@Override
	public void salvar(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	@Override
	public List<Disciplina> recuperarDisciplinas() {
		return disciplinas;
	}

}
