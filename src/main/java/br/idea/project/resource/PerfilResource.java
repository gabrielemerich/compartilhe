package br.idea.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.idea.project.entity.Perfil;
import br.idea.project.service.PerfilServiceImpl;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {

	public PerfilResource() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private PerfilServiceImpl service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Perfil> find(@PathVariable Integer id) {
		Perfil obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/posts/{id}", method = RequestMethod.GET)
	public ResponseEntity <Integer> countPosts(@PathVariable Integer id) {
		Integer obj = service.countPosts(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/equipes/{id}", method = RequestMethod.GET)
	public ResponseEntity <Integer> countEquipe(@PathVariable Integer id) {
		Integer obj = service.countEquipe(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "count/likes/{id}", method = RequestMethod.GET)
	public ResponseEntity <Integer> countLikes(@PathVariable Integer id) {
		Integer obj = service.countLikes(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Perfil>> findAll() {
		List<Perfil> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}

	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePost(@RequestBody Perfil perfil, @PathVariable Integer id) {
		Perfil p = service.buscarId(id);
		perfil.setId(id);
		perfil.setUsuario(p.getUsuario());
		perfil = service.atualizar(perfil);
		return ResponseEntity.noContent().build();
	}
	
}
