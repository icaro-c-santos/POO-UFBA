package daos;

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
	 
	private BD() {
		
	}
	
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
	
	public static List<Turma> bdTurma = new ArrayList<>();
	public static List<Aluno> bdAluno = new ArrayList<>();
	public static List<Disciplina> bdDisciplina = new ArrayList<>();
	public static List<Professor> bdProfessors = new ArrayList<>();
	
}
