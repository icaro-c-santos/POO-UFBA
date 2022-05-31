package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import daos.BD;


public class Turma {


	private Long id;
	private Disciplina disciplina;
	private Professor professor;
	private Set<Aluno> listAluno = null;
	
	public Turma() {
		this.id = BD.gerarIdTurma();
	}
	
	public Turma(Disciplina disciplina,Professor professor) {
		this.disciplina = disciplina;
		this.professor = professor;
		this.listAluno = new HashSet<Aluno>();
		this.id = BD.gerarIdTurma();
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getListAluno() {
		List<Aluno> list = new ArrayList<Aluno>();
		list.addAll(listAluno);
		return list;
	}
		
	public boolean contemAluno(Long matriculaAluno) {	
		return	listAluno.stream().anyMatch(p-> p.getMatricula()==matriculaAluno);
	}
	
	
	public boolean contemProfessor(Long Codigoprofessor) {
		
		if(this.getProfessor()!=null && this.getProfessor().getCodigo()!=null) {
			return Codigoprofessor== this.getProfessor().getCodigo();
		}
		return false;
	}
	
	public boolean contemDisciplina(Long CodigoDisciplina) {
		
		if(this.getDisciplina()!=null && this.getDisciplina().getCodigo()!=null) {
			return CodigoDisciplina== this.getDisciplina().getCodigo();
		}
		return false;
	}
	
	public void setListAluno(List<Aluno> newLista) {
		if(newLista !=null) {
			this.listAluno.clear();
			this.listAluno.addAll(newLista);
		}
	}

	public boolean addAluno(Aluno Aluno) {
		return this.listAluno.add(Aluno);
	}
	
	public boolean removAluno(Long matricula) {
		this.listAluno.removeIf(p->p.getMatricula()==matricula);
		return true;
	}

	public Long getId() {
		return id;
	}
	
	
	@Override
	public String toString() {
		String professor = " - ";
		String disciplina = " - ";
		String cdProfessor = " - ";
		String cdDisciplina = " - ";
		if(this.getProfessor() != null) {
			if(this.getProfessor().getCodigo() !=null) {
				cdProfessor = ""+this.getProfessor().getCodigo();
			}
			if(this.getProfessor().getNome()!=null) {
				professor = this.getProfessor().getNome();
			}
		}
	
		if(this.getDisciplina() != null) {
			if(this.getDisciplina().getCodigo() !=null) {
				cdDisciplina = ""+this.getDisciplina().getCodigo();
			}
			if(this.getDisciplina().getNome()!=null) {
				disciplina = this.getDisciplina().getNome();
			}
		}
		
		
		return  "CODIGO: "+this.id+"\nDISCIPLINA: "+disciplina+"\nCODIGO DISCIPLINA: "
		+cdDisciplina+"\nPROFESSOR: "+professor+"\nCODIGO DO PROFESSOR: "
		+cdProfessor;
	}
	


	
}
