package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Perfil;


public interface IPerfilContract {
	
	public Perfil salvar(Perfil perfil);

	public void deletar(Perfil perfil);
	
	public Perfil atualizar(Perfil perfil);
	
	public  List<Perfil> listarRegistros();
	
	public Perfil buscarId(Integer perfil_id);
	

}
