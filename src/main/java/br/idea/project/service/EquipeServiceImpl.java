package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IEquipeContract;
import br.idea.project.entity.Equipe;
import br.idea.project.repository.EquipeRepository;
import br.idea.project.repository.TaskBoardRepository;
import br.idea.project.service.exception.ObjectNotFound;

@Service
public class EquipeServiceImpl implements IEquipeContract {
	
	@Autowired
	private EquipeRepository equipe_repo;
	
	@Autowired
	private TaskBoardRepository task_repo;
	
	public EquipeServiceImpl() {
		
	}

	@Override
	public Equipe salvar(Equipe equipe) {
		return equipe_repo.save(equipe);
	}

	@Override
	public void deletar(Integer equipe_id) {
		equipe_repo.deleteById(equipe_id);
		task_repo.deleteTaskBoardByEquipeId(equipe_id);
		
	}

	@Override
	public Equipe atualizar(Equipe equipe) {
		return equipe_repo.save(equipe);
	}

	@Override
	public List<Equipe> listarRegistros() {
		return equipe_repo.findAll();
	}

	public List<Equipe> listarEquipeUser(Integer id){
		return this.equipe_repo.getUsersEquipes(id);
	}
	
	@Override
	public Equipe buscarId(Integer equipe_id) {
		Optional<Equipe> equipe = this.equipe_repo.findById(equipe_id);
		return equipe.orElseThrow(() -> new ObjectNotFound("Objeto "+ equipe_id +" não encontrado!"));
	}

}
