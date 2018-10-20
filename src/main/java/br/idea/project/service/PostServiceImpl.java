package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IPostContract;
import br.idea.project.entity.Categoria;
import br.idea.project.entity.Post;
import br.idea.project.repository.CategoriaRepository;
import br.idea.project.repository.PostRepository;
import br.idea.project.security.UsuarioSecurity;
import br.idea.project.service.exception.AuthException;
import br.idea.project.service.exception.ObjectNotFound;

@Service
public class PostServiceImpl implements IPostContract {
	
	@Autowired
	private PostRepository post_repo;
	
	@Autowired
	private CategoriaRepository categoria_repo;
	
	public PostServiceImpl() {
		
	}

	@Override
	public Post salvar(Post post) {
		UsuarioSecurity us = UsuarioServiceImpl.UsuarioLogado();
		if(us == null) {
			throw new AuthException("Acesso Negado");
		}
		post.getPost_usuario().setId(us.getId());
		return post_repo.save(post);
	}

	@Override
	public void deletar(Integer post_id) {
		post_repo.deleteById(post_id);;
		
	}

	@Override
	public Post atualizar(Post post) {
		return post_repo.save(post);
	}

	@Override
	public List<Post> listarRegistros() {
		UsuarioSecurity us = UsuarioServiceImpl.UsuarioLogado();
		if(us == null) {
			throw new AuthException("Acesso Negado");
		}
		
		return post_repo.getPostsLikes(us.getId());
	}

	@Override
	public Post buscarId(Integer post_id) {
		Optional<Post> post = this.post_repo.findById(post_id);
		return post.orElseThrow(() -> new ObjectNotFound("Objeto "+ post_id +" não encontrado!"));
	}

	public List<Categoria> getCategorias(){
		return this.categoria_repo.findAll();
	}
	
	public List<Post> getTopLikes(){
		return this.post_repo.getTopLikes();
	}
	
	public Integer countPosts() {
		return this.post_repo.countPosts();
	}
	
	public Integer countLikes() {
		return this.post_repo.countLikes();
	}
	

	public Integer countComment() {
		return this.post_repo.countComments();
	}
	
	public Integer countUsers() {
		return this.post_repo.countUsers();
	}
}
