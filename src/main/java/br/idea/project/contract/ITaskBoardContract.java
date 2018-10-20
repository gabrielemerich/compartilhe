package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.TaskBoard;


public interface ITaskBoardContract {
	
	public TaskBoard salvar(TaskBoard taskboard);

	public void deletar(Integer taskboard_id);
	
	public TaskBoard atualizar(TaskBoard taskboard);
	
	public  List<TaskBoard> listarRegistros();
	
	public TaskBoard buscarId(Integer taskbard_id);
	

}
