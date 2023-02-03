package est;

public class Estudante {

	protected String nome;
	protected String endereco;
	protected int anoLectivo;
	protected int codigo;

	public Estudante(int codigo, String nome, String endereco, int anoLectivo) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.anoLectivo = anoLectivo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getAnoLectivo() {
		return anoLectivo;
	}

	public void setAnoLectivo(int anoLectivo) {
		this.anoLectivo = anoLectivo;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", endereco=" + endereco + ", anoLectivo=" + anoLectivo + ", codigo="
				+ codigo + "]";
	}

}
