package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IComentarioContract;
import br.idea.project.entity.Comentario;
import br.idea.project.repository.ComentarioRepository;

@Service
public class CommentServiceImpl implements IComentarioContract{

	@Autowired
	private ComentarioRepository repo;
	
	@Override
	public Comentario salvar(Comentario comment) {
		return this.repo.save(comment);
		
	}

	@Override
	public void deletar(Comentario comment) {
		this.repo.delete(comment);
		
	}

	@Override
	public Comentario atualizar(Comentario comment) {
		return this.repo.save(comment);
	}

	@Override
	public List<Comentario> listarRegistros() {
		return this.repo.findAll();
	}

	@Override
	public Comentario buscarId(Integer comment_id) {
		Optional<Comentario> comment = this.repo.findById(comment_id);
		return comment.orElseThrow(() -> new RuntimeException());
	}
	
	public List<Comentario> buscarPostId(Integer id) {
		return this.repo.findByPostId(id);
		
	}

}
