package br.idea.project.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.idea.project.entity.Pais;
import br.idea.project.service.PaisServiceImpl;

@RestController
@RequestMapping("/pais")
public class PaisResource {
	@Autowired
	private PaisServiceImpl service;
	
	public PaisResource() {
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pais>> findAll() {
		List<Pais> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}

}
