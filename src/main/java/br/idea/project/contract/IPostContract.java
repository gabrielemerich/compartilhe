package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Post;

public interface IPostContract {
	
	public Post salvar(Post post);

	public void deletar(Integer post_id);
	
	public Post atualizar(Post post);
	
	public  List<Post> listarRegistros();
	
	public Post buscarId(Integer postid);
}
