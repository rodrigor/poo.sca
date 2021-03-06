package poo.sca.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import poo.sca.Disciplina;

public class CSVStrategy implements PersistenciaArquivoStrategy {
	

	private File disciplinaFile;

	public CSVStrategy() {
		disciplinaFile = new File(dataDir.getPath() + "/disciplina.ser");
	}


	private static File dataDir;
	static {
		URL url = SCAPersistenciaArquivo.class.getResource("/");
		File classesDir = new File(url.getPath());
		dataDir = new File(classesDir.getParentFile().getPath() + "/data");

		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
	}

	@Override
	public void gravar(Disciplina disciplina) throws SCAPersistenciaException {
		StringBuilder line = new StringBuilder();
		line.append(disciplina.getCodigo() + ";" + disciplina.getNome() + "\n");
		try {
			FileWriter out = new FileWriter(disciplinaFile, true);
			out.write(line.toString());
			out.close();
		} catch (IOException e) {
			throw new SCAPersistenciaException(e);
		}

	}

	@Override
	public List<Disciplina> recuperarDisciplinas() throws SCAPersistenciaException {
		List<Disciplina> disciplinas = new LinkedList<Disciplina>();
		if (!disciplinaFile.exists())
			return disciplinas;

		FileInputStream in;
		int nlinha = 0;
		try {
			in = new FileInputStream(disciplinaFile);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			String linha;
			while ((linha = reader.readLine()) != null) {
				nlinha++;
				StringTokenizer tokens = new StringTokenizer(linha,";");
				if(tokens.countTokens() != 2)
					throw new SCAPersistenciaException("Erro no formato do arquivo!\n Arquivo: "+disciplinaFile.toString()+"\n Linha: "+nlinha);
				Disciplina disc = new Disciplina();
				disc.setCodigo(Integer.parseInt(tokens.nextToken()));
				disc.setNome(tokens.nextToken());
				disciplinas.add(disc);
			}
			reader.close();
		} catch (Exception e) {
			throw new SCAPersistenciaException("Erro ao ler o arquivo "+disciplinaFile.toString()+", na linha:"+nlinha,e);
		}
		return disciplinas;
	}

}
