package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.ITaskBoardContract;
import br.idea.project.entity.TaskBoard;
import br.idea.project.repository.TaskBoardRepository;
import br.idea.project.service.exception.ObjectNotFound;

@Service
public class TaskBoardServiceImpl implements ITaskBoardContract {
	
	@Autowired
	private TaskBoardRepository taskboard_repo;
	
	public TaskBoardServiceImpl() {
		
	}

	@Override
	public TaskBoard salvar(TaskBoard taskboard) {
		return taskboard_repo.save(taskboard);
	}

	@Override
	public void deletar(Integer taskboard_id) {
		taskboard_repo.deleteById(taskboard_id);;
		
	}

	@Override
	public TaskBoard atualizar(TaskBoard taskboard) {
		return taskboard_repo.save(taskboard);
	}

	@Override
	public List<TaskBoard> listarRegistros() {
		return taskboard_repo.findAll();
	}

	public List<TaskBoard> listByEquipe(Integer id){
		return taskboard_repo.listTaskBoardEquipe(id);
	}
	@Override
	public TaskBoard buscarId(Integer taskboard_id) {
		Optional<TaskBoard> taskboard = this.taskboard_repo.findById(taskboard_id);
		return taskboard.orElseThrow(() -> new ObjectNotFound("Objeto "+ taskboard_id +" não encontrado!"));
	}

}
