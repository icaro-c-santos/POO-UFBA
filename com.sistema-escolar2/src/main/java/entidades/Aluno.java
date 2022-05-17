package entidades;

import DAOs.BD;

public class Aluno extends Pessoa{
	

	private Long matricula;
	public Aluno(){
		this.matricula = BD.gerarIdAluno();
	}
	public Aluno(String nome, String nascimento, String cpf,String email) {
		super(nome, nascimento, cpf,email);
		this.matricula = BD.gerarIdAluno();
	}
	
	public Long getMatricula() {
		return matricula;
	}
	
	public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Aluno outroAluno = (Aluno) obj;
        if(this.getMatricula()==outroAluno.getMatricula()) {
        	return true;
        }
        return false;
    }
	
	public int hashCode() {
		return this.getCpf().hashCode();
	}
	
	public String toString() {
		return "Nome: "+getNome()+"\nNascimento: "+getNascimento()+"\nCpf: "+getCpf()+"\nEmail: "+getEmail() +"\nMatricula: "+getMatricula()+"\n";
	}
	
	public String toStringDisplay() {
		return "|| Nome: "+getNome()+"     ||Nascimento: "+getNascimento()+"      ||Cpf: "+getCpf()+" ||Email: "+getEmail() +" ||Matricula: "+getMatricula()+"";

	}

}
