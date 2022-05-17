package DAOs;

import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Professor;
import entidades.Turma;



public class BD {
	
	 private static Long idAluno =1l;
	private static Long idProfessor=1l;
	 private static Long idTumra=1l;
	private static Long idDisciplina=1l;
	 
	public static Long gerarIdAluno() {
		return idAluno++;
	}
	
	
	
	public static Long gerarIdTurma() {
		return idTumra++;
	}
	
	public static Long gerarIdDisciplina() {
		return idDisciplina++;
	}
	
	public static Long gerarIdProfessor() {
		return idProfessor++;
	}
	
	final public static List<Turma> bdTurma = new ArrayList<>();
	final public static List<Aluno> bdAluno = new ArrayList<Aluno>();
	final public static List<Disciplina> bdDisciplina = new ArrayList<>();
	final public static List<Professor> bdProfessors = new ArrayList<>();
	
}
