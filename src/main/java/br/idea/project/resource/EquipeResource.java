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

import br.idea.project.entity.Equipe;
import br.idea.project.service.EquipeServiceImpl;

@RestController
@RequestMapping("/equipe")
public class EquipeResource {

	public EquipeResource() {

	}

	@Autowired
	private EquipeServiceImpl service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Equipe> find(@PathVariable Integer id) {
		Equipe obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Equipe>> findAll() {
		List<Equipe> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
		equipe = service.salvar(equipe);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipe.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePost(@RequestBody Equipe equipe, @PathVariable Integer id) {
		service.buscarId(id);
		equipe.setId(id);
		equipe = service.atualizar(equipe);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEquipe(@PathVariable("id") Integer equipe_id){
		this.service.buscarId(equipe_id);
		this.service.deletar(equipe_id);
		return ResponseEntity.noContent().build();
	}
}
