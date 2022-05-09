package DAOs;


import java.util.List;
import java.util.stream.Collectors;

import entidades.Professor;


public class Dao_Professor {
	

	
	public Long saveProfessor(Professor professor){
		
		BD.bdProfessors.add(professor);
		return professor.getCodigo();
	
	}
	
	public boolean updateProfessor(Professor professorParameter){
		
			BD.bdAluno.stream().filter(a -> a.getMatricula()==professorParameter.getCodigo()).
			collect(Collectors.toList()).forEach(p ->{
				p.setCpf(professorParameter.getCpf());
				p.setEmail(professorParameter.getEmail());
				p.setNascimento(professorParameter.getNascimento());
				p.setNome(professorParameter.getNome());
			});
	    return true;
}
	
	public List<Professor> getAll(){
		
		return BD.bdProfessors;
	}

	public List<Professor> getProfessorNome(String nome){
		 return BD.bdProfessors.stream().filter(p -> p.getNome().contains(nome)).
				    collect(Collectors.toList());
	}
	

	public List<Professor> getProfessorCpf(String cpf){
		return BD.bdProfessors.stream().filter(p -> p.getCpf().equalsIgnoreCase(cpf)).
				  collect(Collectors.toList());
	}
	
	public Professor getProfessorMatricula(Long codigo){
		List<Professor> list = BD.bdProfessors.stream().filter(p -> p.getCodigo()== codigo).collect(Collectors.toList());
		if(list.isEmpty()) { return null;}	
		return list.get(0);	
	}

	public boolean deleteProfessor(Long codigo) {
		
		Dao_Turma dao_turma = new Dao_Turma();
		dao_turma.getAll().forEach(p -> {
			if(p.getProfessor() !=null && p.getProfessor().getCodigo()!=null && p.getProfessor().getCodigo() ==codigo) {
				p.setProfessor(null);
			}
		});
		return BD.bdProfessors.removeIf(p -> p.getCodigo() == codigo);
	}
	
}


