package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Like;

public interface ILikeContract {
	
	public Like salvar(Like like);

	public void deletar(Integer post_id, Integer user_id);
	
	public  List<Like> listarRegistros();
	
	
}
