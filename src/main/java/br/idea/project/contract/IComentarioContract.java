package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Comentario;


public interface IComentarioContract {
	
	public Comentario salvar(Comentario comment);

	public void deletar(Comentario comment);
	
	public Comentario atualizar(Comentario comment);
	
	public  List<Comentario> listarRegistros();
	
	public Comentario buscarId(Integer comment_id);
	

}
