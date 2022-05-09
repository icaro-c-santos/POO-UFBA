package entidades;

public class Pessoa {
	
	private String nome;
	private String nascimento;
	private String cpf;
	private String email;
	
	public Pessoa(){
	}
	
	public Pessoa(String nome, String nascimento, String cpf, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nascimento = nascimento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNascimento()  {
		return this.nascimento;	
	}
	
	public void setNascimento(String data) {
		this.nascimento = data;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
}
