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

import br.idea.project.entity.Feed;
import br.idea.project.service.FeedServiceImpl;

@RestController
@RequestMapping("/feed")
public class FeedResource {

	public FeedResource() {

	}

	@Autowired
	private FeedServiceImpl service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Feed> find(@PathVariable Integer id) {
		Feed obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Feed>> findAll() {
		List<Feed> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Feed> addPost(@RequestBody Feed feed) {
		feed = service.salvar(feed);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(feed.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
