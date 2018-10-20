package br.idea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.ILikeContract;
import br.idea.project.entity.Like;
import br.idea.project.repository.LikeRepository;

@Service
public class LikeServiceImpl implements ILikeContract {
	
	@Autowired
	private LikeRepository like_repo;
	public LikeServiceImpl() {
		
	}

	@Override
	public Like salvar(Like like) {
		return this.like_repo.save(like);
	}

	@Override
	public void deletar(Integer post_id, Integer user_id) {
		
		this.like_repo.deleteLikePost(post_id, user_id);
		
	}

	@Override
	public List<Like> listarRegistros() {
		return this.like_repo.findAll();
	}
	
	public Integer getCountLikesPost(Integer id) {
		return this.like_repo.countLikes(id);
	}

	

}
