package aplicacao;

import java.util.List;
import java.util.stream.Collectors;

import Telas.Tela_Inicial_Diretor;
import daos.BD;
import daos.Dao_Aluno;
import daos.Dao_Disciplina;
import daos.Dao_Professor;
import daos.Dao_Turma;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Professor;
import entidades.Turma;

public class main{


	public static void main(String[] args) {
     
		new Dao_Aluno().saveAluno(new Aluno("ICARO SANTOS","01-01-2021","07078332563","ICAROSALNA@GMAIL.COM"));
		new Dao_Aluno().saveAluno(new Aluno("CAMILA SANTOS","01-01-1995","17078372563","CAMILAFEIRA@GMAIL.COM"));
		new Dao_Aluno().saveAluno(new Aluno("PAULA SANTOS","01-01-2022","27078332563","SANTOSPAULA@GMAIL.COM"));
		new Dao_Professor().saveProfessor(new Professor("JOAO PEDRO","01-01-2012","27078342563","PEDROJ@GMAIL.COM"));
		new Dao_Professor().saveProfessor(new Professor("MARIA JOSE","01-01-2021","27078312563","JMARIA@GMAIL.COM"));

		new Dao_Disciplina().saveDisciplina(new Disciplina("MATEMATICA","MUITO LEGAL MESMO"));
		new Dao_Disciplina().saveDisciplina(new Disciplina("PORTUGUES","MAIS OU MENOS"));
		new Dao_Disciplina().saveDisciplina(new Disciplina("GEOGRAFIA","MUITO LEGAL"));
		new Dao_Turma().saveTurma(new Turma(BD.bdDisciplina.get(0),BD.bdProfessors.get(0)));
		new Dao_Turma().saveTurma(new Turma(BD.bdDisciplina.get(1),BD.bdProfessors.get(0)));

		Tela_Inicial_Diretor.start_tela_diretor(null);
	@SuppressWarnings("unused")
	List<Aluno> list = BD.bdAluno.stream().filter(p -> p.getNome().equalsIgnoreCase("ICARO")).
	    collect(Collectors.toList());
		

	}
	
	
	
	

}
