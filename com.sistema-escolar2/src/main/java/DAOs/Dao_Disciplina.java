package DAOs;

import java.util.List;
import java.util.stream.Collectors;

import entidades.Disciplina;

public class Dao_Disciplina{
	
	
	public Dao_Disciplina() {
		
	}
	
	public Long saveDisciplina(Disciplina disciplina){
		BD.bdDisciplina.add(disciplina);
		return disciplina.getCodigo();
	}

	public boolean updateDisciplinar(Disciplina disciplinaParameter){
		
		disciplinaParameter.getCodigo();
		BD.bdDisciplina.stream().filter(a -> a.getCodigo()==disciplinaParameter.getCodigo()).
			collect(Collectors.toList()).forEach(p ->{
			p.setDescricao(disciplinaParameter.getDescricao());
			p.setNome(disciplinaParameter.getNome());
		});
	    return true;
	}
	
	public List<Disciplina> getAll(){
		return BD.bdDisciplina;
	}


	public List<Disciplina> getDisciplinaNome(String nome){
		  return BD.bdDisciplina.stream().filter(p -> p.getNome().contains(nome)).
				    collect(Collectors.toList());
	}
	
	public Disciplina getDisciplinaCodigo(Long codigo){
		List<Disciplina> list = BD.bdDisciplina.stream().filter(p -> p.getCodigo()== codigo).collect(Collectors.toList());
		if(list.isEmpty()) { return null;}	
		return list.get(0);	
	}

	public boolean deleteDisciplina(Long codigo) {
		
		Dao_Turma dao_turma = new Dao_Turma();
		dao_turma.getAll().forEach(p -> {
			if(p.getDisciplina() !=null && p.getDisciplina().getCodigo()!=null && p.getDisciplina().getCodigo() ==codigo) {
				p.setDisciplina(null);
			}
		});
		return BD.bdDisciplina.removeIf(p -> p.getCodigo() == codigo);
	}
	
}
