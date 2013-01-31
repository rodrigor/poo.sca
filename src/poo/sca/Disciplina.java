/**
 * Universidade Federal da Paraíba - Campus IV
 * Cursos: Sistemas de Informação / Lic. em Ciência da Computação
 * Prof.: Rodrigo Rebouças de Almeida (http://rodrigor.com)
 */

package poo.sca;

public class Disciplina {
	
	private String nome;
	private int codigo;
	
	
	public Disciplina(){
		this.nome = "";
		this.codigo = 0;
	}
	public Disciplina(String nome, int codigo){
		this.setNome(nome);
		this.setCodigo(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome == null || nome.equals(""))
			throw new SCARuntimeException("Nome inválido: '"+nome+"'");
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if(codigo <= 0 || codigo >= 99999)
			throw new SCARuntimeException("Código inválido: "+codigo);
		this.codigo = codigo;
	}
	
	public String toString(){
		StringBuffer str = new StringBuffer();
		str.append(">>> Disciplina\n");
		str.append("Nome:\t\t"+this.nome+"\n");
		str.append("Codigo:\t\t"+this.codigo+"\n");
		return str.toString();
	}
	
	@Override 
	public boolean equals(Object d){
		if(!(d instanceof Disciplina)) return false;
		return this.codigo == ((Disciplina)d).codigo;
	}
	
	@Override
	public int hashCode() {
        int result = 34;
        result = 54 * result + codigo;
        result = 31 * result + nome.hashCode();
        return result;
}

}
