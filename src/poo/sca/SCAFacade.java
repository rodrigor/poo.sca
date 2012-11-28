package poo.sca;

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
