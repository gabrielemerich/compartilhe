package br.idea.project.contract;

import java.util.List;

import br.idea.project.entity.Feed;


public interface IFeedContract {
	
	public Feed salvar(Feed feed);

	public void deletar(Feed feed);
	
	public Feed atualizar(Feed feed);
	
	public  List<Feed> listarRegistros();
	
	public Feed buscarId(Integer feed_id);
	

}
