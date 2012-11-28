package poo.sca;

import java.util.List;

public interface SCAPersistencia {

	public void salvar(Disciplina disciplina);
	public List<Disciplina> recuperarDisciplinas();

}
