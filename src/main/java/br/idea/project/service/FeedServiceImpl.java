package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IFeedContract;
import br.idea.project.entity.Feed;
import br.idea.project.repository.FeedRepository;

@Service
public class FeedServiceImpl implements IFeedContract{

	@Autowired
	private FeedRepository repo;
	
	@Override
	public Feed salvar(Feed feed) {
		return this.repo.save(feed);
		
	}

	@Override
	public void deletar(Feed feed) {
		this.repo.delete(feed);
		
	}

	@Override
	public Feed atualizar(Feed feed) {
		return this.repo.save(feed);
	}

	@Override
	public List<Feed> listarRegistros() {
		return this.repo.findAll();
	}

	@Override
	public Feed buscarId(Integer comment_id) {
		Optional<Feed> comment = this.repo.findById(comment_id);
		return comment.orElseThrow(() -> new RuntimeException());
	}
	


}
