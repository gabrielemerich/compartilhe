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

import br.idea.project.entity.TaskBoard;
import br.idea.project.service.TaskBoardServiceImpl;

@RestController
@RequestMapping("/taskboard")
public class TaskBoardResource {

	public TaskBoardResource() {

	}

	@Autowired
	private TaskBoardServiceImpl service;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<TaskBoard> find(@PathVariable Integer id) {
		TaskBoard obj = service.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "equipe/{id}", method = RequestMethod.GET)
	public ResponseEntity <List<TaskBoard>> findByEquipe(@PathVariable Integer id) {
		List<TaskBoard> obj = service.listByEquipe(id);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TaskBoard>> findAll() {
		List<TaskBoard> obj = service.listarRegistros();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<TaskBoard> addEquipe(@RequestBody TaskBoard taskboard) {
		taskboard = service.salvar(taskboard);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskboard.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePost(@RequestBody TaskBoard tb, @PathVariable Integer id) {
		service.buscarId(id);
		tb.setId(id);
		tb = service.atualizar(tb);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTaskBoard(@PathVariable("id") Integer tb_id){
		this.service.buscarId(tb_id);
		this.service.deletar(tb_id);
		return ResponseEntity.noContent().build();
	}
}
