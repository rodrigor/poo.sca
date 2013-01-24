package poo.sca.io;

import java.util.List;

import poo.sca.Disciplina;

public interface PersistenciaArquivoStrategy {
	
	public void gravar(Disciplina d)  throws SCAPersistenciaException;
	
	public List<Disciplina> recuperarDisciplinas()  throws SCAPersistenciaException;

}
