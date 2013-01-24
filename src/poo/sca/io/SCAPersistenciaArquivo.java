/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import poo.sca.Disciplina;

public class SCAPersistenciaArquivo implements SCAPersistencia {
	
	private PersistenciaArquivoStrategy persistenciaStrategy;
	
	public SCAPersistenciaArquivo(){
		this.persistenciaStrategy = new CSVStrategy();
	}
	
	public void setPersitenciaArquivoStrategy(PersistenciaArquivoStrategy strategy){
		this.persistenciaStrategy = strategy;
	}


	@Override
	public void salvar(Disciplina disciplina) throws SCAPersistenciaException {
		persistenciaStrategy.gravar(disciplina);

	}

	@Override
	public List<Disciplina> recuperarDisciplinas()
			throws SCAPersistenciaException {
		return persistenciaStrategy.recuperarDisciplinas();
	}

}
