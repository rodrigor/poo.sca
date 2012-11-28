package poo.sca;

import java.util.List;
import java.util.LinkedList;

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
