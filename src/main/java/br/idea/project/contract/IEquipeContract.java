package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Equipe;


public interface IEquipeContract {
	
	public Equipe salvar(Equipe equipe);

	public void deletar(Integer post_id);
	
	public Equipe atualizar(Equipe equipe);
	
	public  List<Equipe> listarRegistros();
	
	public Equipe buscarId(Integer equipe_id);
	

}
