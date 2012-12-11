/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca.io;

import java.util.List;

import poo.sca.Disciplina;

public interface SCAPersistencia {

	public void salvar(Disciplina disciplina) throws SCAPersistenciaException;
	public List<Disciplina> recuperarDisciplinas() throws SCAPersistenciaException;

}
