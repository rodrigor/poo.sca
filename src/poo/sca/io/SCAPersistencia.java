package poo.sca.io;

import java.util.List;

import poo.sca.Disciplina;

public interface SCAPersistencia {

	public void salvar(Disciplina disciplina) throws SCAPersistenciaException;
	public List<Disciplina> recuperarDisciplinas() throws SCAPersistenciaException;

}
