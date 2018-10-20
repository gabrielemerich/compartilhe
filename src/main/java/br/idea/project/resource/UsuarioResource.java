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

import br.idea.project.dto.UsuarioDTO;
import br.idea.project.entity.Usuario;
import br.idea.project.service.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
	
	public UsuarioResource() {
			
		}
	@Autowired
	private UsuarioServiceImpl user_service;
	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id){
		Usuario obj = user_service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(value="us", method=RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> find(){
		UsuarioDTO obj = user_service.getUserLogado();
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> obj = user_service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, produces = {"application/json"})
	public ResponseEntity<Void> addUser(@RequestBody UsuarioDTO user){
		Usuario obj = user_service.fromDTO(user);
		user_service.salvar(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	

}
