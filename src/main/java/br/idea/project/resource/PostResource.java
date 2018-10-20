package br.idea.project.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.idea.project.dto.IdeiaDTO;
import br.idea.project.entity.Categoria;
import br.idea.project.entity.Post;
import br.idea.project.service.PostServiceImpl;

@RestController
@RequestMapping("/posts")
public class PostResource {

	public PostResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private PostServiceImpl service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> find(@PathVariable Integer id) {
		Post obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findAll() {
		List<Post> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count",method = RequestMethod.GET)
	public ResponseEntity<Integer> countPosts() {
		Integer obj = service.countPosts();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/likes",method = RequestMethod.GET)
	public ResponseEntity<Integer> countLikes() {
		Integer obj = service.countLikes();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/users", method = RequestMethod.GET)
	public ResponseEntity<Integer> countUsers() {
		Integer obj = service.countUsers();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/comments", method = RequestMethod.GET)
	public ResponseEntity<Integer> countComments() {
		Integer obj = service.countComment();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/categoria",method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> getCategorias() {
		List<Categoria> obj = service.getCategorias();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/rank",method = RequestMethod.GET)
	public ResponseEntity<List<IdeiaDTO>> getTopLikes() {
		List<Post> obj = service.getTopLikes();
		List<IdeiaDTO> dto = obj.stream().map(ob -> new IdeiaDTO(ob)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		post = service.salvar(post);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePost(@RequestBody Post post, @PathVariable Integer id) {
		service.buscarId(id);
		post.setId(id);
		post = service.atualizar(post);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePost(@PathVariable("id") Integer post_id){
		this.service.buscarId(post_id);
		this.service.deletar(post_id);
		return ResponseEntity.noContent().build();
	}
}
