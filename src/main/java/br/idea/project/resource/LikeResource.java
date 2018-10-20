package br.idea.project.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.idea.project.entity.Like;
import br.idea.project.service.LikeServiceImpl;

@RestController
@RequestMapping("/likes")
public class LikeResource {
 
	@Autowired
	private LikeServiceImpl like_service;
	
	public LikeResource() {
		
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Like> addLike(@RequestBody Like like) {
		like = like_service.salvar(like);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(like.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Like>> findAll() {
		List<Like> obj = like_service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/post/{id}", method = RequestMethod.GET)
	public ResponseEntity <Integer> countLikes(@PathVariable Integer id) {
		Integer obj = like_service.getCountLikesPost(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "{post_id}/{user_id}", method = RequestMethod.DELETE)
	public ResponseEntity<Like> findByPost(@PathVariable("post_id") Integer post_id, @PathVariable("user_id") Integer user_id) {
		this.like_service.deletar(post_id, user_id);
		return ResponseEntity.noContent().build();
	}

}
