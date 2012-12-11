package poo.sca.ui;

import java.util.Iterator;

import poo.logger.Logger;
import poo.sca.Disciplina;
import poo.sca.SCAFacade;
import poo.sca.SCARuntimeException;

public class SCA {
	
	private SCAFacade facade;
	
	public SCA(){
		this.facade = new SCAFacade();
	}
	
	public void exibirMenu(){
		StringBuffer menu = new StringBuffer();
		menu.append(">>> SISTEMA DE CONTROLE ACADÊMICO <<<<\n");
		menu.append("    0 - SAIR\n");
		menu.append("    1 - Cadastrar Disciplina\n");
		menu.append("    2 - Listar Disciplinas\n");
		menu.append("Digite a opcao:");
		boolean fim = false;
		do{
			switch(Util.lerInteiro(menu.toString())){
			case 0:
				Util.alert("Até a próxima!");
				fim = true;
				break;
			case 1:
				cadastrarDisciplina();
				break;
			case 2:
				listarDisciplinas();
				break;
			default:
				Util.alert("Opçãoo inválida!");
			}
		}while(!fim);
	}

	

	private void cadastrarDisciplina() {
		String nome = Util.lerString("Digite o nome da disciplina:");
		int codigo = Util.lerInteiro("Digite o código da disciplina:");
		Disciplina d = facade.criarDisciplina(nome,codigo);
		Util.alert("Disciplina criada com sucesso!\n"+d);	
	}
	
	private void listarDisciplinas(){
		StringBuilder msg = new StringBuilder();
		Disciplina disciplina;
		try{
			Iterator<Disciplina> it = facade.getDisciplinasIterator();
			msg.append(">>>> DISCIPLINAS <<<<<\n");
			while(it.hasNext()){
				disciplina = it.next();
				msg.append(disciplina.getCodigo()+"\t| "+disciplina.getNome()+"\n");
			}
		}catch(SCARuntimeException e){
			Logger.getInstance().log(e);
			msg.append("Atenção! Houve um erro ao recuperar as disciplinas.\n");
			msg.append("Por favor ligue para a Microsoft: 0800-8911057\n");
		}
		Util.alert(msg.toString());
	}

	public static void main(String[] args) {
		SCA sca = new SCA();
		sca.exibirMenu();
	}

}
