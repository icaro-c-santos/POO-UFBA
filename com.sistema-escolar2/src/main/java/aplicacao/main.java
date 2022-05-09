package aplicacao;

import java.util.List;
import java.util.stream.Collectors;

import DAOs.BD;
import DAOs.Dao_Aluno;
import DAOs.Dao_Disciplina;
import DAOs.Dao_Professor;
import DAOs.Dao_Turma;
import Telas.Tela_Inicial_Diretor;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Professor;
import entidades.Turma;

public class main{


	public static void main(String[] args) {
     
		new Dao_Aluno().saveAluno(new Aluno("ICARO SANTOS","01-01-2022","07078332563","ICARO@GMAIL.COM"));
		new Dao_Aluno().saveAluno(new Aluno("CAMILA SANTOS","01-01-2022","17078332563","ICARO@GMAIL.COM"));
		new Dao_Aluno().saveAluno(new Aluno("PAULA SANTOS","01-01-2022","27078332563","ICARO@GMAIL.COM"));
		new Dao_Professor().saveProfessor(new Professor("JOAO PEDRO","01-01-2022","27078332563","ICARO@GMAIL.COM"));
		new Dao_Professor().saveProfessor(new Professor("MARIA JOSE","01-01-2022","27078332563","ICARO@GMAIL.COM"));

		new Dao_Disciplina().saveDisciplina(new Disciplina("MATEMATICA","MUITO LEGAL"));
		new Dao_Disciplina().saveDisciplina(new Disciplina("PORTUGUES","MUITO LEGAL"));
		new Dao_Disciplina().saveDisciplina(new Disciplina("GEOGRAFIA","MUITO LEGAL"));
		new Dao_Turma().saveTurma(new Turma(BD.bdDisciplina.get(0),BD.bdProfessors.get(0)));
		new Dao_Turma().saveTurma(new Turma(BD.bdDisciplina.get(1),BD.bdProfessors.get(0)));

		Tela_Inicial_Diretor.start_tela_diretor(null);
	@SuppressWarnings("unused")
	List<Aluno> list = BD.bdAluno.stream().filter(p -> p.getNome().equalsIgnoreCase("ICARO")).
	    collect(Collectors.toList());
		

	}
	
	
	
	

}
