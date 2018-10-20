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

import br.idea.project.entity.Comentario;
import br.idea.project.service.CommentServiceImpl;

@RestController
@RequestMapping("/comments")
public class ComentarioResource {

	public ComentarioResource() {

	}

	@Autowired
	private CommentServiceImpl service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Comentario> find(@PathVariable Integer id) {
		Comentario obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findByPost(@PathVariable("id") Integer post_id) {
		List<Comentario> obj = service.buscarPostId(post_id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findAll() {
		List<Comentario> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Comentario> addPost(@RequestBody Comentario comment) {
		comment = service.salvar(comment);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
