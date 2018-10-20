package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Usuario;

public interface IUsuarioContract {

	public Usuario salvar(Usuario user);

	public void deletar(Usuario user);
	
	public Usuario atualizar(Usuario user);
	
	public  List<Usuario> listarRegistros();
	
	public Usuario buscarId(Integer userid);
	
}
